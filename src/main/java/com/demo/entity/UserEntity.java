package com.demo.entity;

import java.util.Date;

/**
 * @author renshuai
 * @deprecated 用户表数据实例
 * @table t_users
 */
public class UserEntity {
	private int id;
	private String name;
	private int age;
	private String state;
	private Date createDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
