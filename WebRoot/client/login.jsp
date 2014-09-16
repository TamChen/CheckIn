<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
 <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style/layout/login.css">
	<script src="javascript/jquery-1.8.3.min.js"></script>
	<style type="text/css">
	body{
		height:100%;
		width:100%;
		margin:0;
	 } 
	 .cover
        {
            width: 100%;
            height: 100%;
            position: fixed;
            z-index: -10;
            _position: absolute;
            _top: expression(eval(document.body.scrollTop));
            _left: expression(eval(document.body.scrollLeft));
        }
	.cover img
         {
          width:100%;
          height:100%;
          border:0;
          }
	</style>
  </head>
  
  <body style="-webkit-app-region: drag ;font-family:'微软雅黑';">
  <div class="cover">
  <img alt="" src="style/img/bg5.jpg"/>
  </div>
  
   <!-- 
    <form method="post" action="login" >
         UserName<input type="text" name="name" id="name"/><br/>
         Password<input type="password" name="password" id="password"/><br/>
     <input type="submit" value="login" /></form>
     -->
      <!-- 
     <form id="login" method="post" action="login">
  -->
  <!--  
   <div style="width:30px;height:30px;float:right;">
 
  </div>
  -->
  <div style="width:250px;height:70px;color:white;padding-top:100px;padding-left:100px;font-size:30px;">IT实验室管理系统</div>
   <div style="padding-left:100px;padding-top:0px;line-height: 24px;font-size:15px;color:white;font-family='Consolas';">
   <p>
   {<br><br>
   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;body{background:#f3f3f4;font-family:"open sans"}<br>
   		<br>
   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a:hover,a:active<br>
   		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a{color:#293c4e;-webkit-transition:.25s;transition:.25s}<br>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;header{left:0;right:0;z-index:1030}<br><br>
   }
   </p>
   </div>
   <form id="login" action="login" method="post">
    <h1>用户登录</h1>

    <fieldset id="inputs" >

        <input id="name" name="name" type="text" placeholder="用户名"  autofocus required>   

        <input id="password" name="password" type="password" placeholder="密码" required>

    </fieldset>

    <fieldset id="actions">

        <input onclick="login01();" id="submit" type="submit" style="font-size:15px;" value="登  录"/>

     <!--   <a href="">忘记密码?</a><a href="">注册</a>-->

    </fieldset>
<!--  
    <a href="http://www.sharejs.com/subject/1599" id="back">Back to article...</a>
-->
</form>

	
	<script>

function login01(){

        // var name= $("#name").val();
        // var password= $("#password").val();
        // $(function () {
        //   $.post("http://127.0.0.1:8080/CheckIn/login.action",{"name":$("#name").val(),"password":$("#password").val()},function(result){    
        //     if(result!=null)//0  成功  1  不成功  2 手机号码格式不对
        //         {   
        //         // window.location.href="main.html";
        //         }   

        //     });
        // });

  }
function close(){
    alert("hello");
  }
	</script>
  </body>
</html>

