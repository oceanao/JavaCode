<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link href="${pageContext.request.contextPath }/static/css/login.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<h1 align="center">软件缺陷管理系统</h1>
	<div align="center">
		<div id="login">
			<form action="${pageContext.request.contextPath }/admin/login"
				method="post">
				 <h2>登录</h2>
						<input type="text"           id="ad_username" name="ad_username" placeholder="请输入账号">
						<input type="password"   id="ad_password" name="ad_password" placeholder="请输入密码">
					    <button class="input" type="submit">登录</button>
					    <button class="input " type="reset">重置</button>
			</form>
		</div>
	</div>
	

</body>
</html>



 --%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
 <link href="${pageContext.request.contextPath }/static/css/login.css"
	type="text/css" rel="stylesheet" /> 
</head>
<body>
	<h1 align="center">软件缺陷管理系统</h1>
	<div align="center">
		
		<br></br>
		<div id="background">
        <br>
			<form action="${pageContext.request.contextPath }/admin/login"
				method="post">
				<h2>管理员，请登录</h2>
				<form method="post" >
					<input type="text" id="ad_username" name="ad_username"  required="required"
						placeholder="请输入账号"> 
						<input  type="password" id="ad_password" name="ad_password"  required="required"
						placeholder="请输入密码">
					<button class="but" type="submit">登录</button>
				</form>
				<br>
			</form>

		</div>
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
 