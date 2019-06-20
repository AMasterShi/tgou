<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sequence">
		<span>&nbsp;&nbsp;排序方式:</span> <a href="user/jsp/index.jsp" id="moren">默认</a> <a href="/ThreeTest/SellWellGoodsServlet">畅销商品</a>
		<a href="/ThreeTest/NewGoodsServlet">新品上架</a> <a href="/ThreeTest/OrderGoodsByPriceDESC"
			id="up">价格从高到低</a> <a href="/ThreeTest/OrderGoodsByPrice" class="ative" id="down" >价格从低到高</a>
	</div>
</body>
</html>