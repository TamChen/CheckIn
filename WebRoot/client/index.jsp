<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script src="javascript/main.js"></script>
    <title>Lab CheckIn</title>
<style type="text/css">

</style>
<script>

</script>
  </head>
 <body style="-webkit-app-region: drag;font-family:'微软雅黑';">

<div style="width:100%;height:600px;">
	<div style="width:97%;height:290px;margin-left:40px;">
			<div style="width:47%;height:290px;
			float:left;background-image:url(style/clientimg/3.png);background-repeat: repeat-x;border-radius:10px;">
				<div  style="width:100%;height:290px;float:left;">
				<div style="margin-left:100px;margin-top:30px;color:white;font-size:45px;font-family:">${cusername}</div>
				<div style="margin-left:250px;margin-top:10px;color:white;font-size:23px;font-family:">到勤率：${crate} </div>
				<div style="margin-left:250px;margin-top:10px;color:white;font-size:23px;font-family:">在线次数：${ctime} </div>
				<div style="margin-left:250px;margin-top:10px;color:white;font-size:23px;font-family:">IP地址${cip}</div>
				<div style="margin-left:250px;margin-top:10px;color:white;font-size:23px;font-family:">在线总时长：${cactivetime} 小时</div>
				</div>
				
			</div>
		
			<div style="width:22%;height:290px;float:left;margin-left:30px;" >
				<div style="width:100%;height:130px;
				background-image:url(style/clientimg/4.png);background-repeat: repeat-x;border-radius:10px;">
					<div style="text-align:center;margin:0 auto;padding-top:15%;">
					<a href="client/person.jsp" style="color:white;font-size:24px;">我的库</a><!-- personal.action -->
					</div>
				</div>
				<div style="width:100%;height:130px;margin-top:30px;
				background-image:url(style/clientimg/2.png);background-repeat: repeat-x;border-radius:10px;">
				<div style="text-align:center;margin:0 auto;padding-top:15%;">
				<a href="client/rss.jsp" style="color:white;font-size:24px;">RSS区</a>
				</div>
				</div>
			</div>
			<div style="width:22%;height:290px;float:left;margin-left:30px;">
				<div style="width:100%;height:130px;
				background-image:url(style/clientimg/6.png);border-radius:10px;">
				<div style="text-align:center;margin:0 auto;padding-top:15%;">
				<a href="client/api.jsp" style="color:white;font-size:24px;">API文档</a>
				</div>
				</div>
				<div style="width:100%;height:130px;margin-top:20px;">
				
				</div>
			</div>
	</div>
	
	<div style="width:97%;height:300px;margin-top:30px;margin-left:40px;">
			
			<div style="width:22%;height:290px;float:left;" >
				<div style="width:100%;height:130px;
				background-image:url(style/clientimg/8.png);background-repeat: repeat-x;border-radius:10px;">
				<div style="text-align:center;margin:0 auto;padding-top:15%;">
				<a href="client/sign.jsp" style="color:white;font-size:24px;">签到情况</a>
				</div>
				</div>
				<div style="width:100%;height:130px;border-radius:10px;">
				
				</div>
			</div>
			
			<div style="width:47%;height:290px;float:left;margin-left:30px;
			background-image:url(style/clientimg/5.png);background-repeat: repeat-x;border-radius:10px;">
			<div style="text-align:center;margin:0 auto;padding-top:15%;">
				<a href="client/news.jsp" style="color:white;font-size:24px;">News区</a>
				</div>
			</div>
		
			<div style="width:22%;height:290px;float:left;margin-left:30px;">
				<div style="width:100%;height:130px;
				background-image:url(style/clientimg/7.png);background-repeat: repeat-x;border-radius:10px;">
				<div style="text-align:center;margin:0 auto;padding-top:15%;">
				<a href="client/person.jsp" style="color:white;font-size:24px;">系统说明</a>
				</div>
				</div>
				<div style="width:100%;height:130px;margin-top:30px;
				background-image:url(style/clientimg/1.png);background-repeat: repeat-x;border-radius:10px;">
				
				</div>
			</div>
	</div>
</div>

  </body>
</html>