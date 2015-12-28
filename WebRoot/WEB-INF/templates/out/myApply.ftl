<#include "../common/_common1.ftl"/>
<@common>
	<script type="text/javascript">
		$().ready(function(){
			$("#tabName").append("<a href='/attendancemanage/nomal/out/forwordMyApply.jhtml?status=3'>我的外出申请</a>");
		})	
</script>
<div class="row">		
	<div class="col-lg-12">
		<div class="panel panel-default bk-bg-white">
			<div class="panel-heading bk-bg-white">
				<h3><i class="fa fa-table"></i><span class="break"></span>我的外出申请</h3>
				<div style="float:right;margin-top:10px;margin-bottom:5px;">
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(3);"> 所有(${statusMap.all_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(0);"> 审批中(${statusMap.approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(1);"> 同意(${statusMap.ok_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(2);"> 不同意(${statusMap.no_approve})</button>
</div>
			</div>
			<div class="panel-body">
				<div class="panel-body">	
					<table class="table table-bordered table-striped mb-none" id="datatable-details">
						<thead>
							<tr>
								  <th>序号</th>
						          <th>申请类型</th>
						          <th>申请内容</th>
						          <th>申请时间</th>
						          <th>开始时间</th>
						          <th>结束时间</th>
						          <th>审批人</th>
						          <th>审批结果</th>
						          <th>操作</th>
							</tr>
						</thead>   
						<tbody>		
						<#if outRequestList??>	
							<#list outRequestList as outRequest>		
									<tr>
									<td>${outRequest_index?number+1}</td>
									<td>${outRequest.typeName!""}</td>
									<td>${outRequest.description}</td>
									<td>${(outRequest.applicationTime?string("yyyy-MM-dd HH:mm"))!}</td>
									<td>${(outRequest.beginTime?string("yyyy-MM-dd HH:mm"))!}</td>
									<td>${(outRequest.endTime?string("yyyy-MM-dd HH:mm"))!}</td>
									<td>${outRequest.lastHandlerName!""}</td>
									<td>
										 <#if outRequest.status??>
									          <#if outRequest.status==0>
									                              审批中
									          <#elseif outRequest.status==1>
									         	同意
									          <#else>
									                            不同意
									          </#if>
									       </#if>
									</td>
									<td>
										<button class="btn btn-info" onclick="approve(${outRequest.id},2)">
											       详情                                  
										</button>
										
									</td>
								</tr>
							</#list>
						</#if>
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
		   	window.location.href="/attendancemanage/nomal/out/forwordMyApply.jhtml"+status
	     
	 	}
	 	
	 	
	 	function approve(para,type){
	 		window.location.href="/attendancemanage/nomal/out/forwordApplyDetail.jhtml?leaveRequestId="+para+"&type="+type;
	 	}
   		
</script>

</@common>


