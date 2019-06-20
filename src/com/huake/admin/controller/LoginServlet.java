package com.huake.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.admin.model.AdminDaoImpl;
import com.huake.pojo.Admin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Admin accept = accept(request);
		String loginUser = new AdminDaoImpl().loginUser(accept);
		JSONObject jo = new JSONObject();
		jo.put("flag", loginUser);
		response.getWriter().print(jo);
	}
	private Admin accept(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin user = new Admin();
		user.setUname(name);
		user.setUpass(password);
		return user;
	}
}

