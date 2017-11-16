package com.gec.domain;

import java.io.Serializable;

/*create table t_user
	(
	   user_id int not null auto_increment primary key,
	   user_name varchar(20) not null,
	   pass_word varchar(20) not null
	);*/
public class User implements Serializable {
	private Integer userId;
	private String userName;
	private String passWord;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String passWord) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}
