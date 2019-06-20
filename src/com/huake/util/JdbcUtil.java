package com.huake.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private String DriverClass = "com.mysql.jdbc.Driver";/*?useUnicode=true&characterEncoding=UTF-8*/
	private String url = "jdbc:mysql://localhost:3306/tiangou2?characterEncoding=utf8";
	private String username = "user1";
	private String password = "123456";
	private Connection conn = null;
	private static JdbcUtil ju;
	private JdbcUtil() {
		try {
			Class.forName(DriverClass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcUtil newInstance() {
		if(ju == null) {
			ju = new JdbcUtil();
		}
		return ju;
	}
	public Connection getConnection() {
			return conn;
	}
	public void releaseConn(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void releasePs(PreparedStatement ps) {
		try {
			if(ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void releaseRs(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
