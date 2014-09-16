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
			
			<div style="width:100%;height:160px;background-image:url(style/clientimg/1.png);background-repeat: repeat-x;">
					<div style="color:white;padding-top:30px;margin-left:150px;font-size:30px;">
					       我的库
					</div>
					<div style="color:white;margin-left:150px;margin-top:20px;">分享的文章数：20&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发起的讨论：5
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的收藏：50</div>
			</div>
			
			<div style="width:100%;height:700px;float:left;">
								<div style="width:50%;float:left;">
								<div style="margin-left:150px;">
									<p style="font-size:25px;">我的文章与讨论</p>
									<ol>
										<s:iterator id="a" value="#personal.newsList">
										
										<li><a href="#"><img border="0" src="style/img/grayarrow.gif" /></a>
										<a style="color:black;text-decoration:none" href="/CheckIn/article.action?newsid=<s:property value="#a.newsid"/>"><s:property value="#a.title"/></a><span style="color:#828282">(<s:property value="#a.url"/>)</span><br>
										<span style="color:#828282;font-size:15px;">票数：<s:property value="#a.star"/>|发布时间：<s:property value="#a.comnumber"/>
										|评论数：<s:property value="#a.recordtime"/></span>
										</li>
										
										</s:iterator>
									</ol>
									</div>
								</div>
								
								
								<div style="width:50%;float:left;">
								<div style="margin-left:60px;">
								<p style="font-size:25px;">我的收藏</p>
								<ol>
									<s:iterator id="a" value="#personal.newsCollect">
										<li><a href="#"><img border="0" src="style/img/grayarrow.gif" /></a>
										<a style="color:black;text-decoration:none" href="http:127.0.0.1:8080/CheckIn/article.action?newsid=<s:property value="#a.newsid"/>"><s:property value="#a.title"/></a><span style="color:#828282">(<s:property value="#a.url"/>)</span><br>
										<span style="color:#828282;font-size:15px;">票数：<s:property value="#a.star"/>|发布时间：<s:property value="#a.comnumber"/>
										|评论数：<s:property value="#a.recordtime"/></span>
										</li>
										
										</s:iterator>
									</ol>
									</div>
								</div>
								
			</div>
</div>
  </body>
</html>