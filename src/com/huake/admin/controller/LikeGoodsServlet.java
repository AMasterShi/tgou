package com.huake.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huake.admin.model.GoodsDaoImpl;
import com.huake.pojo.Goods;

@WebServlet("/LikeGoodsServlet")
public class LikeGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String goodNumber = request.getParameter("goods_number");
		String title = request.getParameter("goods_desc");
		ArrayList<Goods> likeGoods = null;
		if((goodNumber == null || "".equals(goodNumber)) && (title == null || "".equals(title))) {
			request.getRequestDispatcher("/GoodsServlet").forward(request, response);
			return;
		}
		if(goodNumber != null && (title == null || "".equals(title))) {
			likeGoods = new GoodsDaoImpl().likeGoodsBynum(goodNumber);
		}else if(title != null && (goodNumber == null || "".equals(goodNumber))) {
			likeGoods = new GoodsDaoImpl().likeGoodsBytitle(title);
		}else {
			likeGoods = new GoodsDaoImpl().likeGoods(goodNumber, title);
		}
		request.setAttribute("glist", likeGoods);
		request.getRequestDispatcher("/admin/jsp/project_list.jsp").forward(request, response);
	}

}
