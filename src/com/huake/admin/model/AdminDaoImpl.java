package com.huake.admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huake.pojo.Admin;
import com.huake.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public int registUser(Admin admin) {
		Connection connection = JdbcUtil.newInstance().getConnection();
		String sql = "insert into admin(uname, account, upass, uphone) values(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, admin.getUname());
			 ps.setString(2, admin.getAccount());
			 ps.setString(3, admin.getUpass());
			 ps.setString(4, admin.getUphone());
			 int row = ps.executeUpdate();
			 if(row > 0) {
				 return 1;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.newInstance().releasePs(ps);
		return 0;
	}

	@Override
	public String loginUser(Admin admin) {
		Connection connection = JdbcUtil.newInstance().getConnection();
		String sql = "select * from admin where uname=? and upass=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, admin.getUname());
			 ps.setString(2, admin.getUpass());
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 return "success";
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.newInstance().releaseRs(rs);
		JdbcUtil.newInstance().releasePs(ps);
		return null;
	}

	@Override
	public Object findUser() {
		return null;
	}
	
}
