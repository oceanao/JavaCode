<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目</title>
<link href="${pageContext.request.contextPath }/static/css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
<p>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
<a href="${pageContext.request.contextPath }/project/selectProject" target= "iFrame1 ">查看项目</a>

</p>
<h1 align="center">查看项目</h1>


<br><br>
<div align="center">
<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" >
		    <tr>
			  <td>
			  	<form name="projectform" method="post" id="projectform" action="${pageContext.request.contextPath }/project/selectProject">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td >
					    &nbsp; &nbsp;&nbsp;&nbsp; 
					    	项目名称：<input type="text" name="pro_name"   onkeyup="javascript:chkmaxsms(this,'20')"  style="width: 200px;height: 30px;">
					    	 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					    	 <input type="submit" value="搜索" style="width: 100px; height:38px;
									      color:white; background-color: #0198f1; "  />
					    </td>
					  </tr>
					</table>
				</form>
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
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
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr  align="center">
			  <td>序号</td>
			  <td>项目名称</td>
			  
             <td align="center" style="width: 50px;">操作1</td>
			  <td align="center" style="width: 50px;">操作2</td>
			  <td align="center" style="width: 50px;">操作3</td>
			   <td align="center" style="width: 50px;">操作4</td>
			</tr>
			<c:forEach items="${requestScope.projects}" var="project" varStatus="stat">
				<tr id="data_${stat.index}" align="center" >
					<td>${stat.count}</td>
					 <td>${project.pro_name }</td>
				     
					 <td align="center" width="40px;"><a href="${pageContext.request.contextPath }/project/updateProject?flag=1&pro_id=${project.pro_id}" title="修改项目">
							<img src="${pageContext.request.contextPath }/static/image/updata.jpg" style="width: 40px;height: 20px;"></a> 
					  </td>
					   <td align="center" width="40px;">
					   <a href="${pageContext.request.contextPath }/project/removeProject?pro_id=${project.pro_id}" title="删除项目">
										<img src="${pageContext.request.contextPath }/static/image/delete.jpg" style="width: 40px;height: 20px;"></a> 
					  </td>
					   <td align="center" width="40px;"><a href="${pageContext.request.contextPath }/project/detailProject?pro_id=${project.pro_id}" title="查看详情">
								<img src="${pageContext.request.contextPath }/static/image/file_find.png" style="width: 40px;height: 20px;"></a>
					  </td>
					  
					  <td align="center" width="40px;">
					  
					 <a href="${pageContext.request.contextPath }/project/exportExcel?pro_id=${project.pro_id}" title="下载项目">
							<img src="${pageContext.request.contextPath }/static/image/download.png" style="width: 40px;height: 20px;"></a> 
					  </td>
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" >
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${pageContext.request.contextPath }/project/selectProject?pageIndex={0}"/>
	  </td></tr>
	</table>
</div>
</body>
</html>