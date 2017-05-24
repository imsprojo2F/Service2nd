<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>文字编辑</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<script src="js/product/summernote-zh-CN.js"></script>
</head>
<body>
	<div id="summernote">
		<p>请输入产品描述</p>
	</div>
	<center>
		<button onclick="updataData()" onfocus="this.blur()"
			class="btn btn-default btn-sm">完成编辑</button>
	</center>
	<script>
  	var uid;
    $(document).ready(function() {
        $('#summernote').summernote({
        	lang: 'zh-CN',
        	height: 300,                 // set editor height
        	minHeight: null,             // set minimum height of editor
        	maxHeight: null,             // set maximum height of editor
        	focus: false                 // set focus to editable area after initializing summernote
        });
        
        var url = window.location.href;
    	var str = url.split("val=");
    	uid = str[1];
    	getData(uid);
        
    });
    
    function getData(uid){
    	if(!uid){
    		return false;
    	}else{
    		$.ajax({
    			url:'productGetByUid',
    			dataType:'json',
    			type:'post',
    			cache:false,
    			data:{
    				'uid':uid
    			},
    			success:function(data){
    				console.log(data);
    				$('#summernote').summernote('code',data[0].description);
    			}
    		});
    	}
    }
    function updataData(){
    	var str = $('#summernote').summernote('code');
    	$.ajax({
			url:'updateByUid',
			dataType:'json',
			type:'post',
			cache:false,
			data:{
				'uid':uid,
				'description':str
			},
			success:function(data){
				if(data.code==1){
					window.close();
				}
			}
		});
    	
    }
    
    
    
  </script>
</body>
</html>