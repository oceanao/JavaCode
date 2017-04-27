<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/user.css" type="text/css" rel="stylesheet" />
</head>
<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">普通用户</a>
/
    <a href="${pageContext.request.contextPath }/user/mission"  target= "iFrame1 ">查看复现任务</a>
</p>
<h1 align="center">复现任务</h1>

<div class="ground">
<br>
<br>
<br>
<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
		<!-- 数据展示区 -->
		<br>
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
						<td>提交时间</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${requestScope.bugs}" var="bug" varStatus="stat">
						<tr id="data_${stat.index}" align="center">
							<td>${stat.count }</td>
							<td>${bug.summary}</td>
							<td>${bug.bugseverity.severity}</td>
							<td><c:choose>
									<c:when test="${bug.bug_status == 1 }">New</c:when>
									<c:when test="${bug.bug_status == 2 }">Open</c:when>
									<c:when test="${bug.bug_status == 3 }">Assigned</c:when>
									<c:when test="${bug.bug_status == 4 }">Handled</c:when>
									<c:when test="${bug.bug_status == 5 }">Closed</c:when>
									<c:when test="${bug.bug_status == 6 }">Reopen</c:when>
									<c:otherwise>无</c:otherwise>
								</c:choose></td>
							<td>${bug.reporter.username }</td>
							<td>${bug.handler.username }</td>
							<td><f:formatDate value="${bug.submite_time}" type="date"
									dateStyle="long" /></td>
							<td align="center" width="40px;"><a
								href="${pageContext.request.contextPath }/user/updateBug?flag=1&&bug_id=${bug.bug_id}">
									处理</a></td>
						</tr>
						
					</c:forEach>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top">
			<td align="center"><fkjava:pager
					pageIndex="${requestScope.pageModel.pageIndex}"
					pageSize="${requestScope.pageModel.pageSize}"
					recordCount="${requestScope.pageModel.recordCount}" 
					style="digg"
					submitUrl="${pageContext.request.contextPath }/user/selectBug?pageIndex={0}" /></td>
		</tr>
	</table>
	</div>
	<div style="height: 10px;"></div>
</body>
</html>