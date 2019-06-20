package com.huake.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.admin.model.GoodsDaoImpl;
import com.huake.pojo.Goods;

@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Goods goods = accept(request);
		new GoodsDaoImpl().addGoods(goods);
		request.getRequestDispatcher("/GoodsServlet").forward(request, response);
	}

	private Goods accept(HttpServletRequest request) {
		String title = request.getParameter("title");
		String oldMoney = request.getParameter("oldMoney");
		String money = request.getParameter("money");
		String goodNumber = request.getParameter("goodNumber");
		String goodIntroduction = request.getParameter("goodIntroduction");
		String sellNumber = request.getParameter("sellNumber");
		String newgoods = request.getParameter("newgoods");
		String sellwell = request.getParameter("sellwell");
		String images = request.getParameter("images");
		Goods goods = null;
		goods = new Goods(title, Integer.parseInt(oldMoney), Integer.parseInt(money), goodNumber, goodIntroduction, sellNumber, Integer.parseInt(newgoods), Integer.parseInt(sellwell), images);
		return goods;
	}

}
