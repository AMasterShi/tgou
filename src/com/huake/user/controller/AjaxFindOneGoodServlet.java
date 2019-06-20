package com.huake.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.huake.admin.model.GoodsDaoImpl;
import com.huake.pojo.Goods;

@WebServlet("/AjaxFindOneGoodServlet")
public class AjaxFindOneGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String gid = request.getParameter("goodsId");
		JSONObject jo = new JSONObject();
		if(gid == null || "".equals(gid)) {
			response.getWriter().print(jo);
			return;
		}
		int id = Integer.parseInt(gid);
		Goods goods = new GoodsDaoImpl().findOneGoods(id);
		jo.put("data", goods);
		response.getWriter().print(jo);
	}
}
