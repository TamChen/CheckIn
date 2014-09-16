<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>

  <script type="text/javascript" src="javascript/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="javascript/highcharts.js"></script>
  <!--  <script type="text/javascript" src="javascript/exporting.js"></script>  
  <script type="text/javascript" src="javascript/highcharts-more.js"></script>-->
 
  <script type="text/javascript" src="javascript/barchart.js"></script>
  
</head>
<body>
  <div><h2>hello</h2></div>
  <div id="container" style="min-width:700px;height:1100px"></div>
</body>
</html>