package pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer customer_id;
	private Integer store_id;
	private String first_name;
	private String last_name;
	private String email;
	private Integer address_id;
	private Integer active;
	private java.sql.Date create_date; //数据库date类型
	private java.sql.Timestamp  last_update;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer customer_id, Integer store_id, String first_name, String last_name, String email,
			Integer address_id, Integer active, Date create_date, Timestamp last_update) {
		super();
		this.customer_id = customer_id;
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.create_date = create_date;
		this.last_update = last_update;
	}
	
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public java.sql.Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(java.sql.Date create_date) {
		this.create_date = create_date;
	}
	public java.sql.Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(java.sql.Timestamp last_update) {
		this.last_update = last_update;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
