<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../style/layout/bootstrap2.3.css">
	<link rel="stylesheet" type="text/css" href="../style/layout/bootstrap-responsiv.css">
	<link rel="stylesheet" type="text/css" href="../style/layout/dataTables.bootstra.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
	<script type="text/javascript" src="../javascript/jquery.dataTables.js"></script>
	<script type="text/javascript" src="../javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="../javascript/dataTables.bootstrap.js"></script>
	<style>
		body{
			margin-top: 20px;
		}
	</style>
	
</head>
	<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<h1>添加成员</h1>
			<div>
				<ul class="breadcrumb">
					<li>
						基本功能：
					</li>
					<li>
						分页 <span class="divider">/</span>
					</li>
					<li>
						排序 <span class="divider">/</span>
					</li>
					<li>
						过滤
					</li>
				</ul>
			</div>
		</div>
		
		  <form class="form-horizontal">
		    <fieldset>
		      <div id="legend" class="">
		        <legend class="">添加成员</legend>
		      </div>
		
		    <div class="control-group">
		
		          <!-- Search input-->
		          <label class="control-label">姓名</label>
		          <div class="controls">
		            <input type="text" placeholder="username" class="input-xlarge">
		            <p class="help-block"></p>
		          </div>
		    </div>
	
		    <div class="control-group">
		
		          <!-- Text input-->
		          <label class="control-label" for="input01">学号</label>
		          <div class="controls">
		            <input type="text" placeholder="userno" class="input-xlarge">
		            <p class="help-block"></p>
		          </div>
		        </div>
		
		    <div class="control-group">
		
		          <!-- Text input-->
		          <label class="control-label" for="input01">默认密码</label>
		          <div class="controls">
		            <input type="text" placeholder="password" class="input-xlarge">
		            <p class="help-block"></p>
		          </div>
		        </div>
		        
		    <div class="control-group">
		          <label class="control-label"></label>
		
		          <!-- Button -->
		          <div class="controls">
		            <button class="btn btn-success">提交</button>
		          </div>
		        </div>
		
		    </fieldset>
		  </form>
	</div>
	<div class="container-fluid">
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
		} );</script>
	</div>
</body>
</html>
