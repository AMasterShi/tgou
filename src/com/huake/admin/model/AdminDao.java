package com.huake.admin.model;

import com.huake.pojo.Admin;

public interface AdminDao {
	public int registUser(Admin user);
	public String loginUser(Admin user);
	public Object findUser();
}
