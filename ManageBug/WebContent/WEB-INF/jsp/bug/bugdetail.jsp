<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/static/css/body.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui/jquery.min.js"></script>
</head>
<body>
	<h1 align="center">缺陷详情</h1>
	<br>
	<br>
	<div align="center">
		<table width="80%" height="90%" cellpadding="5" cellspacing="0">

			<!-- 数据展示区 -->
			<tr valign="top">
				<td height="20">
					<table width="100%" cellpadding="5" cellspacing="0"
						style="border: #c2c6cc 1px solid; border-collapse: collapse;">
						<tr>
							<td>序号:${bug.bug_id}</td>
						</tr>
						<tr>
							<td>提交人:${bug.reporter.username }</td>
						</tr>
						<tr>
							<td>标题:${bug.summary}</td>
						</tr>
						<tr>
							<td>所属项目:${bug.project.pro_name}</td>
						</tr>
						<tr>
							<td>缺陷严重级别:${bug.bugseverity.severity}</td>
						</tr>
						<tr>
							<td>测试环境：${bug.bug_os }</td>
						</tr>
						<tr>
							<td>步骤描述：${bug.bug_description }</td>
						</tr>
						<tr>
							<td>处理人:${bug.handler.username }</td>

						</tr>
						<tr>
							<td>缺陷状态:<c:choose>
									<c:when test="${bug.bug_status == 1 }">New</c:when>
									<c:when test="${bug.bug_status == 2 }">Open</c:when>
									<c:when test="${bug.bug_status == 3 }">Assigned</c:when>
									<c:when test="${bug.bug_status == 4 }">Handled</c:when>
									<c:when test="${bug.bug_status == 5 }">Closed</c:when>
									<c:when test="${bug.bug_status == 6 }">Reopen</c:when>

								</c:choose></td>
						</tr>
						<tr>
							<td>处理结果：<c:choose>
									<c:when test="${bug.bug_result == 1 }">Fixed</c:when>
									<c:when test="${bug.bug_result == 2 }">Rejected</c:when>
									<c:when test="${bug.bug_result == 3 }">Postponed</c:when>
									<c:when test="${bug.bug_result == 4 }">Duplicate</c:when>

								</c:choose></td>
						</tr>
						<tr>
							<td>评论：${bug.bug_comment }</td>
						</tr>
						<tr>
							<td>提交时间：<f:formatDate value="${bug.submite_time}"
									type="date" dateStyle="long" /></td>
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
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>