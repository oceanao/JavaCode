<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/user.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
	<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">普通用户</a>
/
<a href="${pageContext.request.contextPath }/user/addBug?flag=1" target= "iFrame1 "> 提交缺陷</a>
</p>
	<h1 align="center">提交缺陷</h1>

	<br>
	<div style="position: absolute; height: 10px; left: 200px;">
		<form action="${pageContext.request.contextPath }/user/addBug"
			id="bugForm" method="post">
			<!-- 隐藏表单，flag表示添加标记 -->
			<input type="hidden" name="flag" value="2">
			<div>
				缺陷标题：
				<input type="text" name="summary"  id="summary"  size="20" required="required" 
					onkeyup="javascript:chkmaxsms(this,'20')" style="width: 300px;height: 30px;" />
				</div>
					<br>
				<div>
					所属项目： <select
					name="pro_id"   style="width: 300px;height: 30px;">
					<option value="0">--请选择项目--</option>
					<c:forEach items="${requestScope.projects }" var="project">
						<option value="${project.pro_id }">${project.pro_name }</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div>
				严重级别： <select id="bugseverity_id" name="bugseverity_id" style="width: 300px;height: 30px;"
					 >
					<option value="0">--请选择缺陷严重级别--</option>
					<c:forEach items="${requestScope.bugseveritys }" var="bugseverity">
						<option value="${bugseverity.bugseverity_id }">${bugseverity.severity }</option>
					</c:forEach>
				</select>
				</div>
					<br>
				<div> 
				缺陷状态： <select id="bug_status" name="bug_status" style="width: 300px;height: 30px;">
					<option value="1" selected="selected">New</option>
					<option value="2">Open</option>
					<option value="3">Assigned</option>
					<option value="4">handled</option>
					<option value="5">Closed</option>
					<option value="6">Reopen</option>
				</select>
			</div>

			<div>
				<p>环境配置：</p>
				<textarea name="bug_os" id="bug_os" size="20" required="required" 
					style="width: 800px; height: 30px; font-size: 18px;"
					onkeyup="javascript:chkmaxsms(this,'100')"> </textarea>
			</div>
			<div>
				<p>具体步骤：</p>
				<textarea name="bug_description" id="bug_description" size="60"
					style="width: 800px; height: 400px; font-size: 18px;" required="required" s
					onkeyup="javascript:chkmaxsms(this,'500')"> </textarea>
			</div>
<br>
			<div align="center">
				<input type="submit" value="添加"  class="but" style="width: 200px;height: 40px;">
				&nbsp;&nbsp; 
				<input type="reset" value="取消 " class="but"  style="width: 200px;height: 40px;">
			</div>
			${requestScope.message }
		</form>
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