package com.huake.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.pojo.Goods;
import com.huake.user.model.GoodsDaoImpl;

@WebServlet("/NewGoodsServlet")
public class NewGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ArrayList<Goods> glist = new GoodsDaoImpl().newGoods();
		request.setAttribute("glist", glist);
		request.setAttribute("order", "newgoods");
		request.getRequestDispatcher("/user/jsp/index2.jsp").forward(request, response);
	}

}
