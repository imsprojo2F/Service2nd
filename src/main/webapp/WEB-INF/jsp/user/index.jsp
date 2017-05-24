<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png" />
<title>用户主页</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/back/htmleaf-demo.css">
<link rel="stylesheet" href="css/back/style.css">
<!--[if IE]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
<script src="js/menuRedirect.js"></script>

<style>
/*重置表格hover背景色*/
.table-hover>tbody>tr:hover {
	background-color: #fff6;
}
</style>
</head>
<body style="overflow-y: hidden">

	<div id="wrapper" style="z-index: 999; position: absolute;">
		<div class="overlay"></div>

		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top"
			id="sidebar-wrapper" role="navigation">
			<ul class="nav sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Hi,${account.account }
				</a></li>
				<li><a onclick="redirect('main');" href="javascript:;"><span
						class="glyphicon glyphicon-home">&nbsp;&nbsp;</span>信息主页</a></li>
				<li><a onclick="redirect('userOperate');" href="javascript:;"><span
						class="glyphicon glyphicon-user">&nbsp;&nbsp;</span>用户管理</a></li>
				<li><a onclick="redirect('typeOperate');" href="javascript:;"><span
						class="glyphicon glyphicon-tags">&nbsp;&nbsp;</span>类别管理</a></li>
				<li><a onclick="redirect('productOperate');"
					href="javascript:;"><span
						class="glyphicon glyphicon-shopping-cart">&nbsp;&nbsp;</span>产品管理</a>
				</li>
				<li><a onclick="redirect('newsOperate');" href="javascript:;"><span
						class="glyphicon glyphicon-envelope">&nbsp;&nbsp;</span>资讯管理</a></li>
				<li><a onclick="redirect('info');" href="javascript:;"><span
						class="glyphicon glyphicon-list-alt">&nbsp;&nbsp;</span>需求管理</a></li>
				<!-- <li>
                    <a href="#"><span class="glyphicon glyphicon-time">&nbsp;&nbsp;</span>操作记录</a>
                </li> -->
				<li><a href="loginOut"><span
						class="glyphicon glyphicon-log-out">&nbsp;&nbsp;</span>退出系统</a></li>
			</ul>
		</nav>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<button type="button" class="hamburger is-closed animated fadeInLeft"
				data-toggle="offcanvas">
				<span class="hamb-top"></span> <span class="hamb-middle"></span> <span
					class="hamb-bottom"></span>
			</button>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<iframe id="link" src="main" scrolling="auto" width="100%"
		onload="changeFrameHeight()" frameborder="0"></iframe>


	<script type="text/javascript">
			var trigger = $('.hamburger'),
		    overlay = $('.overlay'),
		   isClosed = false;
		$(document).ready(function () {
		  

		    trigger.click(function () {
		      hamburger_cross();      
		    });

		    function hamburger_cross() {

		      if (isClosed == true) {          
		        overlay.hide();
		        trigger.removeClass('is-open');
		        trigger.addClass('is-closed');
		        isClosed = false;
		      } else {   
		        overlay.show();
		        trigger.removeClass('is-closed');
		        trigger.addClass('is-open');
		        isClosed = true;
		      }
		  }
		  
		  $('[data-toggle="offcanvas"]').click(function () {
		        $('#wrapper').toggleClass('toggled');
		  }); 
		  	
		  //trigger.click();
		});
		$(function(){
			
		})
	</script>
</body>
</html>