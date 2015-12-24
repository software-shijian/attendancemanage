<#include "../common/_left.ftl"/>
<@left>
<div style="float:right;margin-top:10px;margin-bottom:5px;">
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(3);"> 所有(${statusMap.all_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(0);"> 审批中(${statusMap.approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(1);"> 同意(${statusMap.ok_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(2);"> 不同意(${statusMap.no_approve})</button>
</div>
<table class="table table-head table-hover bottom-line" id="approveListTable" style="margin-top:10px;">
     <tbody>
        <tr style="background:#DCDCF5;color:black;height:40px;">
          <!--第一个th中加了下拉菜单-->
           <th class="pd03 ws15"  style="width:10%;">序号</th>
          <th class="pd03 ws15">申请类型</th>
          <th id="approveListcontent" style="width:40%;">申请内容</th>
          <th id="approListCreateTime"  nowrap="nowrap">申请时间</th>
          <th id="approListApproveUser" class="ws8" >审批人</th>
          <th id="approListResult"  nowrap="nowrap">审批结果</th>
        </tr>
       
       <#if leaveRequestList??>
	       	<#list leaveRequestList as leaveRequest>
	       	<tr>
	       	  <th >${leaveRequest_index?number+1}</th>
	          <th>${leaveRequest.type_id!""}</th>
	          <th>${leaveRequest.description!""}</th>
	          <th>${leaveRequest.application_time!""}</th>
	          <th>${leaveRequest.last_handler!""}</th>
	          <th>
	          <#if leaveRequest.status==0>
	                              审批中
	          <#elseif leaveRequest.status==1>
	         	同意
	          <#else>
	                            不同意
	          </#if>
	        </th>
	        </tr>
	        </#list>
	  </#if>
      
   </tbody>
</table>
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
</@left>
