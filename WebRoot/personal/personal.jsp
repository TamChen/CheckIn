<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>bootstrap datatable demo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../style/layout/bootstrap2.3.css">
	<link rel="stylesheet" type="text/css" href="../style/layout/bootstrap-responsiv.css">
	<link rel="stylesheet" type="text/css" href="../style/layout/dataTables.bootstra.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
	<script type="text/javascript" src="../javascript/jquery.dataTables.js"></script>
	<script type="text/javascript" src="../javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="../javascript/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="../javascript/highcharts.js"></script>
    <script type="text/javascript" src="../javascript/highcharts-more.js"></script>
    <script type="text/javascript" src="../javascript/plinechart.js"></script>
    <script type="text/javascript" src="../javascript/ppiechart.js"></script>
	<style>
		body{
			margin-top: 20px;
		}
	</style>
</head>
	<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<h1>${username}</h1>
			<div>
				<ul class="breadcrumb">
					<li>
						基本信息：
					</li>
					<li>
						学号：${userno} <span class="divider">/</span>
					</li>
					<li>
						IP: ${ip} <span class="divider">/</span>
					</li>
					<li>
						在线总时长：${activetime} HOUR<span class="divider">/</span>
					</li><li>
						在线天数：${time} DAY<span class="divider">/</span>
					</li>
				</ul>
			</div>
		</div>
		<div id="ppiechart" style="min-width:50%;height:400px;float:left"></div>
		<div id="plinechart" style="min-width:50%;height:400px;float:left"></div>
		<div class="control-group">
	          <div class="controls">
	            <button class="btn btn-success" onclick="export01()">导出</button>
	          </div>
      	 </div>
		<div class="row-fluid">
			<table class="table table-striped table-bordered table-hover datatable">
				<thead>
					<tr>
						<th>实验室平均时长</th>
						<th>实验室该天到勤率</th>
						<th>学习时长</th>
						<th>空闲时长</th>
						<th>日期</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
<script>
	$(document).ready(function() {
    			$('.datatable').dataTable( {        		
    				"sAjaxSource": '${pageContext.request.contextPath}/getPersonDataAction.action?username=${username}',
    				"bAutoWidth": false,	
    				"oLanguage": {
        					"sUrl": "../json/zh_CN.json"
							} 
					});

		} );
	function export01(){
			$.ajax({
				url:'${pageContext.request.contextPath}/exportAction.action?username=${username}&export=personal',
				success:function(result){
					window.location.href=result;
				}
			});
			
		}
	</script>
	</div>

</body>
</html>
