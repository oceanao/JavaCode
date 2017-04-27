<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title><link href="${pageContext.request.contextPath }/static/css/user.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/static/css/body.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui/jquery.min.js"></script>
</head>
<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">普通用户</a>
/
    <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/mission"  target= "iFrame1 ">复现任务</a>
/<a href="${pageContext.request.contextPath }/user/updateBug?flag=1&&bug_id=${bug.bug_id}">
 处理缺陷</a>
</p>
<h1 align="center"> 处理缺陷</h1>

<div align="center">
	<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
		<tr valign="top">
			<td>
				<form action="${pageContext.request.contextPath }/user/updateBug"
					id="bugForm" method="post">
					<!-- 隐藏表单，flag表示添加标记 -->
					<input type="hidden" name="flag" value="2"> <input
						type="hidden" name="bug_id" value="${bug.bug_id }">
					<table width="100%" border="0" cellpadding="0" cellspacing="10">
<div style="position: absolute;;left: 100px;">
						<tr>
							<td><span>所属项目： ${bug.project.pro_name }</span>
							</td>
							<tr>
							<tr>
							<td><span>缺陷标题：&nbsp;&nbsp;${bug.summary }<span></td>
						</tr>

						<tr>
							<td><span>提交人：&nbsp;&nbsp;${bug.reporter.username}<span></td>
						</tr>
						<tr>
							<td><span>处理人：&nbsp;&nbsp;${bug.handler.username} <span></td>
						</tr>
						<tr>
							<td><span>严重级别： ${bug.bugseverity.severity}</span></td>
						</tr>

						<tr>
							<td>缺陷状态： <select id="bug_status" name="bug_status"
								style="width: 200px;height:30px">
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
							</td>
							</tr>
					<tr>
							<td>处理结果： <select id="bug_result" name="bug_result"
								style="width: 200px;height:30px">
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
							<input   type ="hidden"  name="bug_os" id="bug_os" size="20"
								value="${bug.bug_os }" />
							<p>环境配置：</p> <textarea  name="bug_os" id="os" size="20"   style="width: 600px; height: 40px; font-size:18px;"></textarea></td>
						</tr>
					
							<tr>
							<input   type ="hidden" name="bug_description" id="bug_description"
								size="60" value="${bug.bug_description }" />
							<td><p>步骤描述：</p>
							<textarea name="bug_description"  id="description"
								value="${bug.bug_description }"  style="width: 600px; height: 400px; font-size:18px;"></textarea></td>
						</tr>
              

						

						<tr>
						<input type="hidden" name="bug_comment" id="bug_comment" size="20"
								value="${bug.bug_comment }" />
								<td><p>评论：</p>
								<textarea name="bug_comment" id="comment" size="20"
								value="${bug.bug_comment }"  style="width: 600px; height: 200px; font-size:18px;"></textarea></td>
						</tr>

						<tr>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<td align="left"><input type="submit" value="修改" style="width: 150px;height: 40px;" class="but">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消 "  style="width: 150px;height: 40px;" class="but"></td>
						</tr>
					<tr>
							<c:forEach items="${requestScope.bugfiles }" var="bugfile"
								varStatus="stat">
								<tr id="data_${stat.index}">
									<td>
										<div id="headhovertree">
											<div id="hovertreeshow" class="hovertreeshow">
												<img src="/pic/${bugfile.filename}"
													style="width: 200px; height: 300px;" />
											</div>
											<div style="height: 600px; width: 100%"></div>
											<script type="text/javascript"
												src="${pageContext.request.contextPath }/static/js/body.js"></script>
									</td>
								</tr>
							</c:forEach>

						</tr>
					</div>
					</table>
				</form>
			</td>
		</tr>
	</table>
	</div>
	
	<script type="text/javascript">
              
                       document.getElementById('description').value=document.getElementById('bug_description').value;
                       document.getElementById('os').value=document.getElementById('bug_os').value;
                       document.getElementById('comment').value=document.getElementById('bug_comment').value; 
      </script>
	
</body>
</html>