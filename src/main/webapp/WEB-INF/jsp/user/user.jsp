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
			
			var type = '${account.type}';
			if(type!=1){
				$('#wrapper').html('<center><h1>您当前权限不足,不可操作用户。</h1><center>');
			}
			
       		$('#addBtn').click(function(){
       			var account = $('#account').val().trim();
       			var password = $('#password').val().trim();
       			if(!account||!password){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:账号或密码不能为空！</span>');
       				return false;
       			}else if(account.length<5||password.length<5){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:账号或密码长度过短！</span>');
       				return false;
       			}else{
       				submitForm(account,password);
       			}
       		});
       		$('#updateBtn').click(function(){
       			var account = $('#account').val().trim();
       			var password = $('#password').val().trim();
       			if(!account||!password){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:账号或密码不能为空！</span>');
       				return false;
       			}else if(account.length<5||password.length<5){
       				$('#tipDiv').show();
       				$('#tip').html('<span style="color:red">提示:账号或密码长度过短！</span>');
       				return false;
       			}else{
       				updateForm(account,password);
       			}
       		});
       		$('#deleteBtn').click(function(){
       			swal({
       			  title: "是否确定删除该用户?",
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
    					url:'userDelete',
    					type:'post',
    					dataType:'json',
    					cache:false,
    					data:{
    						'id':$('#id').val()
    						},
    					success:function(data){
    						if(data.code==1){
    							swal("删除用户成功", "", "success");
    							jQuery("#table_list_1").trigger("reloadGrid");
    						}else{
    							swal("删除用户失败", "稍后再试吧", "error");
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
			}
			if(flag){
				$('#account').val('');
				$('#password').val('');
				clearTip();
			}
			$('#Modal').modal({
            	show:flag
            });
		}

		var oldAcc;
		function validate(val){
			if(!val){
				return false;
			}else if(val.length<5){
				return false;
			}else if(val==oldAcc){
				return false;
			}else{
				$.ajax({
					url:'userValidate',
					type:'post',
					dataType:'json',
					cache:false,
					data:{
						'account':val
						},
					success:function(data){
						if(data.code==1){
							clearTip();
							$('#tipDiv').show();
		       				$('#tip').html('<span style="color:#27c24c">提示:账号可用。</span>');
						}else{
							clearTip();
							$('#tipDiv').show();
		       				$('#tip').html('<span style="color:red">提示:账号不可用！</span>');
		       				setTimeout(function(){
		       					$('#account').val('');
		       				},3000);
						}
					}
					
				});
			}
		}
		function submitForm(acc,pass){
			$.ajax({
				url:'userAdd',
				type:'post',
				dataType:'json',
				cache:false,
				data:{
					'account':acc,
					'password':pass
					},
				success:function(data){
					if(data.code==1){
						operateModal(false,'add');
						swal('添加用户成功','','success');
						jQuery("#table_list_1").trigger("reloadGrid");
					}else{
						operateModal(false,'add');
						swal('添加用户失败','稍后再试吧','error');
					}
				}
			});
		}
		function updateForm(acc,pass){
			$.ajax({
				url:'userUpdate',
				type:'post',
				dataType:'json',
				cache:false,
				data:{
					'id':$('#id').val(),
					'account':acc,
					'password':pass
					},
				success:function(data){
					if(data.code==1){
						operateModal(false,'add');
						swal('更新用户成功','','success');
						jQuery("#table_list_1").trigger("reloadGrid");
					}else{
						operateModal(false,'add');
						swal('更新用户失败','稍后再试吧','error');
					}
				}
			});
		}
		function clearTip(){
			$('#tipDiv').hide();
			$('#tip').html('');
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
						<h1 class="page-header" style="border-bottom: 3px solid #fff;">用户管理</h1>
						<button onclick="operateModal(true,'add')" type="button"
							class="btn btn-success btn-md">
							<span class="glyphicon glyphicon-plus"></span> 新增用户
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
						用户信息</h2>
				</div>
				<div style="font-size: 16px" class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group ">
							<label class="col-sm-2 control-label" for="account">账号</label>
							<div class="col-sm-10">
								<input type="hidden" id="id"> <input
									onfocus="clearTip()" class="form-control"
									onkeyup="this.value = this.value.replace(/[^0-9a-zA-Z@.\-]/g,'');validate(this.value);"
									id="account" type="text" placeholder="账号不少于5个字符">
							</div>
						</div>
						<div class="form-group ">
							<label class="col-sm-2 control-label" for="password">密码</label>
							<div class="col-sm-10">
								<input class="form-control" onfocus="clearTip()" id="password"
									type="password" placeholder="密码不少于5个字符">
							</div>
						</div>
						<div class="form-group " id="tipDiv" style="display: none;">
							<label class="col-sm-2 control-label" for="password"></label>
							<div class="col-sm-10">
								<span id="tip"></span>
							</div>
						</div>

						<!-- <div class="form-group has-success">
							<label class="col-sm-2 control-label" for="inputSuccess">
								输入成功
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputSuccess">
							</div>
						</div> -->
					</form>

				</div>
				<div class="modal-footer">
					<button id="addBtn" type="button" class="btn btn-success"
						data-dismiss="modal">提交表单</button>
					<button id="updateBtn" type="button" class="btn btn-success"
						data-dismiss="modal">更新用户</button>
					<button id="deleteBtn" type="button" class="btn btn-danger"
						data-dismiss="modal">删除用户</button>
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
        $(document).ready(function () {

            $.jgrid.defaults.styleUI = 'Bootstrap';

            // Configuration for jqGrid Example 1
            $("#table_list_1").jqGrid({
            	url:'userList',
                data:'',
                datatype: "json",
                height: 550,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 15,
                rowList: [15, 30, 45],
                colNames: ['用户ID','账号', '密码', /* '账号类型', */ '创建时间'],
                colModel: [
                    {
                        name: 'id',
                        index: 'id',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },{
                        name: 'account',
                        index: 'account',
                        width: 90,
                        sortable: true,
                        formatter: "String"
                    },
                    {
                        name: 'password',
                        index: 'password',
                        width: 100,
                        sortable: false,
                        //formatter: "number"
                    },
                    /* {
                        name: 'type',
                        index: 'type',
                        width: 80,
                        align: "center",
                        sortable: false,
                        //sorttype: "float",
                        //formatter: "email"
                    }, */
                    {
                        name: 'create_time',
                        index: 'create_time',
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
                caption: "用户列表",
                hidegrid: true,
                loadtext:'数据加载中...',
                emptyrecords: "暂无数据",
                onSelectRow: function(id){
                    var rowData = $('#table_list_1').jqGrid('getRowData',id);
                    console.log(rowData);
                    operateModal(true,'update');
                    $('#account').val(rowData.account);
                    oldAcc = rowData.account;
                    $('#password').val(rowData.password);
                    $('#id').val(rowData.id);
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
    </script>


</body>
</html>