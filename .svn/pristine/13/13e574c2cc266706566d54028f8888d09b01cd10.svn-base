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
<title>类别管理</title>
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
<script
	src="http://apps.bdimg.com/libs/jquery-lazyload/1.9.5/jquery.lazyload.js"></script>
<!--[if IE]>
		<script src="http://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<![endif]-->
<!-- jqgrid-->
<link href="css/dataGrid/ui.jqgrid.css?0820" rel="stylesheet">
<link href="css/dataGrid/animate.css" rel="stylesheet">
<link href="css/dataGrid/style.css?v=4.1.0" rel="stylesheet">



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

       		$('#addBtn').click(function(){
       			var uid = $('#uid').val();
       			var name = $('#name').val().trim();
       			var descripe = $('#descripe').val().trim();
       			if(!descripe){
       				descripe = '暂未填写';
       			}
       			if(!name){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:类别名称不能为空！</span>');
       				return false;
       			}else{
       				updateForm(uid,name,descripe);
       			}
       		});
       		$('#updateBtn').click(function(){
       			var name = $('#name').val().trim();
       			var descripe = $('#descripe').val().trim();
       			if(!descripe){
       				descripe = '暂未填写';
       			}
       			if(!name){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:类别名称不能为空！</span>');
       				return false;
       			}else{
       				updateForm(uid,name,descripe);
       			}
       		});
       		$('#deleteBtn').click(function(){
       			swal({
       			  title: "是否确定删除该类别?",
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
    					url:'typeDelete',
    					type:'post',
    					dataType:'json',
    					cache:false,
    					data:{
    						'uid':$('#uid').val()
    						},
    					success:function(data){
    						if(data.code==1){
    							swal("删除类别成功", "", "success");
    							jQuery("#table_list_1").trigger("reloadGrid");
    						}else{
    							swal("删除类别失败", "稍后再试吧", "error");
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
				$('#updateBtn').hide();
				$('#deleteBtn').hide();
				$('#addBtn').show();
				$('#btnactive').hide();
                $('#btndisabled').show();
			}
			if(flag){
				$('#name').val('');
				$('#descripe').val('');
				clearTip();
			}
			$('#Modal').modal({
            	show:flag,
            	backdrop:'static'
            });
			jQuery("#table_list_1").trigger("reloadGrid");
		}
		function changeBtn(val){
			if(!val){
				$('#btnactive').hide();
                $('#btndisabled').show();
			}else{
				$('#btnactive').show();
                $('#btndisabled').hide();
			}
		}
		function updateForm(uid,name,descripe){
			$.ajax({
				url:'typeUpdate',
				type:'post',
				dataType:'json',
				cache:false,
				data:{
					'uid':$('#uid').val(),
					'typeName':name,
					'typeDescripe':descripe
					},
				success:function(data){
					if(data.code==1){
						operateModal(false,'add');
						swal('更新类别成功','','success');
						jQuery("#table_list_1").trigger("reloadGrid");
					}else{
						operateModal(false,'add');
						swal('更新类别失败','稍后再试吧','error');
					}
				}
			});
		}
		function clearTip(){
			$('#tipDiv').hide();
			$('#tip').html('');
		}
		function toUpload(){
			var openUrl = 'toUpload?uid='+$('#uid').val()+'&type=type';	//弹出窗口的url
			var iWidth=960; //弹出窗口的宽度;
			var iHeight=600; //弹出窗口的高度;
			var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
			window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft);
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
						<h1 class="page-header" style="border-bottom: 3px solid #fff;">类别管理</h1>
						<button onclick="operateModal(true,'add');autoAdd();"
							type="button" class="btn btn-success btn-md">
							<span class="glyphicon glyphicon-plus"></span> 新增类别
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
						类别信息</h2>
				</div>
				<div style="font-size: 16px" class="modal-body">
					<div class="wrapper wrapper-content">
						<div class="row">
							<div class="col-sm-12">
								<div class="mail-box">
									<div class="mail-body">
										<form class="form-horizontal">
											<div class="form-group">
												<label class="col-sm-3 control-label">类别UID：</label>
												<div class="col-sm-9">
													<input type="hidden" id="uid"> <input type="text"
														id="uid_" disabled class="form-control">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">类别名称：</label>
												<div class="col-sm-9">
													<input type="text" id="name" onfocus="clearTip()"
														onkeyup="changeBtn(this.value);" placeholder="(必填)"
														class="form-control">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">类别描述：</label>
												<div class="col-sm-9">
													<!-- <iframe  src="toAddPro"  scrolling="yes" height="295"  width="100%"  frameborder="0"></iframe> -->
													<input type="text" class="form-control" id="descripe">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">类别图片：</label>
												<div class="col-sm-9">
													<div id="img"></div>
													<button id="btnactive" type="button" onclick="toUpload()"
														style="line-height: 0.429; display: none;"
														class="btn btn-default form-control">上传图片</button>
													<button id="btndisabled" type="button" disabled
														style="line-height: 0.429; display: none;"
														class="btn btn-default form-control">上传图片</button>
												</div>
											</div>
											<div class="form-group " id="tipDiv" style="display: none;">
												<label class="col-sm-3 control-label" for="password"></label>
												<div class="col-sm-9">
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
							data-dismiss="modal">更新类别</button>
						<button id="deleteBtn" type="button" class="btn btn-danger"
							data-dismiss="modal">删除类别</button>
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
    	var imgmap = {};
        $(document).ready(function () {
        	
        	//富文本编辑器


            $.jgrid.defaults.styleUI = 'Bootstrap';

            // Configuration for jqGrid Example 1
            $("#table_list_1").jqGrid({
            	url:'typeList',
                data:'',
                datatype: "json",
                height: 550,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 15,
                rowList: [15, 30, 45],
                colNames: ['类别UID','类别名称', '类别描述','图片地址','创建时间','修改时间'],
                colModel: [
                    {
                        name: 'uid',
                        index: 'uid',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'type_name',
                        index: 'type_name',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },
                    {
                        name: 'type_descripe',
                        index: 'type_descripe',
                        width: 100,
                        sortable: false,
                        //formatter: "number"
                    },
                    {
                        name: 'imgsrc',
                        index: 'imgsrc',
                        width: 80,
                        align: "center",
                        sortable: false,
                        //sorttype: "float",
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
                    },
                    {
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
                viewrecords: true,
                caption: "类别列表",
                hidegrid: true,
                loadtext:'数据加载中...',
                emptyrecords: "暂无数据",
                onSelectRow: function(id){
                    var rowData = $('#table_list_1').jqGrid('getRowData',id);
                    console.log(rowData);
                    operateModal(true,'update');
                    $('#name').val(rowData.type_name);
                    $('#descripe').val(rowData.type_descripe);
                    $('#uid').val(rowData.uid);
                    $('#uid_').val(rowData.uid);
                    getSrc(rowData.uid);
                    $('#btnactive').show();
                    $('#btndisabled').hide();
                  }
                 //onSortCol: function(name,index){ alert("字段名: "+name+" 字段索引: "+index);},
            });
            
            /* jQuery("#table_list_1").jqGrid('filterToolbar',{
            	autosearch:true
            	
            });  */
            jQuery("#table_list_1").jqGrid('navGrid','#pager_list_1',{edit:false,add:false,del:false,search:false});
            // Add responsive to jqGrid
            $(window).bind('resize', function () {
                var width = $('.jqGrid_wrapper').width();
                $('#table_list_1').setGridWidth(width);
                //$('#table_list_2').setGridWidth(width);
            });
            
            

        });
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
					var key = obj.src+',';
					src = src.replace(/\:80/g,'');
					src = src.replace(key,'');
					console.log(src+"-被替换");
     				$.ajax({
  					url:'typeUpdate',
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

        	var url = 'typeGetByUid';
        	$.ajax({
        		url:url,
        		type:'post',
        		dataType:'json',
        		cache:false,
        		data:{
        			'uid':uid
        		},
        		success:function(data){
        			//debugger;
        			$('#img').html('');
        			console.log(data[0].imgsrc);
        			var src = data[0].imgsrc;
        			var imgArr = src.split(',');
        			console.log(imgArr);
        			var len = imgArr.length-1;
        			for(var i=0;i<len;i++){
        				var pic = imgArr[i];
        				//pic = pic.substring(pic.length-21,pic.length);
        				console.log(pic+'-数据库获取');
        				$('#img').append('<img src="'+pic+'" class="lazy" ondblclick="deleteImg(this);" name="'+data[0].uid+'" id="'+src+'"  title="双击图片可删除" style="width:45%;margin:3px;cursor:pointer;border:1px solid #eee"/>');

        			}
        		}
        	});
        }
        
        function autoAdd(){
        	$('#img').html('');
			$.ajax({
				url:'typeAdd',
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