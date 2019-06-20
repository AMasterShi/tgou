package com.huake.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huake.pojo.User;
import com.huake.util.JdbcUtil;

public class UserDaoImpl {
	/* 登录 */
	public int userLogin(User user) {
		Connection connection = JdbcUtil.newInstance().getConnection();
		String sql = "select * from user where uname=? and upass=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, user.getUname());
			 ps.setString(2, user.getUpass());
			 rs = ps.executeQuery();
			 if(rs.next()) {
				 return 1;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.newInstance().releaseRs(rs);
		JdbcUtil.newInstance().releasePs(ps);
		return 0;
	}
	/* 注册 */
	public int userRegister(User user) {
		Connection connection = JdbcUtil.newInstance().getConnection();
		String sql = "insert into user(uname, upass, email) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, user.getUname());
			 ps.setString(2, user.getUpass());
			 ps.setString(3, user.getEmail());
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
}
