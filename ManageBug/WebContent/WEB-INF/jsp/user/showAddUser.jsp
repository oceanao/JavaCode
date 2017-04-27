<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css"
	type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui/demo/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<p>
		当前位置：<a href="${pageContext.request.contextPath }/user/hello"
			target="iFrame1 ">管理员</a> / <a
			href="${pageContext.request.contextPath }/user/addUser?flag=1"
			target="iFrame1 ">添加用户</a>
	</p>
	<h1 align="center">添加用户</h1>

	<br>
	<br>
	<br>
	<div align="center">${sessionScope.usermsg}</div>
	<form action="${pageContext.request.contextPath }/user/addUser"
		id="userForm" method="post">
		<!-- 隐藏表单，flag表示添加标记 -->
		<input type="hidden" name="flag" value="2">
		<div align="center">
			学号： <input type="text" name="student_num" id="student_num" size="20"
				style="width: 200px; height: 30px; font-size: 18px;"
				required="required" onkeyup="javascript:chkmaxsms(this,'10')" />
		</div>
		<br> <br>
		<div align="center">
			姓名：<input type="text" name="username" id="username" size="20"
				required="required" onkeyup="javascript:chkmaxsms(this,'12')"
				onclick="num()" style="width: 200px; height: 30px; font-size: 18px;" />
		</div>
		<br> <br>
		<div align="center">
			密码：<input type="password" name="password" id="password" size="20"
				required="required" onkeyup="javascript:chkmaxsms(this,'10')"
				style="width: 200px; height: 30px; font-size: 18px;"  onclick="password1()"/>
		</div>
		<br> <br>
		<div align="center">
			角色： <select id="role" name="role"
				style="width: 200px; height: 30px; font-size: 18px;"
				required="required"  >

				<option value="1">测试人员</option>
				<option value="2">开发人员</option>
			</select>
		</div>
		<br> <br>
		<div align="center">
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="添加"
				onclick="inhit()" style="width: 120px;height: 30px;background-color: #0198f1; color: white;">
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="取消 "
				style="width: 120px;height: 30px;background-color: #0198f1; color: white;">
		</div>
	</form>


	<!--  输入框字数限制-->
	<script language="javascript" type="text/javascript">
		function chkmaxsms(vobj1, vmax) {
			var str = vobj1.value;
			var strlen = str.length;

			if (strlen > vmax) {
				alert('摘要字数超过限制');
				eval_r(vobj1.value = str.substr(0, vmax));
			}
		}
	</script>
	<script type="text/javascript">
	function inhit()
	{
	var a=document.getElementById("role").value;  
	if(a==0) 
	{
		alert("未选择角色，请选择角色"); 
		self.location='jb51.htm'; 
	}
	}
	function  num()
	{
		var a=document.getElementById("student_num").value;  
		if(isNaN(a))
			alert(" 请输入数字")
			else
		if(a.length<8||a.length>10||a.length==9)
			alert(" 学号 请输入8位或者10位数字")
	}
	 function  password1()
	{ 
		var x=document.getElementById("password").value;  
		if(x.length<6||x.length>20)
			alert("密码长度为6--20位")
	}
	</script>

</body>
</html>
