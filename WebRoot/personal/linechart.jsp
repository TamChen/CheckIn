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
	<script type="text/javascript" src="../javascript/linechart.js"></script>
  <style>
		body{
			margin-top: 20px;
		}
	</style>
	
</head>
	<body>
	
	
	<div class="container-fluid float:left;">
		<div class="row-fluid">
			<h1>个人在线总时长折线图</h1>
			<div>
				<ul class="breadcrumb">
					<li>
						说明: <span class="divider">/</span>
					</li>
					<li>
						来自每个人的记录
					</li>
					
				</ul>
			</div>
		</div>
	<div>
	 <div id="allinfo" style="min-width:1000px;height:400px;float:left"></div>
	 
	</div>
		<div class="control-group">
	          <div class="controls">
	            <button class="btn btn-success" onclick="export01()">导出</button>
	          </div>
      	 </div>
		<div class="row-fluid">

			<table class="table table-striped table-bordered table-hover datatable">
				<thead>
					<tr>
						<th>用户名</th>
						<th>学号</th>
						<th>在线总时长</th>
						<th>在线次数</th>
						<th>到勤率</th>
					</tr>
				</thead>
				<tbody>
			
				</tbody>
			</table>
		</div>
		
<script>
	$(document).ready(function() {
    			$('.datatable').dataTable( { 
    				"sAjaxSource": '${pageContext.request.contextPath}/getAllDataAction.action',
    					"bAutoWidth": false,
        				"oLanguage": {
        					"sUrl": "../json/zh_CN.json"
							} 
					});
		} );
	function export01(){
		$.ajax({
			url:'${pageContext.request.contextPath}/exportAction.action?export=allinfo',
				success:function(result){
					window.location.href=result;
				}
		});
	}
	</script>
	</div>
</body>
</html>
