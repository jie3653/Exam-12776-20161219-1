package pojo;

import java.io.Serializable;

public class Language implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer language_id;
	private String name;
	private java.sql.Timestamp last_update;
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.sql.Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(java.sql.Timestamp last_update) {
		this.last_update = last_update;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
