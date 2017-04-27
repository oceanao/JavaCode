<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/user.css" type="text/css" rel="stylesheet" />
</head>
<body>
<h1 align="center">缺陷严重级别详情</h1>
<br>
<br>
<div align="center">
<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
 <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="80%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr  align="center" >
			  <td style="width: 50px;font-size: 20px;">序号</td>
			  <td style="width: 100px;font-size: 20px;">缺陷级别</td>
			  <td style="font-size: 20px;">说明</td>
			  
			</tr>
			<c:forEach items="${requestScope.bugseveritys}" var="bugseverity" varStatus="stat">
			    	<tr id="data_${stat.index}"  align="center" >
					<td align="center" >${stat.count}</td>
					 <td align="center">${bugseverity.severity}</td>
					  <td align="left" >${bugseverity.remark }</td>
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  </table>
	  </div>
</body>
</html>