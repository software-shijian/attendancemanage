<#include "common.ftl"/>
<@common>
		<link href="${base}/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="${base}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		<link href="${base}/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />					
		<link href="${base}/css/add-ons.min.css" rel="stylesheet" />
	<script>
	$(document).ready(function() {;
   });
	</script>
		<div class="row">		
						<div class="col-lg-12">
							<div class="panel panel-default bk-bg-white">
								<div class="panel-heading bk-bg-white">
									<h3><i class="fa fa-table"></i><span class="break"></span>角色管理</h3>

								</div>
								<div class="panel-heading bk-bg-white">
									<div class="panel-actions">
										<a href="#" class="btn-minimize"><i class="fa fa-edit"> 新增角色 </i></a>
									</div>
								</div>
								<div class="panel-body">
									<div class="table-responsive">	
										<table class="table table-striped table-bordered bootstrap-datatable datatable">
											<thead>
												<tr>
													<th>名字</th>
													<th>描述</th>
													<th>系统管理员</th>
													<!--<th>状态</th>-->
													<th>操作</th>
												</tr>
											</thead>   
											<tbody>			
											<#list rows as role> 				
												<tr id="tr${role.id}">
													<td>${role.name!""}</td>
													<td>${role.description!""}</td>
													<td>
													<#if role.isSystem>
													是
													<#else>
													否
													</#if>													
													</td>
													<!--<td>
														<span class="label label-warning">Pending</span>
													</td>-->
													<td>
														<a class="btn btn-info" href="table.html#">
															<i class="fa fa-edit "></i>                                            
														</a>
														<a class="btn btn-danger" href="table.html#">
															<i class="fa fa-trash-o "></i> 
														</a>
													</td>
												</tr>
											</#list>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>					
					</div>

</@common>  