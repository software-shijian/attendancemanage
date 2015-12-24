<#include "../common/common.ftl"/>
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
				<h3><i class="fa fa-table"></i><span class="break"></span>我的申请</h3>
				<div style="float:right;margin-top:10px;margin-bottom:5px;">
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(3);"> 所有(${statusMap.all_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(0);"> 审批中(${statusMap.approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(1);"> 同意(${statusMap.ok_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(2);"> 不同意(${statusMap.no_approve})</button>
</div>
			</div>
			<div class="panel-body">
				<div class="table-responsive">	
					<table class="table table-striped table-bordered bootstrap-datatable datatable">
						<thead>
							<tr>
								  <th>序号</th>
						          <th>申请类型</th>
						          <th>申请内容</th>
						          <th>申请时间</th>
						          <th>审批人</th>
						          <th>审批结果</th>
						        
							</tr>
						</thead>   
						<tbody>			
						<#list leaveRequestList as leaveRequest>		
								<tr>
								<td>${leaveRequest_index?number+1}</td>
								<td>${leaveRequest.type_id!""}</td>
								<td>${leaveRequest.description}</td>
								<td>${leaveRequest.application_time!""}</td>
								<td>${leaveRequest.last_handler!""}</td>
								<td>
									 <#if leaveRequest.status??>
								          <#if leaveRequest.status==0>
								                              审批中
								          <#elseif leaveRequest.status==1>
								         	同意
								          <#else>
								                            不同意
								          </#if>
								       </#if>
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

<script type="text/javascript">
   		function all_status(para){
		 var status=""; 
		
		 if(para==0){
			 status="?status=0"
		 }else if(para==1){
		 	 status="?status=1"
		 }else if(para==2){
		 	 status="?status=2"
		 }else{
		 	 status="?status=3"
		 }
	   	window.location.href="/attendancemanage/nomal/leavareq/forwordMyApply.jhtml"+status
	     
	 	}
   		
</script>

</@common>


