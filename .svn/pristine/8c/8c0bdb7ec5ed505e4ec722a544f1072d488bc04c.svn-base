<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>上传图片</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<link href="css/fonts/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/upload/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="css/upload/webuploader-demo.css">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>Web Uploader</h5>
						<!-- <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_file_upload.html#">选项1</a>
                                </li>
                                <li><a href="form_file_upload.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div> -->
					</div>
					<div class="ibox-content">
						<div class="page-container">
							<p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮.</p>
							<div id="uploader" class="wu-example">
								<div class="queueList">
									<div id="dndArea" class="placeholder">
										<div id="filePicker"></div>
										<p>或将图片拖到这里，建议图片尺寸600*300</p>
									</div>
								</div>
								<div class="statusBar" style="display: none;">
									<div class="progress">
										<span class="text">0%</span> <span class="percentage"></span>
									</div>
									<div class="info"></div>
									<div class="btns">
										<div id="filePicker2"></div>
										<div class="uploadBtn">开始上传</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>
	<!-- Web Uploader -->
	<script type="text/javascript">
        // 添加全局站点信息
        var BASE_URL = 'js/upload/webuploader';
    </script>
	<script src="js/upload/webuploader.min.js"></script>
	<script src="js/upload/webuploader-demo.js"></script>

	<script>
		var id
	    var uid;
		var type;
		$(function(){
			var name,value; 
			var str=location.href; //取得整个地址栏
			var num=str.indexOf("?") 
			str=str.substr(num+1); //取得所有参数   stringvar.substr(start [, length ]
			var arr=str.split("&"); //各个参数放到数组里
			debugger;
			for(var i=0;i < arr.length;i++){ 
			    num=arr[i].indexOf("="); 
			    if(num>0){ 
				     name=arr[i].substring(0,num);
				     value=arr[i].substr(num+1);
				     this[name]=value;
				     if(i==0){
				    	 uid = value;
				    	 setSession('uid',uid);
				     }else{
				    	 type = value;
				    	 setSession('type',type);
				     }
				     //alert('name:'+name+'\nvalue:'+value+'\nindex:'+i);
			     } 
			} 

		})
	
		function setSession(key,value){
			console.log('key:'+key+"---value:"+value);
			$.ajax({
				url:'setSession',
				type:'post',
				dataType:'json',
				cache:false,
				data:{
					'key':key,
					'value':value
				},
				success:function(data){
					//console.log(data.message);
					//$('#uid').val(data.message);
				}
			});
		}
	</script>



</body>

</html>
