package com.huake.pojo;

import java.util.Date;

public class Admin {
	private int uid;
	private String uname;
	private String account;
	private String upass;
	private String uphone;
	private Date create_time;
	private Date update_time;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String uname, String account, String upass, String uphone) {
		super();
		this.uname = uname;
		this.account = account;
		this.upass = upass;
		this.uphone = uphone;
	}
	public Admin(String uname, String account, String upass, String uphone, Date create_time, Date update_time) {
		super();
		this.uname = uname;
		this.account = account;
		this.upass = upass;
		this.uphone = uphone;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Admin(int uid, String uname, String account, String upass, String uphone, Date create_time,
			Date update_time) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.account = account;
		this.upass = upass;
		this.uphone = uphone;
		this.create_time = create_time;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
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
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", account=" + account + ", upass=" + upass + ", uphone="
				+ uphone + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
}
