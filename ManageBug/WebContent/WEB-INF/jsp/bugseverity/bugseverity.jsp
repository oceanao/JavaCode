<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
    <a href="${pageContext.request.contextPath }/bugseverity/selectBugseverity" target= "iFrame1 ">查看缺陷级别</a>
</p>
<h1 align="center">缺陷级别</h1>

<br><br>
<div align="center">
<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
 <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
	      
		  <table width="90%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr  align="center">
			  <td style="width: 50px;">序号</td>
			  <td style="width: 80px;">缺陷级别</td>
			  <td style="width: 500px;">说明</td>
			  <td style="width: 50px;">操作1</td>
			  <td style="width: 50px;">操作2</td>
			</tr>
			<c:forEach items="${requestScope.bugseveritys}" var="bugseverity" varStatus="stat">
				<tr id="data_${stat.index}" align="center">
					<td>${bugseverity.bugseverity_id}</td>
					 <td>${bugseverity.severity}</td>
					  <td align="left">${bugseverity.remark }</td>
					   <td align="center" width="40px;"><a href="${pageContext.request.contextPath }/bugseverity/updateBugseverity?flag=1&bugseverity_id=${bugseverity.bugseverity_id}">
							修改</a>
					  </td>
					   <td align="center" width="40px;"><a href="${pageContext.request.contextPath }/bugseverity/removeBugseverity?bugseverity_id=${bugseverity.bugseverity_id}" title="删除">
						<img src="${pageContext.request.contextPath }/static/image/delete.jpg" style="width: 40px;height: 20px;"></a>
					  </td>		  
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  </table>
	  </div>
</body>
</html>