<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>    
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Pragma" content="no-cache">
    <title>Lab CheckIn</title>
<style type="text/css">

</style>
  </head>
 <body style="font-family:'微软雅黑';">
 	<s:action name="personalAction" id="personal" namespace="/">
	</s:action>
 <div>
		<div style="width:100%;height:40px; ">
					<div style="float:left;margin-left:150px;margin-top:15px;font-size:20px;">实验室管理系统</div>
					<ul style="list-style-type: none;float:right;">
					<li style="float:left;"><a style="color:black;text-decoration:none" href="client/index.jsp">首页</a></li>
					<li style="float:left;margin-left:10px;"><a style="color:black;text-decoration:none" href="client/person.jsp">我的库</a></li>
					<li style="float:left;margin-left:10px;"><a style="color:black;text-decoration:none" href="client/rss.jsp">RSS区</a></li>
					<li style="float:left;margin-left:10px;"><a style="color:black;text-decoration:none" href="client/news.jsp">News</a></li>
					<li style="float:left;margin-left:10px;"><a style="color:black;text-decoration:none" href="client/api.jsp">API文档</a></li>
					<li style="float:left;margin-left:10px;"><a style="color:black;text-decoration:none" href="client/sign.jsp">签到情况</a></li>
					</ul>
			</div>
	<div style="width:80%;text-align:center;margin:0 auto; ">
	<h1>${newtitle}</h1>
	<p>${newcontent}</p>
	</div>	
		
</div>
  </body>
</html>