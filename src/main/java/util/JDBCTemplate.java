package util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * �����ṩһЩͨ�õ���ɾ�Ĳ鷽��
 * 
 * @author Administrator
 * 
 */
public class JDBCTemplate {

	/**
	 * 
	 * @param sql
	 *            �����ִ�е�SQL���
	 * @return ����-1��ʾִ��SQL�����쳣 >=0��ʾ�ɹ�ִ��SQL
	 */
	public static int insertOrUpdateOrDelete(String sql) {
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.createStatement();// �˶�����Է���sql�����ݿ�
			// String sql = "update emp set sal = sal+5";
			int res = stmt.executeUpdate(sql);
			// System.out.println("�˴β���Ӱ�������Ϊ��"+res);
			return res;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.closeConnection(conn, null, stmt);
		}
		return -1;
	}
	// insert into emp values(?,?,?,?,?,?...);
	// update emp set sal = sal+?

	// ThreadLocal
	public static int insertOrUpdateOrDelete2(String sql, Object[] values) {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);// �˶�����Է���sql�����ݿ�
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					stmt.setObject(i + 1, values[i]);
				}
			}
			int res = stmt.executeUpdate();
			// System.out.println("�˴β���Ӱ�������Ϊ��"+res);
			return res;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.closeConnection(conn, null, stmt);
		}
		return -1;
	}
	//select * from emp;
	//select * from dept
	//���ͷ���
	public static<T> List<T> queryData(String sql, Object[] values,Class<T> cls) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			connection = JDBCUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			// Ԫ����
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			//���ݿ��е�ÿһ������Ӧ�÷ŵ���Ӧ��Vo����
			
			while (rs.next()) {
				HashMap<String, Object> rowData = new HashMap<String, Object>();//һ��Map��һ������
				
				//����ΪΪkey,����Ϊvalue����һ��HashMap
				//empno 7788
				//enname SCOTT;
				for(int i=0;i<columnCount;i++){
					//ȡ������
					String columnName =  metaData.getColumnName(i+1);
					//ȡ���е��������ͣ��ٵ���rs.getXXX����������ת����Ӧ��java����
					String columnType = metaData.getColumnTypeName(i+1);
					
				//	System.out.println("������"+columnName + "��������:"+columnType +" "+metaData.getScale(i+1));
					//��������ȡ��ֵ
					Object val = null;
					//�������ݿ����������ͣ�ת�ɳɶ�Ӧ��java��������
					//Ŀ���Ǽ��ٷ�������������ж�
					if (columnType.equals("NUMBER") && metaData.getScale(i+1)>0){//��С��λ
						val = rs.getDouble(columnName);
					}else if (columnType.startsWith("VARCHAR")){
						val = rs.getString(columnName);
					}else if (columnType.equals("NUMBER")){//û��С��λ��
						if (rs.getObject(columnName)!=null){
							val = rs.getInt(columnName);
						}
					}else if (columnType.equals("DATE")){
						val = rs.getDate(columnName);
					}
					
					rowData.put(columnName.toLowerCase(), val);
					///rs.getObject(columnIndex)
					
				}
				
				/*System.out.println("----------------------------------");
				System.out.println(rowData);*/
				T t =  MapValueToVo.setMapValueToVo(rowData, cls);//ʹ�÷��佫���ݷ�װ��Vo��
				data.add(t);//��vo�浽������

			}

		} finally {
			JDBCUtil.closeConnection(connection, rs, pstmt);
		}

		return data;
	}
	
	
	
	public static List<Object[]> queryData(String sql, Object[] values) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object[]> data = new ArrayList<Object[]>();
		try {
			connection = JDBCUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			// Ԫ����
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {

				// ����columnCount������Ӧ���ȵ�Object[]����
				Object[] rowData = new Object[columnCount];

				// rs.getObject(1);
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);// ��ȡ���������ݷŵ�Object[]������

				}

				// �����ݼӵ�������
				data.add(rowData);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection, rs, pstmt);
		}

		return data;

	}
	
	public static <T> PageUtil<T> queryDataByPage(String sql, Object[] values,
			int currentPage, int pageSize,Class<T> cls) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			// 1���ݴ���SQL���SQL��ѯ���ܼ�¼��
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // �ܼ�¼��
			while (rs.next()) {
				totalRecord = rs.getInt(1);// ȡ����һ�е�ֵ
			}

			// ����pageSize��5����currentPage��2���������ҳ�ĳ�ʼ�����ͽ�������
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

			// 2����ҳ��ѯ
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql����п�����?�ŵ�λ������ҪΪ�䴫�ݲ�������ҳ��ѯ�л�������������Ҫ����

			List<T> listData = queryData(queryDataSql, values,cls);

			// ȡ��ҳ��ѯ���
			// ������ҳ��:
			int pageCount = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				pageCount = totalRecord / pageSize + 1;
			}

			PageUtil<T> pageUtil = new PageUtil<T>(currentPage, pageSize,
					totalRecord, pageCount, listData);

			return pageUtil;
		} finally {
			JDBCUtil.closeConnection(conn, rs, pstmt);
		}

		
	}
	

	public static PageUtil queryDataByPage(String sql, Object[] values,
			int currentPage, int pageSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			// 1���ݴ���SQL���SQL��ѯ���ܼ�¼��
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // �ܼ�¼��
			while (rs.next()) {
				totalRecord = rs.getInt(1);// ȡ����һ�е�ֵ
			}

			// ����pageSize��5����currentPage��2���������ҳ�ĳ�ʼ�����ͽ�������
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

			// 2����ҳ��ѯ
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql����п�����?�ŵ�λ������ҪΪ�䴫�ݲ�������ҳ��ѯ�л�������������Ҫ����

			List<Object[]> listData = queryData(queryDataSql, values);

			// ȡ��ҳ��ѯ���
			// ������ҳ��:
			int pageCount = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				pageCount = totalRecord / pageSize + 1;
			}

			PageUtil pageUtil = new PageUtil(currentPage, pageSize,
					totalRecord, pageCount, listData);

			return pageUtil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(conn, rs, pstmt);
		}

		return null;

	}

}

