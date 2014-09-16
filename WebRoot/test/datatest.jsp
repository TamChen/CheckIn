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
	<link rel="stylesheet" type="text/css" href="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/bootstrap-responsiv.css">
	<link rel="stylesheet" type="text/css" href="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/dataTables.bootstra.css">

</head>
	<body>
		
	
	<div class="container-fluid">
		<div class="row-fluid">
			<h1>Datatables + Bootstrap 基本配置 2</h1>
			<div>
				<ul >
					<li><span  class="text-info">使用的插件</span></li>
					<ul class="inline">
						<li><span  class="text-info">jQuery</span></li>
						<li><span  class="text-info">Bootstrap</span></li>
						<li><span  class="text-info">Datatables</span></li>
						<li><span  class="text-info">sco.js</span></li>
						<li><span  class="text-info">TableTools</span></li>
						<li><span  class="text-info">dataTables.bootstrap.js</span></li>
					</ul>
					<li><span class="text-warning">已知问题</span></li>
					<ul class="inline">
						<li><span class="text-warning">打印时无法控制列的输出</span></li>
						<li><span class="text-warning">导出 PDF 时中文是乱码</span></li>
					</ul>
				</ul>
			</div>
			<div>
				<ul class="breadcrumb">
					<li>
						功能：
					</li>
					<li>
						分页 <span class="divider">/</span>
					</li>
					<li>
						排序 <span class="divider">/</span>
					</li>
					<li>
						过滤 <span class="divider">/</span>
					</li>
					<li>
						json 数据源  <span class="divider">/</span>
					</li>
					<li>
						<del>	数据导出 (需 flash 支持) </del><span class="divider">/</span>
					</li>
					<li>
						自定义列 <span class="divider">/</span>
					</li>
					<li>
						自定义分页选项
					</li>
				</ul>				
			</div>
		</div>
		<div class="alert">
<button type="button" class="close" data-dismiss="alert">×</button>
<ul>
	<li>由于 runjs 不支持 flash 上传，故数据导出及打印功能无法演示，请自行研究。</li>
	<li>表格中的按钮是有图标的，懒得改原始 css 了。</li>
	<li>点击修改按钮应导入编辑界面，请自行修改。</li>
	<li>sco 创建 confirm 时会缓存数据，请确保每行数据有个唯一值，并指定创建 confirm 的 ID，不然会产生错误。由于演示数据没有唯一值，所以使用了随机值。</li>
</ul>
</div>
		<div class="row-fluid">

			<table class="table table-striped table-bordered table-hover table-condensed datatable">
				<thead>
					<tr>
						<th>Rendering engine</th>
						<th>Browser</th>
						<th>Platform(s)</th>
						<th>Engine version</th>
						<th>CSS grade</th>
						<th>Action</th>
						
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
<div class="modal fade" id="myModal">
            <div class="modal-header">                
                <a href="#" class="close" data-dismiss="modal">×</a>
                <h3></h3>
            </div>
            <div class="modal-body inner">                
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal">关闭</a>                
            </div>
        </div>
	<!-- jQuery -->
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/jquery.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/bootstrap.min.js"></script>
		<!-- datatables -->
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/jquery.dataTables.js"></script>	
<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/dataTables.bootstrap.js"></script>
	<!-- sco.js-->
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/sco.confirm.js"></script>
	<script type="text/javascript" src="http://sandbox.runjs.cn/uploads/rs/238/n8vhm36h/sco.modal.js"></script>
	<script>
	var removeUser = function(){
		console.log("remove data: " + this.options.title);	        	
		this.close();	        	
	}
			
	 var gtime = Date.now || function(){
	        return +new Date;
	 };

	$(document).ready(function() {
			$('.datatable').dataTable( {
					"bProcessing": true,
	        				"aLengthMenu": [[5,10, 25, 50, 100, -1],[5, 10, 25, 50, 100,"所有"]],
	        				"sAjaxSource": '../json/json_source.json',
	        				"oLanguage": {
											"sUrl": "../json/zh_CN.json"					
									},
									"aoColumnDefs": [
					   					{
													"aTargets": [5],
													"mData": null,
												"bSortable": false,
	                    "bSearchable": false,
												  "mRender": function (data, type, full) {
															return '<a data-trigger="modal" data-title="查看信息:' + full[1] + '" data-content="' + full+'" data-target="#myModal"  class="btn btn-success" href="#"><i class="icon-zoom-in icon-white"></i>查看</a>'+ 
							'<a data-trigger="modal" data-title="編輯信息:' + full[1] + '"  class="btn btn-info" href="#"><i class="icon-edit icon-white"></i>修改</a>' +
							'<a data-trigger="confirm" class="btn btn-danger" data-target="#del-'+ 
							gtime() + Math.floor(Math.random() * 100 ) +
	'" data-title="'+ full[1] +'" data-id="' + full[1] +'" data-content="您確定要刪除這條數據 <code> :title </code> 嗎？ " data-action="removeUser"><i class="icon-trash icon-white"></i>删除</a>';
													}
											}]
			});
	});</script>
	</body>
</html>