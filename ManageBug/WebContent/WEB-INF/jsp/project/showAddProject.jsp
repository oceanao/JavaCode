<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加项目</title>
<link href="${pageContext.request.contextPath }/static/js/frame.js"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>

<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
  <a href="${pageContext.request.contextPath }/project/addProject?flag=1" target= "iFrame1 ">添加项目</a>
</p>
<h1 align="center"> 添加项目</h1>

<br><br><br><br>
	<div align="center">
				<form
					action="${pageContext.request.contextPath }/project/addProject"
					id="projectForm" method="post">
			
					                     <input type="hidden" name="flag" value="2">
					                     <br>
					<div>
					
									项目名称：<input type="text" name="pro_name"     id="pro_name" size="20"    required="required" style="width: 300px;height: 40px;" />
							</div>
							<br>
									项目描述：<input type="text" name="pro_description" id="pro_description" size="20"   required="required" style="width: 300px;height: 40px; "/>
									<br>
									<br>
									<div>
									版本号：&nbsp;&nbsp;&nbsp;<input type="text" name="pro_version" id="pro_version" size="20"  required="required" style="width: 300px;height: 40px;" />
									&nbsp;
					</div>
					<br><br>
					<div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input type="submit" value="添加 " 	style="width: 150px; height: 40px;background-color: #0198f1;color: white;">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
							<input type="reset" value="取消 " 	style="width: 150px; height: 40px;background-color: #0198f1;color: white;">
							</div>
							<br>
				</form>
</div> 
</body>
</html>