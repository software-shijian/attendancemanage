<#macro common>
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>考勤管理系统</title>



<link href="${base}/css/bootstrap.min.css" rel="stylesheet">
<link href="${base}/css/datepicker3.css" rel="stylesheet">
<link href="${base}/css/bootstrap-table.css" rel="stylesheet">

<link href="${base}/css/styles.css" rel="stylesheet">
	<link href="${base}/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="${base}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		<link href="${base}/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />					
		<link href="${base}/css/add-ons.min.css" rel="stylesheet" />
		<link href="${base}/css/toastr/toastr.min.css" rel="stylesheet" />
		<script src="${base}/js/toastr/toastr.min.js"></script>
<!--datatables-->
<link href="${base}/datatables/jquery-datatables-bs3/css/datatables.css" rel="stylesheet" />
<link href="${base}/datatables/select2.css" rel="stylesheet" />
<link href="${base}/datatables/font-awesome.min.css" rel="stylesheet" />

<script src="${base}/js/jquery/jquery.min.js"></script>


<!--[if lt IE 9]>

<script src="${base}/js/html5shiv.js"></script>

<script src="${base}/js/respond.min.js"></script>

<![endif]-->



</head>



<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>考勤</span>管理</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>欢迎您， ${Session.username!""} <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/attendancemanage/logout.jhtml"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="parent " id="checkparent">
				<a href="#">
					<span class="glyphicon glyphicon-dashboard"></span> 考勤管理  <span data-toggle="collapse" href="#check" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="check">
					<li>
						<a class="" href="/attendancemanage/attendanceRecord/record.jhtml">
							<span class="glyphicon glyphicon-dashboard"></span> 考勤记录
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/attendanceRecord/chart.jhtml">
							<span class="glyphicon glyphicon-dashboard"></span> 考勤统计
						</a>
					</li>
				</ul>
			</li>
			<li class="parent " id="leaveparent">
				<a href="#">
					<span class="glyphicon glyphicon-pencil"></span> 请假管理 <span data-toggle="collapse" href="#leave" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="leave">
					<li>
						<a class="" href="/attendancemanage/nomal/leavareq/forwordApply.jhtml">
							<span class="glyphicon glyphicon-pencil"></span> 申请
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/nomal/leavareq/forwordMyApply.jhtml?status=3">
							<span class="glyphicon glyphicon-pencil" ></span> 我的申请
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml?status=3">
							<span class="glyphicon glyphicon-pencil"></span> 我的审批
						</a>
					</li>
				</ul>
			</li>
			<li class="parent " id="outparent">
				<a href="#">
					<span class="glyphicon glyphicon-pencil"></span> 外出管理 <span data-toggle="collapse" href="#out" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="out">
					<li>
						<a class="" href="/attendancemanage/nomal/out/forwordApply.jhtml">
							<span class="glyphicon glyphicon-pencil"></span> 申请
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/nomal/out/forwordMyApply.jhtml?status=3">
							<span class="glyphicon glyphicon-pencil" ></span> 我的申请
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/nomal/out/forwordMyApprove.jhtml?status=3">
							<span class="glyphicon glyphicon-pencil"></span> 我的审批
						</a>
					</li>
				</ul>
			</li>
			<li class="parent " id="queryparent">
				<a href="#">
					<span class="glyphicon glyphicon-stats"></span> 综合查询  <span data-toggle="collapse" href="#query" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="query">
					<li>
						<a class="" href="/attendancemanage/search/attendanceRecord.jhtml">
							<span class="glyphicon glyphicon-stats"></span> 考勤查询
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/search/leaveRequest.jhtml">
							<span class="glyphicon glyphicon-stats"></span> 请假审批查询
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/search/outRequest.jhtml">
							<span class="glyphicon glyphicon-stats"></span> 外出审批查询
						</a>
					</li>
				</ul>
			</li>
			<li class="parent " id="settingparent">
				<a href="#">
					<span class="glyphicon glyphicon-th"></span> 设置 <span data-toggle="collapse" href="#setting" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="setting">
					<li>
						<a class="" href="/attendancemanage/setting/role.jhtml">
							<span class="glyphicon glyphicon-th"></span> 角色设置
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/setting/roleAuthority.jhtml">
							<span class="glyphicon glyphicon-th"></span> 权限设置
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/setting/stuffRole.jhtml">
							<span class="glyphicon glyphicon-th"></span> 员工角色配置
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/setting/vacationInfo.jhtml">
							<span class="glyphicon glyphicon-th"></span> 假期配置
						</a>
					</li>
					<li>
						<a class="" href="/attendancemanage/setting/systemConfig.jhtml">
							<span class="glyphicon glyphicon-th"></span> 系统配置
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>
		</ul>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		
		<#nested>
		
	</div><!--/.main-->

	<script src="${base}/js/jquery-1.11.1.min.js"></script>

	<script src="${base}/js/bootstrap.min.js"></script>

	<script src="${base}/js/chart.min.js"></script>
	<script src="${base}/js/chart-data.js"></script>
	<script src="${base}/js/easypiechart.js"></script>
	<script src="${base}/js/easypiechart-data.js"></script>
	<script src="${base}/js/bootstrap-datepicker.js"></script>
	<script src="${base}/js/bootstrap-table.js"></script>
	<script src="${base}/js/bootstrap-datepicker.zh-CN.js"></script>
	
	<!-- datatables -->
    <script src="${base}/datatables/jquery-datatables/media/js/jquery.dataTables.js"></script>
	<script src="${base}/datatables/jquery-datatables/extras/TableTools/js/dataTables.tableTools.min.js"></script>
	<script src="${base}/datatables/jquery-datatables-bs3/js/datatables.js"></script>
	<script src="${base}/datatables/table-advanced.js"></script>
	<script src="${base}/datatables/select2.js"></script>
	
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
	
	<!-- 日历script -->
	<script>
		$('#calendar').datepicker({
			language: "zh-CN",
            todayHighlight: true
		});
	</script>
	
	
</body>



</html>
</#macro>
