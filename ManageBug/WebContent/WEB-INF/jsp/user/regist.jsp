<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="${pageContext.request.contextPath }/static/css/user.css"
	type="text/css" rel="stylesheet" /> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/frame.js"></script>
 <link href="${pageContext.request.contextPath }/static/css/regist.css"
	type="text/css" rel="stylesheet" /> 
	 <link href="${pageContext.request.contextPath }/static/css/login.css"
	type="text/css" rel="stylesheet" /> 
</head>

<body>
<h2 align="center"> 用户注册</h2>

<br><br><br>
<table align="center" style="width: 420px;">
 <form id="registerForm" method="post" 	action="${pageContext.request.contextPath }/user/regist"> 

<tr>
<td> 账号 (学号):&nbsp;&nbsp;<input type="text" id="student_num"   name="student_num"  
           required="required" onchange="num()" /></td>
</tr>

<tr>
<td><div id="studentnumber" align="center"></div></td>
</tr>
<tr>
<td> 用户名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username" required="required" 
				     	size="20"  onchange="hello()"   /></td>

</tr>
<tr>
<td><div id="studentnumber"></div></td>
</tr>
<tr>
<td> 登录密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"  id="password"  required="required" 
           name="password"  onchange="hello()" /></td>

</tr>
<tr>
<td><div id="passwordtest"> </div></td>
</tr>
<tr>
<td> 确认密码:&nbsp;&nbsp;&nbsp;&nbsp; <input type="password"   name="passwordconfirm"  required="required" 
             id="passwordconfirm"  onchange="hello()"  /></td>

</tr>
<tr>
<td><div id="studentnumber"> </div></td>
</tr>
<tr>
<td> 选择角色：
<select name="role"  style="width: 300px;height: 36px; font-size: 16px;">
						<option value="0">--请选择角色--</option>
						<option value="1">测试人员</option>
						<option value="2">开发人员</option>
				</select>
</td>
</tr>
<tr>
<td>
<br><br>
</td>
<tr>
<br><br>
<tr>
<td align="center">
<input type="submit" value="注册" style="width:200px;" class="but">
<input type="reset" style="width:200px;" class="but">
<td>
</tr>
 </form>
</table>
</body>

	<script type="text/javascript">

	function  num()
	{
		var a=document.getElementById("student_num").value;  
		if(isNaN(a))
		{
			var test=document.getElementById("studentnumber")
			test.innerHTML="学号请输入数字";
			test.style="color:red;";
		}
		else
			{
		if(a.length<8||a.length>10||a.length==9)
			{
			var test=document.getElementById("studentnumber")
			test.innerHTML="账号为8位或者10位";
			test.style="color:red;";
			}
		if(a.length==8||a.length==10)
			{
			var test=document.getElementById("studentnumber")
				test.style="color:red;";
			    test.innerHTML="";
			}
			}
		
	}
	</script>
	<script type="text/javascript">
	function hello()
	{
		var  number=0;
		var password=document.getElementById("password").value;  
		var passwordconfirm=document.getElementById("passwordconfirm").value; 
		if(passwordconfirm.length>0)
			 number=1;
		 var test=document.getElementById("passwordtest")
         if(password.length<6||a.length>20)
   			 alert("密码为6—20个字符")
		 if(number==1&&(password !=passwordconfirm))
               alert("两次输入密码不匹配");   	 
	}
	</script>
	<script type="text/javascript">
	 function  passwordconfirm()
	 {
		 var password=document.getElementById("password").value;  
			var passwordconfirm=document.getElementById("passwordconfirm").value; 
         if(password !=passwordconfirm)
             alert("密码不匹配");    
	 }
	</script>
</html> 