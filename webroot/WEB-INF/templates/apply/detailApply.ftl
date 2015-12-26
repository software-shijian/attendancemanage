<#include "../common/_common.ftl"/>
<link rel="stylesheet" type="text/css" href="${base}/css/jquery.datetimepicker.css"/ >
<script src="${base}/js/jquery.js"></script>
<script src="${base}/js/jquery.datetimepicker.js"></script>

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
             <#if type=1>
	             <tr>
	                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>是否同意：</td>
	                   <td>
				          <div class="controls">
				            <select class="input-xlarge" style="width:150px;" id="status">
				                <option value=404>请选择</option>
				             	<option value=1>同意</option>
				              	<option value=2>不同意</option>
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
	      var status=$('#status').val();
	      if(status==404){
	      	alert("请选择是否同意！");
	      	return
	      }
	     $.get(
		     "/attendancemanage/nomal/leavareq/approveApply.jhtml",
		     {'apply_id':apply_id,'status':status},
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

	 		 
</script>
