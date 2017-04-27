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
	<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
 <a href="${pageContext.request.contextPath }/bugseverity/addBugseverity?flag=1" target= "iFrame1 ">添加缺陷级别</a>
</p>
	<h1 align="center">添加缺陷级别</h1>

	<div align="center">
	<br><br><br>
		<td>${sessionScope.bugseveritymsg}</td>
		<form
			action="${pageContext.request.contextPath }/bugseverity/addBugseverity"
			id="bugseverity" method="post">
			<div>
				<input type="hidden" name="flag" value="2">
				<p>缺陷级别：</p>
				<input type="text" name="severity" id="severity" size="20"
				style="width: 550px; height: 30px; font-size: 18px;"  required="required"/>
			
			</div><br>
			<p>说明：</p>
			<textarea type="text" name="remark" id="remark" size="20"
				style="width: 550px; height: 200px; font-size: 18px;"
				onkeyup="javascript:chkmaxsms(this,'20')" required="required"></textarea>
				<br><br><br>
			<div>
				<input type="submit" value="添加 " style="width: 200px;height: 40px; background-color: #0198f1;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				 <input type="reset" value="取消 " style="width: 200px;height: 40px;background-color: #0198f1;">
					
			</div>
	</div>
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
</body>
</html>