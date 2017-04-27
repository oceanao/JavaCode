<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
<a href="#">修改用户</a>
</p>
<h1 align="center">修改用户信息</h1>

<br><br><br>
				<form action="${pageContext.request.contextPath }/user/updateUser"
					id="userForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2"> 
					<div align="center">
					<input type="hidden" name="user_id" value="${user.user_id }">
				          学号：<input type="text" name="student_num"
											id="student_num" size="20" value="${user.student_num}" 
											style="width: 200px; height: 30px; font-size: 18px;"/>
											</div>
											<br>
											<div align="center">
						姓名：<input type="text" name="username" id="username"
											size="20" value="${user.username }" 
											style="width: 200px; height: 30px; font-size: 18px;"/>
											</div>
											<br>
					<div align="center">
						&nbsp;&nbsp;
						角色： <select id="role" name="role" style="width: 200px; height: 30px; font-size: 18px;">
										
												<c:choose>
												<c:when test="${user.role==1 }">
												<option value="1" selected="selected">测试人员</option>
												<option value="2">开发人员</option>
												</c:when>
												<c:otherwise>
												<option value="1">测试人员</option>
												<option value="2" selected="selected">开发人员</option>
												</c:otherwise>
												</c:choose>
										</select>
										&nbsp;&nbsp;
										</div>
										<br>
										<div align="center">
									密码：<input type="password"
											name="password" id="password" size="20"
											value="${user.password }"style="width: 200px; height: 30px; font-size: 18px;" />
								</div>
								<br>
								<div align="center">
							<input type="submit" value="修改 " style="width: 120px;height: 30px;background-color: #0198f1; color: white;">
							&nbsp;&nbsp;&nbsp;   
							<input type="reset" value="取消 " style="width: 120px;height: 30px;background-color: #0198f1;color: white;">
		                    </div> 

</body>
</html>