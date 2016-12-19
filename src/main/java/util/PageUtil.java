package util;

import java.util.List;

public class PageUtil<T>{
    int currentPage ; //��ǰ�ڼ�ҳ       �ɲ���currentPage����
    int pageSize ;   //ÿҳ��ʾ�ļ�¼��  �ɲ���pageSize����
    int totalRecord; //�ܼ�¼��           ����sqlִ�в�ѯ��õ��ܼ�¼��  �����sqlΪ select * from emp ����14����¼�����ֵΪ14
    int pageCount;   //��ҳ��           pageCount =totalRecord/pageSize   �迼�������������
    List<T> data;//��ҳ��ѯ������ݴ浽��������   
    public PageUtil(){
    	
    }
    public PageUtil(int currentPage,int pageSize, int totalRecord,int pageCount,List<T> data){
    	this.currentPage = currentPage;
    	this.pageSize = pageSize;
    	this.totalRecord = totalRecord;
    	this.pageCount = pageCount;
    	this.data = data;
    }
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}