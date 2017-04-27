<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/common.css" type="text/css" rel="stylesheet" />
    <title>管理员</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/demo/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui/jquery.easyui.min.js"></script>
<title>后台首页</title>
</head>
<body  width=window.screen.width style="background-color: #f7f7f7;">
<div style="   width: 100%;height: 200px; background-image: url(' ${pageContext.request.contextPath }/static/image/main.jpg');" >

<div align="right">
<div align="center" style="color: white; font-size: 40px;">软件缺陷管理系统</div>
<br>
<span style="font-size: 30px;color: white;" >
欢迎管理员登录系统 
&nbsp;&nbsp;
<a  style="font-size: 30px;color: #0198f1" href="${pageContext.request.contextPath }/admin/logOut"  title="退出登录">注销</a>
</div>
</div>
</div>
<div style="width:200px;height:auto;background:#7190E0;padding:5px; background-color: #f7f7f7;">
       <div  class="nav"  style="background-color: #f7f7f7;" >
       <div class="easyui-panel"  title=" 用户管理" collapsible="true" style="width:200px;height:auto;padding:10px;  font-size: 20px; background-color: #f7f7f7;">
        <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/login"  >普通用户</a >
        <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/selectUser"  target= "iFrame1 ">查看用户</a>
        <a   style="color:#0198f1" href="${pageContext.request.contextPath }/user/addUser?flag=1" target= "iFrame1 ">添加用户</a>
    </div>
    
    <div class="easyui-panel" title="项目管理" collapsible="true" style="width:200px;height:auto;padding:10px;  font-size: 20px; background-color: #f7f7f7;">
      <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/project/selectProject" target= "iFrame1 ">查看项目</a>
      <a   style="color:#0198f1"  href="${pageContext.request.contextPath }/project/addProject?flag=1" target= "iFrame1 ">添加项目</a>
   
    </div>
  
    
       <div class="easyui-panel" title="缺陷管理" collapsible="true" style="width:200px;height:auto; font-size: 40px; background-color: #f7f7f7;">
  <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/bug/selectBug" target= "iFrame1 ">管理缺陷</a>
    </div>
       <div class="easyui-panel" title="缺陷严重级别管理" collapsible="true" style="width:200px;height:auto; font-size: 40px;background-color: #f7f7f7;">
    <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/bugseverity/selectBugseverity" target= "iFrame1 ">查看缺陷严重级别</a>
 <a   style="color:#0198f1"  href="${pageContext.request.contextPath }/bugseverity/addBugseverity?flag=1" target= "iFrame1 ">添加缺陷严重级别</a>
    </div>
    </div>
</div>


<div id= "iFrame1 " style= "position:absolute; left:212px; top:242px; z-index:18 "> 
<iframe id= "p1"   name= "iFrame1 "  src="${pageContext.request.contextPath }/user/hello"   scrolling= "auto " frameborder= "0 " > </iframe> 
</div> 
 <script type="text/javascript">
  
  var x=window.screen.width*0.88;
  var y=window.screen.height;
/*   alert(y);  alert(x); */
           $("#p1").width(x)
           $("#p1").height(y)
</script>
</body>
</html>