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
<title>产品管理</title>
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
<link rel="stylesheet" href="css/mask.css">
<!-- 信息提示框 -->
<link rel="stylesheet" href="css/alert/sweet-alert.css">
<link rel="stylesheet" href="css/alert/animate.css">
<script src="js/alert/sweet-alert.js"></script>
<!--[if IE]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
<!-- jqgrid-->
<link href="css/dataGrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="css/dataGrid/animate.css" rel="stylesheet">
<link href="css/dataGrid/style.css?v=4.1.0" rel="stylesheet">
<script
	src="http://apps.bdimg.com/libs/jquery-lazyload/1.9.5/jquery.lazyload.js"></script>


<style>
.ui-jqgrid-sortable {
	text-align: center;
}

#table_list_1 {
	cursor: pointer;
}
</style>
<script type="text/javascript">
		$(function(){
			
			$("img.lazy").lazyload({
        		placeholder : "img/loading.gif",
        		effect : "fadeIn",
        		threshold : 200,
        	});
			
			getType();

       		$('#addBtn').click(function(){
       			var uid = $('#uid').val();
       			var name = $('#name').val().trim();
       			var about = $('#about').val().trim();
       			var descript = $('#descript').val();
       			console.log(descript);
       			var type = $('#type').val();
       			if(!descript){
       				descript = '暂未填写';
       			}
       			
       			if(!name){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:产品名称不能为空！</span>');
       				return false;
       			}if(type==0){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:请选择产品类型！</span>');
       				return false;
       			}else{
       				updateForm(uid,name,descript,type,about);
       			}
       		});
       		$('#updateBtn').click(function(){
       			var name = $('#name').val().trim();
       			var uid = $('#uid').val();
       			var about = $('#about').val().trim();
       			var descript = $('#descript').val().trim();
       			var type = $('#type').val();
       			if(!descript){
       				descript = '暂未填写';
       			}
       			
       			if(!name){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:产品名称不能为空！</span>');
       				return false;
       			}if(type==0){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:请选择产品类型！</span>');
       				return false;
       			}else{
       				updateForm(uid,name,descript,type,about);
       			}
       		});
       		$('#deleteBtn').click(function(){
       			swal({
       			  title: "是否确定删除该产品?",
       			  text: "",

       			  type: "warning",

       			  showCancelButton: true,

       			  confirmButtonColor: "#DD6B55",

       			  confirmButtonText: "是",

       			  cancelButtonText: "否",

       			  closeOnConfirm: false,

       			  closeOnCancel: false

       			},

       			function(isConfirm){

       			  if (isConfirm) {

       				$.ajax({
    					url:'productDelete',
    					type:'post',
    					dataType:'json',
    					cache:false,
    					data:{
    						'uid':$('#uid').val()
    						},
    					success:function(data){
    						if(data.code==1){
    							swal("删除产品成功", "", "success");
    							jQuery("#table_list_1").trigger("reloadGrid");
    						}else{
    							swal("删除产品失败", "稍后再试吧", "error");
    						}
    					}
    					
    				});

       			  } else {

       				    swal("您取消了删除操作", "", "error");

       			  }

       			});
       		});
		});
		
		function operateModal(flag,type){
			if(type=='update'){
				$('#addBtn').hide();
				$('#updateBtn').show();
				$('#deleteBtn').show();
			}else{
				//seesion记录uid用于上传图片
				//setSession('uid','');
				$('#updateBtn').hide();
				$('#deleteBtn').hide();
				$('#addBtn').show();
				$('#btnactive').hide();
                $('#btndisabled').show();
                $('#editactive').hide();
                $('#editdisabled').show();
			}
			if(flag){
				$('#uid').val('');
				$('#name').val('');
				$('#descript').val('');
				$('#about').val('');
				$('#img').html('');
				clearTip();
				
			}
			$('#Modal').modal({
            	show:flag,
            	backdrop:'static'
            });
			jQuery("#table_list_1").trigger("reloadGrid");
		}

		function updateForm(uid,name,descript,type,about){
			$.ajax({
				url:'productUpdate',
				type:'post',
				dataType:'json',
				cache:false,
				data:{
					'uid':uid,
					'name':name,
					'descript':about,
					'description':descript,
					'typeId':type
					},
				success:function(data){
					if(data.code==1){
						operateModal(false,'add');
						swal('操作产品成功','','success');
						jQuery("#table_list_1").trigger("reloadGrid");
					}else{
						operateModal(false,'add');
						swal('操作产品失败','稍后再试吧','error');
					}
				}
			});
		}
		function clearTip(){
			$('#tipDiv').hide();
			$('#tip').html('');
		}
		
		function toAddPro(){
			//var enVal = encodeURI(val)
			var uid = $('#uid').val();
			var openUrl = 'toAddPro?val='+uid;	//弹出窗口的url
			var iWidth=960; //弹出窗口的宽度;
			var iHeight=600; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
			window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
		}

		
		function toUpload(){
			var openUrl = 'toUpload?uid='+$('#uid').val()+'&type=product';	//弹出窗口的url
			var iWidth=960; //弹出窗口的宽度;
			var iHeight=600; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
			window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
		}
		
		function getType(){
			$.ajax({
				url:'listType',
				type:'post',
				dataType:'json',
				cache:false,
				data:{},
				success:function(data){
					if(data.length>0){
						$('#type').html('');
						for(var i=0;i<data.length;i++){
							$('#type').append('<option value="'+data[i].id+'">'+data[i].typeName+'</option>');
						}
						
					}else{
						$('#type').html('');
						$('#type').append('<option value="0">请先添加产品类型</option>');
					}
				}
			});
		}
		function changeBtn(val){
			var type = $('#type').val();
			if(!val||type==0){
				$('#btnactive').hide();
                $('#btndisabled').show();
                $('#editactive').hide();
                $('#editdisabled').show();
                return false;
			}else{
				$('#btnactive').show();
                $('#btndisabled').hide();
                $('#editactive').show();
                $('#editdisabled').hide();
			}
		}

	</script>
</head>
<body>

	<div id="loading-mask">
		<div class="loading-img">
			<img alt="努力加载中..." src="img/loading.gif" />
		</div>
	</div>

	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container" style="">
				<div class="row">
					<div class="col-lg-12 ">
						<h1 class="page-header" style="border-bottom: 3px solid #fff;">产品管理</h1>
						<button onclick="operateModal(true,'add');autoAdd();"
							type="button" class="btn btn-success btn-md">
							<span class="glyphicon glyphicon-plus"></span> 新增产品
						</button>
						<div id="wrap" style="">
							<div class="ibox ">

								<div class="ibox-content">
									<div class="jqGrid_wrapper">
										<table style="text-align: center;" id="table_list_1"></table>
										<div id="pager_list_1"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="Modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h2 style="color: #000;" class="modal-title" id="myModalLabel">
						产品信息</h2>
				</div>
				<div style="font-size: 16px" class="modal-body">
					<div class="wrapper wrapper-content">
						<div class="row">
							<div class="col-sm-12">
								<div class="mail-box">
									<div class="mail-body">
										<form class="form-horizontal">
											<div class="form-group">
												<label class="col-sm-3 control-label">产品编号：</label>
												<div class="col-sm-9">
													<input type="hidden" id="uid" class="form-control">
													<input type="text" disabled id="uid_" class="form-control">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">产品名称：</label>
												<div class="col-sm-9">
													<input type="text" onfocus="clearTip();"
														onkeyup="changeBtn(this.value);" placeholder="(必填)"
														id="name" class="form-control">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">产品类型：</label>
												<div class="col-sm-9">
													<select id="type">
														<option value="0">请先添加产品类型</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">产品概述：</label>
												<div class="col-sm-9">
													<input type="text" onfocus="clearTip();"
														placeholder="(用于官网主页产品介绍,建议少于125字)" id="about"
														class="form-control">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">产品详情：</label>
												<div class="col-sm-9">
													<button type="button" id="editactive" onclick="toAddPro()"
														style="line-height: 0.429;"
														class="btn btn-default form-control">文字编辑</button>
													<button type="button" id="editdisabled" disabled
														style="line-height: 0.429;"
														class="btn btn-default form-control">文字编辑</button>
													<!-- <input type="text"  onclick="toAddPro(this.value)" class="form-control" id="descript"> -->
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">产品图片：</label>
												<div class="col-sm-9">
													<div id="img"></div>
													<button type="button" id="btnactive" onclick="toUpload()"
														style="line-height: 0.429;"
														class="btn btn-default form-control">上传图片</button>
													<button type="button" id="btndisabled" disabled
														onclick="toUpload()" style="line-height: 0.429;"
														class="btn btn-default form-control">上传图片</button>
												</div>
											</div>
											<div class="form-group " id="tipDiv" style="display: none;">
												<label class="col-sm-2 control-label" for="password"></label>
												<div class="col-sm-10">
													<span id="tip"></span>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="addBtn" type="button" class="btn btn-success"
							data-dismiss="modal">提交表单</button>
						<button id="updateBtn" type="button" class="btn btn-success"
							data-dismiss="modal">更新产品</button>
						<button id="deleteBtn" type="button" class="btn btn-danger"
							data-dismiss="modal">删除产品</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- Peity -->
		<script src="js/dataGrid/jquery.peity.min.js"></script>

		<!-- jqGrid -->
		<script src="js/dataGrid/grid.locale-cn.js?0820"></script>
		<script src="js/dataGrid/jquery.jqGrid.min.js?0820"></script>
		<!-- 自定义js -->
		<script src="js/dataGrid/content.js?v=1.0.0"></script>


		<!-- Page-Level Scripts -->
		<script>
   		var map = {};
    	var imgmap = {};
    	var descriptmap = {};
    	var PostData={typeId:0};
        $(document).ready(function () {
        	
        	
        	
        	//富文本编辑器


            $.jgrid.defaults.styleUI = 'Bootstrap';
	
            // Configuration for jqGrid Example 1
            $("#table_list_1").jqGrid({
            	url:'productList',
                data:'',
                datatype: "json",
                height: 550,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 15,
                rowList: [15, 30, 45],
                colNames: ['产品编号','产品名称', '类型ID', '产品类型','产品概述','产品描述','图片地址','创建时间','修改时间'],
                colModel: [
                    {
                        name: 'uid',
                        index: 'uid',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'name',
                        index: 'name',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'type_id',
                        index: 'type_id',
                        width: 45,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'type_name',
                        index: 'type_name',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'descript',
                        index: 'descript',
                        width: 90,
                        sortable: true,
                        formatter: customFmatter3
                    },{
                        name: 'description',
                        index: 'description',
                        width: 90,
                        sortable: true,
                        formatter: customFmatter
                    },{
                        name: 'imgsrc',
                        index: 'imgsrc',
                        width: 90,
                        sortable: true,
                        formatter: customFmatter2
                    },
                    {
                        name: 'create_time',
                        index: 'create_time',
                        width: 80,
                        align: "center",
                        //sorttype: "float"
                        sortable: true,
                        formatter: "Date"
                    },{
                        name: 'update_time',
                        index: 'update_time',
                        width: 80,
                        align: "center",
                        //sorttype: "float"
                        sortable: true,
                        formatter: "Date"
                    }
                ],
                rownumbers: true,
                pager: "#pager_list_1",
                sortname: 'create_time',
                sortorder: "desc",
                postData: PostData,
                viewrecords: true,
                caption: "产品列表",
                hidegrid: true,
                loadtext:'数据加载中...',
                emptyrecords: "暂无数据",
                onSelectRow: function(id){
                    var rowData = $('#table_list_1').jqGrid('getRowData',id);
                    var key = rowData.name;
                    console.log(map[key]+"---");
                    operateModal(true,'update');
                    $('#name').val(rowData.name);
                    $('#descript').val(map[key]);
                    $('#type').val(rowData.type_id);
                    $('#about').val(descriptmap[key]);
                    $('#uid').val(rowData.uid);
                    $('#uid_').val(rowData.uid);
                    //console.log(rowData.id);
                    //渲染图片
                    //debugger;
                    if(imgmap[rowData.name]){
                    	getSrc(rowData.uid);
                    }
                    $('#btnactive').show();
                    $('#btndisabled').hide();
                    $('#editactive').show();
                    $('#editdisabled').hide();
                    
                  },
                 loadComplete:function(data){
                	 //console.log(data.rows);
                 }
                 //onSortCol: function(name,index){ alert("字段名: "+name+" 字段索引: "+index);},
            });

            jQuery("#table_list_1").jqGrid('navGrid','#pager_list_1',{edit:false,add:false,del:false,search:false});
            // Add responsive to jqGrid
            $(window).bind('resize', function () {
                var width = $('.jqGrid_wrapper').width();
                $('#table_list_1').setGridWidth(width);
            });
            
            

        });
        
        function customFmatter(cellvalue, options, rowObject){
        	map[rowObject.name] = cellvalue;
        	//debugger; 
        	var str;
            if(!cellvalue){
        		str = '暂未填写';
        	}else{
        		str = "点击可查看详情";
        	}
            return str; 
        };
        
        function customFmatter2(cellvalue, options, rowObject){  
        	imgmap[rowObject.name] = cellvalue;
        	var str;
        	if(!cellvalue){
        		str = '暂无记录';
        	}else{
        		str = "点击可查看详情";
        	}
            return str;  
        };
        function customFmatter3(cellvalue, options, rowObject){  
        	imgmap[rowObject.name] = cellvalue;
        	var str;
        	if(!cellvalue){
        		str = '暂未填写';
        	}else{
        		str = "点击可查看详情";
        	}
            return str;  
        };
        
        function deleteImg(obj){
        	
        	console.log(obj);
        	swal({
     			  title: "是否确定删除该图片?",
     			  text: "",

     			  type: "warning",

     			  showCancelButton: true,

     			  confirmButtonColor: "#DD6B55",

     			  confirmButtonText: "是",

     			  cancelButtonText: "否",

     			  closeOnConfirm: false,

     			  closeOnCancel: false

     			},

     			function(isConfirm){

     			  if (isConfirm) {
     				//debugger;
					var src = obj.id;
					var key = obj.src;
					var num = key.indexOf('user');
					var str = key.substring(num)+',';
					//src = src.replace(/\:80/g,'');
					src = src.replace(str,'');
					console.log(src+"-被替换");
     				$.ajax({
  					url:'updateByUid',
  					type:'post',
  					dataType:'json',
  					cache:false,
  					data:{
  						'uid':obj.name,
  						'imgsrc':src
  						},
  					success:function(data){
  						if(data.code==1){
  							getSrc(obj.name);
  							swal("删除图片成功", "", "success");
  							
  						}else{
  							swal("删除图片失败", "稍后再试吧", "error");
  						}
  					}
  					
  				});

     			  } else {

     				    swal("您取消了删除操作", "", "error");

     			  }

     			});
        }
        
        function getSrc(uid){

        	var url = 'productGetByUid';
        	$.ajax({
        		url:url,
        		type:'post',
        		dataType:'json',
        		cache:false,
        		data:{
        			'uid':uid
        		},
        		success:function(data){
        			$('#img').html('');
        			console.log(data[0].imgsrc);
        			$('#about').val(data[0].descript);
        			var src = data[0].imgsrc;
        			var imgArr = src.split(',');
        			console.log(imgArr);
        			var len = imgArr.length-1;
        			for(var i=0;i<len;i++){
        				var pic = imgArr[i].substring(5);
        				//pic = pic.substring(pic.length-21,pic.length);
        				console.log(pic+'-数据库获取');
        				$('#img').append('<img src="'+pic+'" class="lazy" ondblclick="deleteImg(this);" name="'+data[0].uid+'" id="'+src+'"  title="双击图片可删除" style="width:45%;margin:3px;cursor:pointer;border:1px solid #eee"/>');

        			}
        		}
        	});
        }

        
        function autoAdd(){
			$.ajax({
				url:'productAdd',
				type:'post',
				dataType:'json',
				cache:false,
				data:{

				},
				success:function(data){
					$('#uid').val(data.message);
					$('#uid_').val(data.message);
				}
			});
		}



    </script>
</body>
</html>