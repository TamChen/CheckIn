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
     <title>Lab CheckIn</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Pragma" content="no-cache">
	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap.min.css">

   
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
		<div style="width:100%;height:160px;background-image:url(style/clientimg/2.png);background-repeat: repeat-x;">
			<div style="color:white;padding-top:30px;margin-left:150px;font-size:30px;">
					      RSS订阅
			</div>
			<div style="color:white;margin-left:150px;margin-top:20px;">今日推荐：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;凤凰网
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;果壳网</div>
			</div>		
	<div style="width:100%; ">
		<div style="width:100%; ">	
		  <form class="form-horizontal" style="width:25%;margin-left:0px;">
		    <fieldset>
		      <div id="legend" style="float:left;margin-left:80px;">
		        <legend class="">RSS搜索</legend>
		      </div>
		    <div class="control-group" style="float:left;margin-left:80px;">
		
		          <!-- Text input-->
		          <label class="control-label" for="input01"></label>
		          <div class="controls">
		            <input type="text" placeholder="" class="input-xlarge" style="width:200px;height:35px;">
		            <p class="help-block"></p>
		          </div>
		        </div>
		
		    <div class="control-group" style="float:left;margin-left:10px;">
		          <label class="control-label"></label>
		
		          <!-- Button -->
		          <div class="controls" >
		            <button class="btn btn-success">搜索</button>
		          </div>
		        </div>
		
		    </fieldset>
		  </form>
		    <form class="form-horizontal" style="width:25%;margin-left:0px;">
		    <fieldset>
		      <div id="legend" style="float:left;margin-left:80px;">
		        <legend class="">RSS搜索</legend>
		      </div>
		    <div class="control-group" style="float:left;margin-left:80px;">
		
		          <!-- Text input-->
		          <label class="control-label" for="input01"></label>
		          <div class="controls">
		            <input type="text" placeholder="" class="input-xlarge" style="width:200px;height:35px;">
		            <p class="help-block"></p>
		          </div>
		        </div>
		
		    <div class="control-group" style="float:left;margin-left:10px;">
		          <label class="control-label"></label>
		
		          <!-- Button -->
		          <div class="controls" >
		            <button class="btn btn-success">搜索</button>
		          </div>
		        </div>
		
		    </fieldset>
		  </form>
</div>	
</div>
</div>
  </body>
</html>