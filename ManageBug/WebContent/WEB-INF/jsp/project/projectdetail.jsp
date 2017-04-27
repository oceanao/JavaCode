<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<h1 align="center">项目详情</h1>
<div align="center">
<br><br><br>
	<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0"
					style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr align="center">
						<td>序号:</td>
						<td>${project.pro_id}</td>
					</tr>
					<tr align="center">
						<td>项目名称:</td>
						<td>${project.pro_name }</td>
					</tr>
					<tr align="center">
						<td>详细信息:</td>
						<td>${project.pro_description }</td>
					</tr>
					<tr align="center">
						<td>版本号:</td>
						<td>${project.pro_version }</td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>