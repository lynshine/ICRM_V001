package com.lyn.domain;

public class User {
	private Integer uid;
	private String uname;
	private String password;
	private String nickname;
	private Character state;
	
	
	public Character getState() {
		return state;
	}
	public void setState(Character state) {
		this.state = state;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", nickname=" + nickname + "]";
	}
	
	

}
