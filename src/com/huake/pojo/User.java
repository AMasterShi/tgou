package com.huake.pojo;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String upass;
	private String email;
	private Date create_time;
	private Date update_time;
	public User() {
		super();
	}
	public User(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}
	public User(String uname, String upass, String email) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.email = email;
	}
	public User(int uid, String uname, String upass, String email) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.email = email;
	}
	public User(int uid, String uname, String upass, String email, Date create_time, Date update_time) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.email = email;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", email=" + email + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
}
