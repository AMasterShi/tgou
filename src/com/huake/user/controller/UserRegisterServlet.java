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

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User accept = accept(request);
		int i = new UserDaoImpl().userRegister(accept);
		JSONObject jo = new JSONObject();
		if(i > 0) {
			jo.put("resultCode", 1);
			jo.put("message", "恭喜您注册成功！");
		}else {
			jo.put("resultCode", 0);
			jo.put("message", "很抱歉注册失败！");
		}
		response.getWriter().print(jo);
	}

	private User accept(HttpServletRequest request) {
		String uname = request.getParameter("account");
		String upass = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(uname,upass,email);
		return user;
	}
}
