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
<h1 align="center">修改缺陷级别</h1>
	<h3>  当前位置：<a href="${pageContext.request.contextPath }/user/hello"  target= "iFrame1 ">管理员</a>
/
    <a href="${pageContext.request.contextPath }/bugseverity/selectBugseverity" target= "iFrame1 ">查看缺陷级别</a>
 /
 <a href="${pageContext.request.contextPath }/bugseverity/updateBugseverity?flag=1&bugseverity_id=${bugseverity.bugseverity_id}">
			修改缺陷级别</a>
</h3>

<div align="center">
<table width="80%" height="90%" border="0" cellpadding="5" cellspacing="0" >
  <tr valign="top">
    <td>
    	 <form action="${pageContext.request.contextPath }/bugseverity/updateBugseverity" id="bugseverityForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
    	 	<input type="hidden" name="bugseverity_id" value="${bugseverity.bugseverity_id}">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" >
		    <tr><td>
		    	<table align="center">
		    		   <tr>
		    			<td><p>缺陷级别：</p>
		    			<input type="text" name="severity" id="severity" size="20" value="${bugseverity.severity }"
		    			           style="width: 600px; height: 30px; font-size: 18px;" required="required"/></td>
		    			</tr>
		    			<tr>
		    			<td><p>缺陷说明：</p><textarea type="text" name="remark" id="remark" size="20"  
		    			 style="width: 600px; height: 200px; font-size: 18px;" required="required"></textarea></td>
		    			</tr>
		    			
		    			
		    	</table>
		    </td></tr>
			<tr><td></td></tr>
			
			<tr><td align="center">
			<input type="submit" value="提交" style="width: 150px;height: 40px;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
			<input type="reset" value="取消 " style="width: 150px;height: 40px;"></td>
			</tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
<script type="text/javascript">
  document.getElementById('remark').value="${bugseverity.remark}";
</script>

	<script type="text/javascript">
	
	function  num()
	{
		var a=document.getElementById("student_num").value;  
		if(isNaN(a))
			alert(" 请输入数字")
			else
		if(a.length<8||a.length>10||a.length==9)
			alert(" 学号 请输入8位或者10位数字")
	}
	 function  password1()
	{ 
		var x=document.getElementById("password").value;  
		if(x.length<6||x.length>20)
			alert("密码长度为6--20位")
	}
	</script>
</body>
</div>
</html>