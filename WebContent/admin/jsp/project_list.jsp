<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品列表</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet" type="text/css" href="admin/css/tab.css" />
<link rel="stylesheet" type="text/css" href="admin/css/button.css" />
<script type="text/javascript" src="admin/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="admin/js/popwin.js"></script>

</head>
<body>
	<div>
	<form action="/ThreeTest/LikeGoodsServlet" method="get">
		<table class="imagetable" style="width: 100%; margin: 15px 10px;">
			<tr>
				<td><input type="button" onclick="clickThis()" value="录入商品信息"
					style="margin-left: 10px;" /><br /> 
					
					商品编号：<input type="text"
					 name="goods_number" />
					商品标题描述：<input type="text"
					  name="goods_desc" />
				 <input type="submit" value="查询" style="margin-left: 10px;" /></td>
			</tr>
		</table>
	</form>
	</div>
	<table class="imagetable"
		style="width: 100%; margin: 15px 10px; text-align: center;">
		<tr>
			<th>商品ID</th>
			<th>商品标题</th>
			<th>商品原价</th>
			<th>商品现价</th>
			<th>商品编号</th>
			<th>商品介绍</th>
			<th>商品售出数量</th>
			<th>商品图片</th>
			<th>新品上市</th>
			<th>畅销商品</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${glist}" var="goods">
			<tr>
				<td>${goods.getId() }</td>
				<td>${goods.getTitle() }</td>
				<td>${goods.getOldMoney()}</td>
				<td>${goods.getMoney() }</td>
				<td>${goods.getGoodNumber() }</td>
				<td>${goods.getGoodIntroduction() }</td>
				<td>${goods.getSellNumber()}</td>
				<td><img src="${goods.getImages() }"></td>
				<td>
					<c:if test="${goods.getNewgoods() == 0 }">
					  否
					</c:if>
					<c:if test="${goods.getNewgoods() == 1}">
					  是
					</c:if>
				</td>
				<td>
					<c:if test="${goods.getSellwell() == 0 }">
					  否
					</c:if>
					<c:if test="${goods.getSellwell() == 1}">
					  是
					</c:if>
				</td>
				<td><input type="button" value="编辑"
					onclick="fn_update('${ goods.getId()}')" /> 
					<input type="button" value="删除"
					onclick="fn_delete('${goods.getId()}')" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		/* 删除商品信息 */
		function fn_delete(goodsId) {
			if (confirm("是否要删除商品信息?")) {
				$.ajax({
					url : "DeleteGoodsServlet",
					type : "get",
					dataType : "json",
					data : {
						"goodsId" : goodsId
					},
					success : function(data) {
						if (data.keys == 1) {
							alert("删除成功!");
							location.reload();// 刷新数据
						} else {
							alert("删除失败!");
						}
					},
					error : function() {
						alert("ajax参数错误!");
					}
				});

			} else {
				alert("取消删除");
			}
		}
		/* 编辑 */
		function fn_update(goodsId) { // 回显数据
			location.href = "FindOneGoodsServlet?goodsId=" + goodsId;
		}
		// 弹出商品信息表单
		function clickThis() {
			window.location.href = "admin/jsp/project.jsp";
		}
	</script>
</body>
</html>
