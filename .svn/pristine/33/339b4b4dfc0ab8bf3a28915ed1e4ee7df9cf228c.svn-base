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

<!-- 时钟 -->
<script type="text/javascript" src="js/jquery.flipcountdown.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jquery.flipcountdown.css" />

<style>
/*重置表格hover背景色*/
.table-hover>tbody>tr:hover {
	background-color: #fff6;
}

canvas {
	position: absolute;
	height: 100%;
	width: 100%;
	left: 0;
	top: 0;
	cursor: crosshair;
	background-color: #1a1a1a;
	z-index: 99;
}

.info {
	position: absolute;
	z-index: 100;
}
</style>
<script>
	
	$(function(){

		$("#retroclockbox1").flipcountdown({

			size:"md"

		});

	});
	
	</script>
</head>
<body onselect="document.selection.empty()">

	<canvas></canvas>
	<script type="text/javascript" src="js/script.js"></script>
	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 info">
						<h1 class="page-header" style="border-bottom: 3px solid #fff;">信息主页</h1>
						<h1>Hi,${account.account }</h1>
						<br>
						<h1>当前时间:</h1>
						<div style="color: #fff;" id="retroclockbox1"></div>
					</div>
				</div>



			</div>
		</div>
		<!-- /#page-content-wrapper -->
	</div>
	<!-- /#wrapper -->

</body>
</html>