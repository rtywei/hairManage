package com.winter.model;

import java.io.Serializable;
import java.util.List;

public class User extends Page implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;
	
	private Integer sex;
	
	private String phone;
	
	private List<Account> accounts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", phone=" + phone + ", accounts="
				+ accounts + "]";
	}

}