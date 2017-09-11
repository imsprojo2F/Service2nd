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
<title>需求主页</title>
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
       
		});
		
		

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
						<h1 class="page-header" style="border-bottom: 3px solid #fff;">需求管理</h1>
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
						信息详情</h2>
				</div>
				<div style="font-size: 16px" class="modal-body">
					<span style="font-weight: bold;">姓名：</span><span id="dname"></span><br>
					<hr>
					<span style="font-weight: bold;">手机：</span><span id="dphone"></span><br>
					<hr>
					<span style="font-weight: bold;">邮箱：</span><span id="demail"></span><br>
					<hr>
					<span style="font-weight: bold;">需求：</span><span id="dmessage"></span><br>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
            	url:'infoList',
                data:'',
                datatype: "json",
                height: 550,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 15,
                rowList: [15, 30, 45],
                colNames: [/* '序号',  */'姓名', '手机', '邮箱', '时间', '需求'],
                colModel: [
                   /*  {
                        name: 'id',
                        index: 'id',
                        width: 60,
                        sorttype: "int"
                    }, */
                    {
                        name: 'name',
                        index: 'name',
                        width: 90,
                        sortable: false,
                        formatter: "String"
                    },
                    {
                        name: 'phone',
                        index: 'phone',
                        width: 100,
                        sortable: false,
                        //formatter: "number"
                    },
                    {
                        name: 'email',
                        index: 'email',
                        width: 80,
                        align: "center",
                        sortable: false,
                        //sorttype: "float",
                        //formatter: "email"
                    },
                    {
                        name: 'create_time',
                        index: 'create_time',
                        width: 80,
                        align: "center",
                        //sorttype: "float"
                        sortable: false,
                        formatter: "Date"
                    },
                    {
                        name: 'message',
                        index: 'message',
                        width: 80,
                        align: "center",
                        //sorttype: "float"
                        sortable: false,
                        formatter: "String"
                    }
                ],
                rownumbers: true,
                pager: "#pager_list_1",
                viewrecords: true,
                caption: "需求列表",
                hidegrid: true,
                loadtext:'数据加载中...',
                emptyrecords: "暂无数据",
                onSelectRow: function(id){
                    var rowData = $('#table_list_1').jqGrid('getRowData',id);
                    console.log(rowData.name);
                    $('#dname').html(rowData.name);
                    $('#dphone').html(rowData.phone);
                    $('#demail').html(rowData.email);
                    $('#dmessage').html(rowData.message);
                    $('#Modal').modal({
                    	show:true
                    });
                  }
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