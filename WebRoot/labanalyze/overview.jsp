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
	<script type="text/javascript" src="../javascript/avetime.js"></script>
	<script type="text/javascript" src="../javascript/rateline.js"></script>
	<script type="text/javascript">
    /*
    * 智能机浏览器版本信息:
    *
    */
      var browser={
        versions:function(){ 
               var u = navigator.userAgent, app = navigator.appVersion; 
               return {//移动终端浏览器版本信息 
                    trident: u.indexOf('Trident') > -1, //IE内核
                    presto: u.indexOf('Presto') > -1, //opera内核
                    webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                    mobile: !!u.match(/AppleWebKit.*Mobile.*/)||!!u.match(/AppleWebKit/), //是否为移动终端
                    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                    android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                    iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
                    iPad: u.indexOf('iPad') > -1, //是否iPad
                    webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
                };
             }(),
             language:(navigator.browserLanguage || navigator.language).toLowerCase()
    		} 
    		document.writeln("语言版本: "+browser.language);
    		document.writeln(" 是否为移动终端: "+browser.versions.mobile);
    		document.writeln(" ios终端: "+browser.versions.ios);
    		document.writeln(" android终端: "+browser.versions.android);
    		document.writeln(" 是否为iPhone: "+browser.versions.iPhone);
    		document.writeln(" 是否iPad: "+browser.versions.iPad);
    		document.writeln(navigator.userAgent);
     </script>
	
  <style>
		body{
			margin-top: 20px;
		}
	</style>
	
</head>
	<body>
	
	
	<div class="container-fluid float:left;">
		<div class="row-fluid">
			<h1>基本信息分析表</h1>
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
	<div>
	 <div id="avetime" style="min-width:500px;height:400px;float:left"></div>
	 
	  <div id="rateline" style="min-width:500px;height:400px;float:left"></div>
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
						<th>平均每人在线时长</th>
						<th>每日到勤率</th>
						<th>在线人数</th>
						<th>时间最长</th>
						<th>总体评级</th>
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
    					"sAjaxSource": '${pageContext.request.contextPath}/getEveyDataAction.action',
    					"bAutoWidth": false,
        				"oLanguage": {
        					"sUrl": "../json/zh_CN.json"
							} 
					});
		} );
	function export01(){
		$.ajax({
			url:'${pageContext.request.contextPath}/exportAction.action?export=everyday',
			success:function(result){
				window.location.href=result;}
		});
	}
	</script>
	</div>
</body>
</html>
