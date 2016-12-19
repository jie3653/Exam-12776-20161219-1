package service;

import dao.CustomerDAO;
import pojo.Customer;

public class CustomerService {
	 CustomerDAO customerDao = new CustomerDAO();
	public Customer selectOneByName(String name) {
		// TODO Auto-generated method stub
		try {
			return customerDao.selectOneByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
