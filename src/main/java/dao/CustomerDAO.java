package dao;

import java.util.List;

import pojo.Customer;
import util.JDBCTemplate;

public class CustomerDAO {
	/**
	 * 根据名字查用户
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Customer selectOneByName(String name) throws Exception{
		String sql = "select * from customer where first_name=?";
		List<Customer> customers = JDBCTemplate.queryData(sql,new String[]{name},Customer.class);
		if(customers != null && customers.size()>0){
			Customer customer = customers.get(0);
			return customer;
		}
		return null;
	}
}
