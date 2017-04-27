<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户首页</title>
<link href="${pageContext.request.contextPath }/static/css/common.css" type="text/css" rel="stylesheet" />
  <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui/demo/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui/jquery.easyui.min.js"></script> 
</head>
<body  width=window.screen.width style="background-color: #f7f7f7;">
<div style="   width: 100%;height: 200px; background-image: url(' ${pageContext.request.contextPath }/static/image/main.jpg');" >

<div align="right">
<div align="center" style="color: white; font-size: 40px;">软件缺陷管理系统</div>
<span style="color: white; font-size: 30px;" >
欢迎您！${username}登录系统 	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<a  algin="right"  style="color:#0198f1"   href="${pageContext.request.contextPath }/user/logOut" >注销</a></span>
</div>
</div>
 <div style="width:200px;height:auto;background:#7190E0 ;padding:5px; background-color: #f7f7f7;">
       <div  class="nav"  style="background-color: #f7f7f7;" >
       <div class="easyui-panel"   title=" 任务管理"  collapsible="true"  style="width:200px;height:auto;padding:10px;  font-size: 80px; background-color: #f7f7f7;" >
    <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/mission"  target= "iFrame1 ">复现任务</a>

    </div>
    
     <div class="easyui-panel"   title=" 项目管理"  collapsible="true"  style="width:200px;height:auto;padding:10px;  font-size: 80px; background-color: #f7f7f7;" >
    <a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/Project"  target= "iFrame1 ">项目管理</a>
    </div>
   
       <div class="easyui-panel"  title="缺陷管理"  collapsible="true" style="width:200px;height:auto; font-size: 50px;background-color: #f7f7f7;">
<a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/selectBug" target= "iFrame1 ">搜索缺陷</a>
<a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/addBug?flag=1" target= "iFrame1 "> 提交缺陷</a>
<a  style="color:#0198f1"  href="${pageContext.request.contextPath }/user/selectBugseverity" target= "iFrame1 ">查看缺陷严重级别</a>
    </div>
    </div>
</div>

<div id= "iFrame1 " style= "position:absolute; left:212px; top:220px; z-index:18 "> 
<iframe id= "p1"   name= "iFrame1 "  src="${pageContext.request.contextPath }/user/hello"   scrolling= "auto " frameborder= "0 " > </iframe> 
</div> 
 <script type="text/javascript">
  
  var x=window.screen.width;
  var y=window.screen.height*0.64;
   /*     alert(y);  alert(x);  */
           $("#p1").width(x)
           $("#p1").height(y)
</script>

</body>

</html>