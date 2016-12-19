package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import pojo.Customer;
import service.CustomerService;

public class CustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author �ܽ�
	 * service
	 * �����̨����Ա���й�����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ú�̨����������
		String command = request.getParameter("command");
		if("login".equals(command)){	
			login(request,response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("first_name");
		CustomerService cs = new CustomerService();
		Customer c = cs.selectOneByName(name);
		
	    if(c != null){
	    	System.out.println("��¼�ɹ���");
			
			/*response.sendRedirect(request.getContextPath()
						+ "/Welcome.jsp");*/
			try {
				request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
					
		}else{
			request.setAttribute("info","��¼����");
			try {
				System.out.println("��¼����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
