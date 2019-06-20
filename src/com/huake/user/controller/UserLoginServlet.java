package com.huake.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.pojo.User;
import com.huake.user.model.UserDaoImpl;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("account");
		String upass = request.getParameter("password");
		System.out.println("uname:"+uname+",upass:"+upass);
		User user = new User(uname,upass);
		JSONObject jo = new JSONObject();
		int i = new UserDaoImpl().userLogin(user);
		if(i > 0) {
			jo.put("resultCode", 1);
			jo.put("message", "登陆成功！");
		}else {
			jo.put("resultCode", 0);
			jo.put("message", "登录失败！");
		}
		jo.put("account", uname);
		response.getWriter().print(jo);
	}

}
