<#macro common>
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Lumino - Tables</title>



<link href="${base}/css/bootstrap.min.css" rel="stylesheet">
<link href="${base}/css/datepicker3.css" rel="stylesheet">
<link href="${base}/css/bootstrap-table.css" rel="stylesheet">

<link href="${base}/css/styles.css" rel="stylesheet">
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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
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
						<a class="" href="#">
							<span class="glyphicon glyphicon-dashboard"></span> 考勤记录
						</a>
					</li>
					<li>
						<a class="" href="#">
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
						<a class="" href="#">
							<span class="glyphicon glyphicon-pencil"></span> 申请
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-pencil"></span> 我的申请
						</a>
					</li>
					<li>
						<a class="" href="#">
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
						<a class="" href="#">
							<span class="glyphicon glyphicon-pencil"></span> 申请
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-pencil"></span> 我的申请
						</a>
					</li>
					<li>
						<a class="" href="#">
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
						<a class="" href="#">
							<span class="glyphicon glyphicon-stats"></span> 考勤查询
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-stats"></span> 审批查询
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
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active"> 设置</li>
			</ol>
		</div><!--/.row-->	
		
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
</body>



</html>
</#macro>
