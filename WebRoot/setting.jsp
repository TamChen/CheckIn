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
  	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap2.3.css">
	<link rel="stylesheet" type="text/css" href="style/layout/bootstrap-responsiv.css">
	<link rel="stylesheet" type="text/css" href="style/layout/dataTables.bootstra.css">
   <script type="text/javascript" src="javascript/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="javascript/highcharts.js"></script>
  <!--  <script type="text/javascript" src="javascript/exporting.js"></script> -->
  <script type="text/javascript" src="javascript/highcharts-more.js"></script>
  <script type="text/javascript" src="javascript/linechart.js"></script>
    <style>
	body{
		margin-top: 20px;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<h1>基本设置</h1>
			<div>
				<ul class="breadcrumb">
					<li>
						<!--  基本说明：在线时长-->
					</li>
					 <li>
						添加IP段<span class="divider">/</span>
					</li>
					<li>
						数据刷新时间 <span class="divider">/</span>
					</li>
					<li>
						过滤
					</li>
					 
				</ul>
			</div>
		</div>
		<div>
		<div style="width:50%;float:left;">
		    <form class="form-horizontal">
			    <fieldset>
			      <div id="legend" class="">
			        <legend class="">添加IP地址段</legend>
			      </div>
			    <div class="control-group">
			
			          <!-- Text input-->
			          <label class="control-label" for="input01">IP起始地址</label>
			          <div class="controls">
			            <input type="text" placeholder="10.28.20.108" class="input-xlarge">
			            <p class="help-block"></p>
			          </div>
			          
			     </div><div class="control-group">
				          <!-- Text input-->
				          <label class="control-label" for="input01">IP终止地址</label>
				          <div class="controls">
				            <input type="text" placeholder="10.28.20.108" class="input-xlarge">
				            <p class="help-block"></p>
				          </div>
			        </div>
			
			    
			
			    <div class="control-group">
			          <label class="control-label">保存</label>
			
			          <!-- Button -->
			          <div class="controls">
			            <button class="btn btn-success">保存</button>
			          </div>
			        </div>
			
			    </fieldset>
 		 </form>
 		 	    <form class="form-horizontal">
			    <fieldset>
			      <div id="legend" class="">
			        <legend class="">频率配置</legend>
			      </div>
			    <div class="control-group">
			
			          <!-- Text input-->
			          <label class="control-label" for="input01">客户端数据刷新（分钟）</label>
			          <div class="controls">
			            <input type="text" placeholder="10" class="input-xlarge">
			            <p class="help-block"></p>
			          </div>
			          
			     </div><div class="control-group">
				          <!-- Text input-->
				          <label class="control-label" for="input01">IP终止地址</label>
				          <div class="controls">
				            <input type="text" placeholder="10.28.20.108" class="input-xlarge">
				            <p class="help-block"></p>
				          </div>
			        </div>
			
			    
			
			    <div class="control-group">
			          <label class="control-label">保存</label>
			
			          <!-- Button -->
			          <div class="controls">
			            <button class="btn btn-success">保存</button>
			          </div>
			        </div>
			
			    </fieldset>
 		 </form>
 		 </div>
	 		 <div   style="width:50%;float:left;">
		 		  <fieldset>
		 		     <div id="legend" class="">
			        <legend class="">基本配置信息</legend>
			      </div>
					        
		 		 	</fieldset>
	 		</div> 	
 		</div>
	</div>
</body>
</html>