<#include "../common/_common.ftl"/>
<link rel="stylesheet" type="text/css" href="${base}/css/jquery.datetimepicker.css"/ >
<script src="${base}/js/jquery.js"></script>
<script src="${base}/js/jquery.datetimepicker.js"></script>
<script type="text/javascript">
	$().ready(function(){
		<#if type==2>
			$("#tabName").append("<a href='/attendancemanage/nomal/leavareq/forwordMyApply.jhtml?status=3'>我的请假申请</a>><a href='#'>请假申请详情</a>");
		</#if>
		<#if type==0>
			$("#tabName").append("<a href='/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml?status=3'>我的请假审批</a>><a href='#'>请假申请详情</a>");
		</#if>
		<#if type==1>
			$("#tabName").append("<a href='/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml?status=3'>我的请假审批</a>><a href='#'>请假申请审批</a>");
		</#if>
	})
</script>
<@common>
       <table class="table" style="margin-top:45px;">
       	  <input type="hidden" id="apply_id" value="${appylMap.id!""}"/>
          <tbody>
              <tr>
                   <td style="width:10%;text-align:right;">申请人：</td>
                   <td >${appylMap.username!""}</td>
              </tr>
              <tr>
                   <td style="width:10%;text-align:right;">申请类型：</td>
                   <td >${appylMap.typeName!""}</td>
              </tr>
          	  <tr>
                   <td style="width:19%;text-align:right;">申请人所在部门：</td>
                   <td >${appylMap.departmentName!""}</td>
             </tr>
           
             <tr>
                   <td style="width:10%;text-align:right;">申请时间：</td>
                   <td >${appylMap.application_time!""}</td>
             </tr>
              <tr>
                   <td style="width:13%;text-align:right;">请假开始时间：</td>
                   <td >${appylMap.begin_time!""}</td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;">请假结束时间：</td>
                   <td >${appylMap.end_time!""}</td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00"></span>申请内容：</td>
                   <td  >
                        <div class="form-group">
                         
                          <textarea class="form-control" rows="7" id="description" disabled="true">${appylMap.description!""}</textarea>
                        </div>
                  
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00"></span>审批状态：</td>
                   <td>
                   	<#if appylMap.status==0>
                   		审批中
                   	<#elseif appylMap.status==1>
                   		同意
                   	<#else>
                   		不同意
                   	</#if>
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00"></span>审批人：</td>
                   <td>
			          ${appylMap.handlerName!""}
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00"></span>审批记录：</td>
                   <td>
                   	  <#list appylMap.handler_history?split(";") as hi>
			          	<#if hi??>
			          		${hi}<img src="${base}/img/fangxiang.jpg" width="40px"/> 
			          	</#if>
			          </#list>
			          <#if appylMap.status==1 || appylMap.status==2>
			          		<span style="color:blue">已审批</span>
			          <#else>
			          		<span style="color:red">等待审批</span>
			          </#if>
                   </td>
             </tr>
             <#if type=1>
	             <tr>
	                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>是否同意：</td>
	                   <td>
				          <div class="controls">
				            <select class="input-xlarge" style="width:150px;" id="approve_status">
				                <option value=404>请选择</option>
				             	<option value=1>同意</option>
				              	<option value=2>不同意</option>
				              	<option value=403>请上级审批</option>
				            </select>
	          		     </div>
	                   </td>
	             </tr>
	             
	              <tr id="selectApprove" style="display:none">
	                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>审批人：</td>
	                   <td>
				          <div class="controls">
				            <select class="input-xlarge" style="width:150px;" id="approveId">
				              <option value=500>请选择审批人</option>
				              <#list stuffList as stuff>
				              	<#if stuff.rank gt 0>
				              		<option>${stuff.username!""}</option>
				              	</#if>
				              </#list>
				            </select>
	          		     </div>
	                   </td>
             </tr>
	         </#if>
	        
             <tr>
             	<#if type==1>
             		<td>
             		</td>
	             	<td>
	             		<div class="controls">
				            <button id="commitForm" class="btn btn-success"  onClick="clickHandler()" >提交</button>
				        	 <button id="commitForm" class="btn btn-success"  onClick="returnPage()" >返回</button>
				        </div>
	             	</td>
	             <#else>
	             	<td></td>
	             	<td>
	             		<div class="controls">
				        	 <button id="commitForm" class="btn btn-success"  onClick="returnPage();" >返回</button>
				        </div>
	             	</td>
	             </#if>
                 
             </tr>
           </tbody>
       </table>
      
</@common>
<script type="text/javascript">
	  
	  function clickHandler(){
		  var apply_id= $('#apply_id').val();
	      var approve_status=$('#approve_status').val();
	      var approveId=$('#approveId').val();
	      if(approve_status==404){
	      	alert("请选择审批意见！");
	      	return
	      }
	       if(approveId==500 & approve_status==403){
	      	alert("请选择审批人！");
	      	return
	      }
	     $.get(
		     "/attendancemanage/nomal/leavareq/approveApply.jhtml",
		     {'apply_id':apply_id,'approve_status':approve_status,'approveId':approveId},
		     function(msg){
			     window.location.href="/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml?status=3";
		     }
		     );
	     
	 }
	 
	 function returnPage(){
	 	if(${type}==2){
	 		window.location.href="/attendancemanage/nomal/leavareq/forwordMyApply.jhtml?status=3";
	 	}else{
	 	 	window.location.href="/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml?status=3";
	 	}
	 }
	 
	 $('#approve_status').change(function(){ 
		var p1=$(this).children('option:selected').val();
		if(p1==403){
			$('#selectApprove').css('display', '');
		}else{
			$('#selectApprove').css('display', 'none');
		}
		
		
	}) 

	 		 
</script>
