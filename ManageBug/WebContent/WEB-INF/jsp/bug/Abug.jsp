<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/admin/hello"  target= "iFrame1 ">管理员</a>
/
<a href="${pageContext.request.contextPath }/bug/selectBug" target= "iFrame1 ">管理缺陷</a>
</p>
<h1 align="center"> 缺陷列表</h1>


<br>

<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
							<form name="bugform" method="post" id="bugform"
								action="${pageContext.request.contextPath }/bug/selectBug">
								 &nbsp;&nbsp;
								缺陷标题：<input type="text" name="summary">
								    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								缺陷项目： <select name="pro_id" style="width: 168px;">
												<option value="0">--请选择项目--</option>
												<c:forEach items="${requestScope.projects }" var="project">
													<option value="${project.pro_id }">${project.pro_name }</option>
												</c:forEach>
										</select>
                            
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								缺陷级别： <select name="bugseverity_id"
											style="width: 143px;">
												<option value="0">--请选择状态--</option>
												<c:forEach items="${requestScope.bugseveritys }"
													var="bugseverity">
													<option value="${bugseverity.bugseverity_id }">${bugseverity.severity }</option>
												</c:forEach>
										</select>
										
									
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  	
								缺陷状态： <select name="bug_status" style="width: 143px;">
												<option value="0">--请选择状态--</option>
												<option value="1">New</option>
												<option value="2">Open</option>
												<option value="3">Assigned</option>
												<option value="4">handled</option>
												<option value="5">Closed</option>
												<option value="6">Reopen</option>
										</select>
									</div>
									<div>
									     &nbsp;&nbsp; 
									处理结果： <select name="bug_result" style="width: 143px;">
												<option value="0">--请选择处理结果--</option>
												<option value="1">Fixed</option>
												<option value="2">Rejected</option>
												<option value="3">Postponed</option>
												<option value="4">Duplicate</option>
										</select> 
									 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
										提交人：&nbsp;&nbsp;&nbsp;
										<select name="reporter_id" style="width: 170px;">
												<option value="0">--请选择提交人--</option>
												<c:forEach items="${requestScope.users }" var="user">
													<option value="${user.user_id }">${user.username}</option>
												</c:forEach>
										</select>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
										
										处理人：&nbsp;&nbsp;&nbsp;
										<select name="handler_id" style="width: 143px;">
												<option value="0">--请选择提交人--</option>
												<c:forEach items="${requestScope.users }" var="user">
													<option value="${user.user_id }">${user.username }</option>
												</c:forEach>
										</select>
										&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								  
										 <input type="submit"  value="搜索"  style="width: 100px; font-size: 16px; 
									      color:white; background-color: #0198f1; "   /> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
									   
								
									      <a   style="color: black;"  href="${pageContext.request.contextPath }/bug/exportExcel">
									      	      <button  style="width: 100px; font-size: 16px;   color:white; background-color: #0198f1;" >      下载</button></a>
									
							</form>
<br><br><br>
		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0"
					style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr align="center">
						<td>序号</td>
						<td>标题</td>
						<td>缺陷严重级别</td>
						<td>缺陷状态</td>
						<td>提交人</td>
						<td>处理人</td>
						<td>处理结果</td>
						<td>提交时间</td>
						<td align="center" style="width: 60px;">操作1</td>
						<td align="center" style="width: 60px;">操作2</td>
						<td align="center" style="width: 60px;">操作3</td>
					</tr>
					<c:forEach items="${requestScope.bugs}" var="bug" varStatus="stat">
						<tr id="data_${stat.index}" align="center">

							<td>${stat.count}</td>
							<td>${bug.summary}</td>
							<td>${bug.bugseverity.severity}</td>

							<td><c:choose>
									<c:when test="${bug.bug_status == 1 }">New</c:when>
									<c:when test="${bug.bug_status == 2 }">Open</c:when>
									<c:when test="${bug.bug_status == 3 }">Assigned</c:when>
									<c:when test="${bug.bug_status == 4 }">Handled</c:when>
									<c:when test="${bug.bug_status == 5 }">Closed</c:when>
									<c:when test="${bug.bug_status == 6 }">Reopen</c:when>
									
								</c:choose></td>

							<td>${bug.reporter.username }</td>
							<td>${bug.handler.username }</td>

							<td><c:choose>
									<c:when test="${bug.bug_result == 1 }">Fixed</c:when>
									<c:when test="${bug.bug_result == 2 }">Rejected</c:when>
									<c:when test="${bug.bug_result == 3 }">Postponed</c:when>
									<c:when test="${bug.bug_result == 4 }">Duplicate</c:when>
									
								</c:choose></td>


							<td><f:formatDate value="${bug.submite_time}" type="date"
									dateStyle="long" /></td>
							<td align="center" width="40px;"><a
								href="${pageContext.request.contextPath }/bug/detailBug?bug_id=${bug.bug_id}">
									详情</a></td>
									<td align="center" width="40px;"><a
								href="${pageContext.request.contextPath }/bug/updateBug?flag=1&&bug_id=${bug.bug_id}">
									修改</a></td>
									<td align="center" width="40px;"><a
								href="${pageContext.request.contextPath }/bug/removeBug?bug_id=${bug.bug_id}" title="下载列表">
									<img src="${pageContext.request.contextPath }/static/image/delete.jpg" style="width: 50px;height: 25px;"></a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<div align="right">
		<tr valign="top" >
			<td align="center">
			<fkjava:pager
					pageIndex="${requestScope.pageModel.pageIndex}"
					pageSize="${requestScope.pageModel.pageSize}"
					recordCount="${requestScope.pageModel.recordCount}" 
					style="digg"
					submitUrl="${pageContext.request.contextPath }/bug/selectBug?pageIndex={0}" />
					 </td>
		</tr>
		</div>
	

</body>
</html>