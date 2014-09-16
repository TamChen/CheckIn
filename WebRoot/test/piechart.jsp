<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>

  <script type="text/javascript" src="../javascript/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="../javascript/highcharts.js"></script>
  <script type="text/javascript" src="../javascript/piechart.js"></script>
  <script>
    //左侧Javascript代码
  </script>
</head>
<body>
  <div id="container" style="min-width:500px;height:400px"></div>
</body>
</html>