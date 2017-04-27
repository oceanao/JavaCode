<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
 <link href="${pageContext.request.contextPath }/static/css/login.css"
	type="text/css" rel="stylesheet" /> 
</head>
<body>
	<h1 align="center">软件缺陷管理系统</h1>
	<div align="center">
		
		<br></br>
		<div id="background">
        <br>
			<form action="${pageContext.request.contextPath }/user/login"
				method="post">
				<h2>如有账号，请登录</h2>
				<form method="post">
					<input type="text" id="student_num" name="student_num" required="required"
						placeholder="请输入账号"> <input type="password" id="password" required="required"
						name="password" placeholder="请输入密码">
					<button class="but" type="submit">登录</button>
				</form>
				<br> <a href="${pageContext.request.contextPath }/user/regist">注册</a>
				|<a href="${pageContext.request.contextPath }/admin/login">管理员登录</a>
			</form>

		</div>
		<p>注：登录名为学号</p>
		<p>忘记密码请联系管理员</p>
	</div>
	<div align="center">
		<font> copyright © Laboratory </font>
	</div>
	<script type="text/javascript">
		{
			if("${sessionScope.msg}"!="")
	       alert("${sessionScope.msg}");
		}
	</script>
</body>
</html>
