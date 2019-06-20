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

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
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
		int i = new AdminDaoImpl().registUser(accept);
		JSONObject jo = new JSONObject();
		jo.put("success",i);
		response.getWriter().print(jo);
	}
	//接收前端数据，将前端数据封装到bean中。
	private Admin accept(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		return new Admin(userName,account,password,phone);
	}
}
