<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品登记</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/form.css">
	<script type="text/javascript" src="/ThreeTest/admin/js/jquery-1.8.3.js"></script>
  </head>
	<body> <!-- enctype="mutipart/form-data" -->
	<form action="/ThreeTest/AddGoodsServlet" method="post" class="basic-grey">
		<label> 
			<span>商品标题：</span><input id="title" type="text" name="title" placeholder="请输入商品标题" /><br/>
		</label>
		<label> 
			<span>商品原价：</span><input id="oldMoney" type="text" name="oldMoney" placeholder="请输入商品原价" /><br/>
		</label>
		<label> 
			<span>商品现价：</span><input id="money" type="text" name="money" placeholder="请输入商品现价" /><br/>
		</label>
		<label> 
			<span>商品编号：</span><input id="goodNumber" type="text" name="goodNumber" placeholder="请输入商品编号" /><br/>
		</label>
		<label> 
			<span>商品介绍：</span><textarea id="goodIntroduction" type="text" name="goodIntroduction" placeholder="请输入商品介绍" ></textarea><br/>
		</label>
		<label> 
			<span>售出数量：</span><input id="sellNumber" type="text" name="sellNumber" placeholder="请输入售出数量" /><br/>
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
			<div id="nologin"></div>
			<label class="add" for="file">
				<img id="add1" src="https://admincrm.mccrm.cn/assets/images/addport.png" >
			</label>
			<input type="file" id="file" multiple="multiple" accept=".png,.jpg" value="" hidden="hidden" />
			<input hidden="hidden" id="images" name="images" value="" />
		</div>
		<label style="width: 47px; height: 28px; margin-left: 250px;"> 
			<input type="submit" class="save" value="保存" />
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
			    console.log(txt);
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
	
	$(function() {
		// 弹出商品信息表单
		$(".writerInfo").on("click", function() {
			popWin.showWin("500", "400", "商品信息录入", "project.jsp");
		});
		// 绑定保存按钮的点击事件
		$(".save").on("click",function(){
			// 校验数据 id选择器
			var title = $("#title").val();
			var oldMoney = $("#oldMoney").val();
			var money = $("#money").val();
			var goodNumber = $("#goodNumber").val();
			var goodIntroduction = $("#goodIntroduction").val();
			var sellNumber = $("#sellNumber").val();
			if(title.length<=0) {
				alert("商品标题不能为空");
				$("#title").focus();
				return false;
			}
			if(oldMoney.length<=0) {
				alert("商品原价不能为空");
				$("#oldMoney").focus();
				return false;
			}
			if(money.length<=0) {
				alert("商品现价不能为空");
				$("#money").focus();
				return false;
			}
			if(goodNumber.length<=0) {
				alert("商品编号不能为空");
				$("#goodNumber").focus();
				return false;
			}
			if(goodIntroduction.length<=0) {
				alert("商品描述不能为空");
				$("#goodIntroduction").focus();
				return false;
			}
			if(sellNumber.length<=0) {
				alert("售出数量不能为空");
				$("#sellNumber").focus();
				return false;
			}
			
			// 数据提交后台
			/* $.ajax({
				url:"/OneTest/AddProductServlet",  // 请求后台的地址
				type:"get",
				data:{
					"productName":product_name,
					"productType":product_type,
					"productStatus":product_status,
					"productDesc":product_desc
				},
				dataType:"json",
				success:function(data){
					if(data.status=='1') {
						window.location.href = "ProductServlet";
						window.close();
					} else {
						alert("商品信息录入失败!");
					}
				},
				error:function(){
					alert("ajax参数校验异常!");
				}
			}) */
		});

		
	});
	</script>
</body>
</html>
