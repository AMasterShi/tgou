package com.huake.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.admin.model.GoodsDaoImpl;

@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		System.out.println(goodsId);
		int deleteGoods = new GoodsDaoImpl().deleteGoods(goodsId);
		JSONObject jo = new JSONObject();
		jo.put("keys", deleteGoods);
		response.getWriter().print(jo);
	}

}
