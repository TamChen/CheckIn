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

	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap2.3.css">
	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap-responsiv.css">
	<link rel="stylesheet" type="text/css" href="style/layout/dataTables.bootstra.css">
  <script type="text/javascript" src="javascript/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="javascript/highcharts.js"></script>
   <script type="text/javascript" src="javascript/bootstrap-datetimepicker.min.js"></script>
  <!--  <script type="text/javascript" src="javascript/exporting.js"></script>  
  <script type="text/javascript" src="javascript/highcharts-more.js"></script>-->
 
  <script type="text/javascript" src="javascript/barchart.js"></script>
  <style>
		body{
			margin-top: 20px;
		}
	</style>
</head>
<body>
  <div class="container-fluid">
		<div class="row-fluid">
			<h1>基本信息与排名</h1>
			<div>
				<ul class="breadcrumb">
					<li>
						可选择一段时间或某天
					</li>
				</ul>
			</div>
		</div>
</div>
<form action="checkBarAction" style="margin-left:30px;" target="show" >
 <div class="control-group" style="float:right; margin-right:450px;">
	    <div class="controls">
	      <button class="btn btn-success" type="submit">查询</button>
	    </div>
    </div>
  <div id="datetimepicker4" class="input-append">
    <input data-format="yyyy-MM-dd" type="text" name="begintime" value="<%=session.getAttribute("begintime")%>"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
  
  <div id="datetimepicker5" class="input-append" >
    <input data-format="yyyy-MM-dd" type="text" name="endtime" value="<%=session.getAttribute("endtime")%>"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
  
 </form>
 
 <div id="container" style="min-width:700px;height:1100px"></div>
 
  
<script type="text/javascript">
  $(function() {
    $('#datetimepicker4').datetimepicker({
      pickTime: false
    });
    $('#datetimepicker5').datetimepicker({
        pickTime: false
      });
  });
</script>
</body>
</html>