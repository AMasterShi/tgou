<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>天狗_综合商城</title>
</head>
<c:if test="${empty glist}" >
	<jsp:forward page="/PageGoodsServlet"></jsp:forward>
</c:if>
<link rel="stylesheet" type="text/css" href="user/css/productList.css" />
<!-- <script type="text/javascript" src="user/js/ajax.js"></script>
<script type="text/javascript" src="user/js/index.js"></script> -->
<body>
	<!-- 导入头部 -->
	<%@ include file="common_top2.jsp"%>
	<!--SubPageMenu-->
	<div id="commonMenu"></div>
	<div id="ListCenter">
		<%@ include file="leftbox2.jsp"%>
		<div class="rightBox">
			<div class="ad">
				<a href="#"><img src="user/img/test/9.png" /> </a>
			</div>
			<c:if test="${empty order }" >
				<%@ include file="order.jsp" %>
			</c:if>
			<c:if test="${order eq 'sellwell' }" >
				<%@ include file="sellwell.jsp" %>
			</c:if>
			<c:if test="${order eq 'newgoods' }" >
				<%@ include file="newgoods.jsp" %>
			</c:if>
			<c:if test="${order eq 'up' }" >
				<%@ include file="up.jsp" %>
			</c:if>
			<c:if test="${order eq 'down' }" >
				<%@ include file="down.jsp" %>
			</c:if>

			<div id="goods">
				<c:forEach var="goods" begin="0" end="${glist.size() }" items="${glist }">
					<div class="product" id="${goods.getGoodNumber() }" onclick="sub(${goods.getId() })">
					<dl>
						<dt>
							<a><img style="width:100%; height:100%" src="${goods.getImages() }" /> </a><span></span>
						</dt>
						<dd>
							<del>市场价：${goods.getOldMoney() }</del>
							元
						</dd>
						<dd>
							<b>${goods.getMoney() }</b>元
						</dd>
						<dd>
							<div  style="overflow:hidden; height: 40px;"><a href=$href$ >${goods.getTitle() }</a></div>
						</dd>
						<dd>
							<span>累计售出${goods.getSellNumber() }件</span>
						</dd>
					</dl>
				</div>
				</c:forEach>
			</div>

			<div class="next">
				一共<span>323</span>条记录，当前第<span>1</span>页，共<span>30</span>页<a
					href="#">上一页</a><a href="#">下一页</a>
			</div>

		</div>
	</div>
	<!-- 导入脚部 -->
	<%@ include file="common_bottom2.jsp"%>
</body>
<script type="text/javascript">
function sub(id){
	window.open("/ThreeTest/user/jsp/goodinfo.jsp?id=" + id);
}
</script>
</html>
