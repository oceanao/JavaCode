<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
<h1 align="center"> 添加缺陷</h1>

<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
		<!-- 数据展示区 -->
		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0"
					style="border: #c2c6cc 1px solid; border-collapse: collapse;">
					<tr>
						<td>序号:</td>
						<td>${bug.bug_id}</td>
					</tr>
					<tr>
						<td>提交人:</td>
						<td>${bug.reporter.username }</td>
					</tr>
					<tr>
						<td>标题:</td>
						<td>${bug.summary}</td>
					</tr>
					<tr>
						<td>所属项目:</td>
						<td>${bug.project.pro_name}</td>
					</tr>
					<tr>
						<td>缺陷严重级别:</td>
						<td>${bug.bugseverity.severity}</td>
					</tr>
					<tr>
						<td>测试环境：
						<td>${bug.bug_os }</td>
					</tr>

					<tr>
						<td>步骤描述：</td>
						<td>${bug.bug_description }</td>
					</tr>

					
					<tr>
						<td>缺陷状态:</td>
						<td><c:choose>
								<c:when test="${bug.bug_status == 1 }">New</c:when>
								<c:when test="${bug.bug_status == 2 }">Open</c:when>
								<c:when test="${bug.bug_status == 3 }">Assigned</c:when>
								<c:when test="${bug.bug_status == 4 }">Handled</c:when>
								<c:when test="${bug.bug_status == 5 }">Closed</c:when>
								<c:when test="${bug.bug_status == 6 }">Reopen</c:when>

							</c:choose></td>
					</tr>
					
					<tr>
						<td>提交时间：</td>
						<td><f:formatDate value="${bug.submite_time}" type="date"
								dateStyle="long" /></td>
					</tr>


					<tr>
						<c:forEach items="${requestScope.bugfiles }" var="bugfile"
							varStatus="stat">
							<tr id="data_${stat.index}">
<%-- 序号从一开始					<td>${bugfile.bugfile_id}</td> --%>
                                <td>${stat.index}</td>
								<td><img src="/pic/${bugfile.filename}"  />
								</td>
							</tr>
						</c:forEach>

					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="10" cellspacing="0" >
		  	<tr valign="top">
			    <td>
			    
				 <form id="fileForm" name="fileForm" action="${pageContext.request.contextPath }/bug/addBugFile?bug_id=${bug.bug_id}" enctype="multipart/form-data" method="post">

				  <table width="100%" border="0" cellpadding="0" cellspacing="10">
				  
						<tr><td>附件：只支持上传图片<br/>
							<input type="file" name="file" id="file"   onchange="selectFile(this)"  size="30" style="width: 400px;height: 30px;"/>
						</td></tr>						
						<tr><td>
								<input id="submit" type="submit"  value="上传" class="but" style="width: 200px;height: 35px;">
								<input type="reset" value="重置" class="but" style="width: 200px;height: 35px;">
						</td></tr>
				  </table>
				  </form>
				</td>
		  	</tr>
		</table>
<script type="text/javascript">
 
function selectFile(input) {
 
    var fileName = input.value;
    if(fileName.length > 1 && fileName ) {       
        var ldot = fileName.lastIndexOf(".");
        var type = fileName.substring(ldot + 1);
         
        if(type != "jpg"&&type != "png"&&type != "PNG") {
            alert("只能上传jpg,png格式，当前格式"+type);
            //清除当前所选文件
            input.outerHTML=input.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        }       
    }
}
 
</script>
	
</body>
</html>