package com.huake.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.admin.model.GoodsDaoImpl;
import com.huake.pojo.Goods;

@WebServlet("/FindOneGoodServlet")
public class FindOneGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("goodsId"));
		Goods goods = new GoodsDaoImpl().findOneGoods(id);
		request.setAttribute("good", goods);
		request.getRequestDispatcher("/user/jsp/goodinfo.jsp").forward(request, response);
	}

}
