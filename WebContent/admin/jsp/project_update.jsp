<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>商品信息修改页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/form.css">
	<script type="text/javascript" src="admin/js/jquery-1.8.3.js"></script>
	<style>
		.basic-grey {
			margin-top: 120px;
		}
	</style>
  </head>
	<body style="background-color:black;">
	<form action="/ThreeTest/UpdateGoodsServlet" id="projectForm" style="width: 800px;" method="post" class="basic-grey">
		<input type="hidden" name="goodsId" value="${goodsInfo.getId() }" id="project_id" />
		<label> 
			<span>商品标题：</span><input id="title" type="text" name="title" placeholder="请输入商品标题" value="${goodsInfo.getTitle() }" /><br/>
		</label>
		<label> 
			<span>商品原价：</span><input id="oldMoney" type="text" name="oldMoney" placeholder="请输入商品原价" value="${goodsInfo.getOldMoney() }" /><br/>
		</label>
		<label> 
			<span>商品现价：</span><input id="money" type="text" name="money" placeholder="请输入商品现价" value="${goodsInfo.getMoney() }" /><br/>
		</label>
		<label> 
			<span>商品编号：</span><input id="goodNumber" type="text" name="goodNumber" placeholder="请输入商品编号" value="${goodsInfo.getGoodNumber() }" /><br/>
		</label>
		<label> 
			<span>商品介绍：</span><textarea id="goodIntroduction" type="text" name="goodIntroduction" placeholder="请输入商品介绍" >${goodsInfo.getGoodIntroduction() }</textarea><br/>
		</label>
		<label> 
			<span>售出数量：</span><input id="sellNumber" type="text" name="sellNumber" placeholder="请输入售出数量" value="${goodsInfo.getSellNumber() }" /><br/>
		</label>
		<label> 
			<span>新品上市？</span>
			<select name="newgoods" id="newgoods">
					<option value="1">是</option>
					<option value="0">否</option>
			</select>
			<br/>
		</label>
		<label> 
			<span>畅销商品？</span>
			<select name="sellwell" id="sellwell">
					<option value="1">是</option>
					<option value="0">否</option>
			</select>
			<br/>
		</label>
		<div> 
			<span>商品图片：</span>
			<div id="nologin"><img src="${goodsInfo.getImages() }" width="50px" height="50px" /></div>
			<label class="add" for="file">
				<img id="add1" src="https://admincrm.mccrm.cn/assets/images/addport.png" >
			</label>
			<input type="file" id="file" multiple="multiple" accept=".png,.jpg" value="" hidden="hidden" />
			<input hidden="hidden" id="images" name="images" value="${goodsInfo.getImages() }" />
		</div>
		<label> 
			<span>&nbsp;</span> 
			<input type="submit" class="button" id="save" value="保存" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="button"  id="back_list" value="返回列表" />
		</label>
	</form>
<script type="text/javascript">
/* 通过将图片转为base64格式传递给后台 */
var input = document.getElementById('file');
input.style.opacity = 0;
function ProcessFile() {
	var file = document.getElementById('file').files[0];
	if (file) {
		var reader = new FileReader();
		reader.onload = function (event) {
			var txt = event.target.result;
			var nologin = document.getElementById("nologin");
			nologin.innerHTML = "<img src='"+txt+"'width='50px' height='50px'/>";
		    //console.log(file.name);
		    //console.log(txt);
			var images = document.getElementById("images");
			images.value = txt;
		};
	}
	reader.readAsDataURL(file);
}

function contentLoaded() {
	document.getElementById('file').addEventListener('change',
		ProcessFile, false);
}

window.addEventListener("DOMContentLoaded", contentLoaded, false);

$(function(){
	$("#back_list").on("click",function(){
		location.href = "/ThreeTest/GoodsServlet";
	});
});
</script>
</body>
</html>
