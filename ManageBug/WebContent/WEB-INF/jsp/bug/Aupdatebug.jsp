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
<a href="${pageContext.request.contextPath }/bug/selectBug" target= "iFrame1 ">管理缺陷</a>
/
<a href="${pageContext.request.contextPath }/bug/updateBug?flag=1&&bug_id=${bug.bug_id}">
									修改缺陷</a>
</p>
<h1 align="center">修改缺陷</h1>


<br>
<div align="center">
	<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
		<tr valign="top">
			<td>
				<form action="${pageContext.request.contextPath }/bug/updateBug"
					id="bugForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2"> <input
						type="hidden" name="bug_id" value="${bug.bug_id }">
					<table width="100%" border="0" cellpadding="0" cellspacing="10">
						<tr>
							<td>缺陷项目： <select id="pro_id" name="pro_id"
								  style="width: 200px; height: 40px; font-size: 18px;">
									<option value="0">--请选择项目--</option>
									<c:forEach items="${requestScope.projects }" var="project">
										<c:choose>
											<c:when test="${bug.project.pro_id == project.pro_id }">
												<option value="${project.pro_id }" selected="selected">${project.pro_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${project.pro_id }">${project.pro_name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>

							</select> 
							&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
									&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 		
							缺陷标题：<input type="text" name="summary" id="summary" required="required" 
								size="20" value="${bug.summary }" style="width: 200px; height: 40px; font-size: 18px;" /></td>

						</tr>


						<tr>
							<td>严重级别： <select id="bugseverity_id"
								name="bugseverity_id"  
								style="width: 200px; height: 40px; font-size: 18px;">
									<option value="0">--请选择缺陷严重级别--</option>
									<c:forEach items="${requestScope.bugseveritys }"
										var="bugseverity">
										<c:choose>
											<c:when
												test="${bug.bugseverity.bugseverity_id == bugseverity.bugseverity_id }">
												<option value="${bugseverity.bugseverity_id }"
													selected="selected">${bugseverity.severity}</option>
											</c:when>
											<c:otherwise>
												<option value="${bugseverity.bugseverity_id }">${bugseverity.severity }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
									&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 	
							  提交人：&nbsp;&nbsp;&nbsp;  
							  <select id="reporter_id" name="reporter_id"
							  style="width: 200px; height: 40px; font-size: 18px;">
									<option value="${bug.reporter.user_id } " selected="selected">${bug.reporter.username}</option>
							</select></td>
						</tr>
                      <br> <br>
						<tr>
							<td>缺陷状态： <select id="bug_status" name="bug_status"
								 style="width: 200px; height: 40px; font-size: 18px;">
									<option value="0">--请选择状态--</option>
									<c:choose>
										<c:when test="${bug.bug_status == 1 }">
											<option value="1" selected="selected">New</option>
											<option value="2">Open</option>
											<option value="3">Assigned</option>
											<option value="4">handled</option>
											<option value="5">Closed</option>
											<option value="6">Reopen</option>
										</c:when>
										<c:when test="${bug.bug_status == 2 }">
											
											<option value="1">New</option>
											<option value="2" selected="selected">Open</option>
											<option value="3">Assigned</option>
											<option value="4">handled</option>
											<option value="5">Closed</option>
											<option value="6">Reopen</option>
										</c:when>
										<c:when test="${bug.bug_status == 3 }">
											
											<option value="1">New</option>
											<option value="2">Open</option>
											<option value="3" selected="selected">Assigned</option>
											<option value="4">handled</option>
											<option value="5">Closed</option>
											<option value="6">Reopen</option>
										</c:when>
										<c:when test="${bug.bug_status == 4 }">
											
											<option value="1">New</option>
											<option value="2">Open</option>
											<option value="3" >Assigned</option>
											<option value="4" selected="selected">handled</option>
											<option value="5">Closed</option>
											<option value="6">Reopen</option>
										</c:when>
										<c:when test="${bug.bug_status == 5 }">
											
											<option value="1">New</option>
											<option value="2">Open</option>
											<option value="3" >Assigned</option>
											<option value="4" >handled</option>
											<option value="5" selected="selected">Closed</option>
											<option value="6">Reopen</option>
										</c:when>
											<c:when test="${bug.bug_status == 6 }">
											
											<option value="1">New</option>
											<option value="2">Open</option>
											<option value="3" >Assigned</option>
											<option value="4" >handled</option>
											<option value="5" >Closed</option>
											<option value="6" selected="selected">Reopen</option>
										</c:when>
										
							</c:choose>
							</select>
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
									&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 	
							 处理人：&nbsp;&nbsp;&nbsp; 
							 <select id="handler_id" name="handler_id"
							  style="width: 200px; height: 40px; font-size: 18px;">
									<option value="0">--请选择处理人--</option>
									<c:forEach items="${requestScope.users }" var="user">
										<c:choose>
											<c:when test="${bug.handler.user_id == user.user_id }">
												<option value="${user.user_id }" selected="selected">${user.username}</option>
											</c:when>
											<c:otherwise>
												<option value="${user.user_id }">${user.username }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>

							</select></td>
						</tr>
  <br> <br>
						<tr>
							<td>处理结果： <select id="bug_result" name="bug_result"
							  style="width: 200px; height: 40px; font-size: 18px;">
									<option value="0">--请选择处理结果--</option>
									<c:choose>
										<c:when test="${bug.bug_result == 1 }">
											<option value="1" selected="selected">Fixed</option>
											<option value="2">Rejected</option>
											<option value="3">Postponed</option>
											<option value="4">Duplicate</option>
										</c:when>
										<c:when test="${bug.bug_result == 2 }">
											<option value="1">Fixed</option>
											<option value="2" selected="selected">Rejected</option>
											<option value="3">Postponed</option>
											<option value="4">Duplicate</option>
										</c:when>
										<c:when test="${bug.bug_result == 3 }">
											<option value="1">Fixed</option>
											<option value="2">Rejected</option>
											<option value="3" selected="selected">Postponed</option>
											<option value="4">Duplicate</option>
										</c:when>
										<c:when test="${bug.bug_result == 4 }">
											<option value="1">Fixed</option>
											<option value="2">Rejected</option>
											<option value="3">Postponed</option>
											<option value="4" selected="selected">Duplicate</option>
										</c:when>
										<c:otherwise>
												<option value="1">Fixed</option>
											<option value="2">Rejected</option>
											<option value="3">Postponed</option>
											<option value="4">Duplicate</option>
											</c:otherwise>
									</c:choose>

							</select>
							</td>
							</tr>
						
						
					
					<tr>
							<td>
							<input   type ="hidden"  name="bug_os" id="bug_os" size="20"required="required" 
								value="${bug.bug_os }"  />
							<p>环境配置：</p> <textarea  name="bug_os" id="os" size="20"   style="width: 700px; height: 30px; font-size:18px;"></textarea></td>
						</tr>
					
							<tr>
							<input   type ="hidden" name="bug_description" id="bug_description" required="required" 
								size="60" value="${bug.bug_description }" />
							<td><p>步骤描述：</p>
							<textarea name="bug_description"  id="description"
								value="${bug.bug_description }"  style="width: 700px; height: 300px; font-size:18px;"></textarea></td>
						</tr>

						<tr>
						<input type="hidden" name="bug_comment" id="bug_comment" size="20" required="required" 
								value="${bug.bug_comment }" />
								<td><p>评论：</p>
								<textarea name="bug_comment" id="comment" size="20"
								value="${bug.bug_comment }"  style="width: 700px; height: 120px; font-size:18px;"></textarea></td>
						</tr>
	                       <tr>
							<td ><input type="submit" value="修改" style="width: 200px;height: 40px;background-color: #0198f1;color: white;">&nbsp;&nbsp;<input
								type="reset" value="取消 " style="width: 200px;height: 40px; background-color: #0198f1;color: white;"></td>
				
						</tr> 
						
					</table>
				</form>
			</td>
		</tr>
	</table>
	</div>
	<div style="height: 10px;"></div>
				 <script type="text/javascript">
              
                       document.getElementById('description').value=document.getElementById('bug_description').value;
                       document.getElementById('os').value=document.getElementById('bug_os').value;
                       document.getElementById('comment').value=document.getElementById('bug_comment').value; 
      </script>
</body>
</html>