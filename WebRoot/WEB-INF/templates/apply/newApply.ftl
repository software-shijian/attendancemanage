<#include "../common/_left.ftl"/>
<@left>
       <table class="table" style="margin-top:45px;">
       	  <input type="hidden" id="username" value="${stuff.username!""}"/>
          <tbody>
              <tr>
                   <td style="width:10%;text-align:right;">申请人：</td>
                   <td >${stuff.username!""}</td>
              </tr>
          	  <tr>
                   <td style="width:10%;text-align:right;">申请部门：</td>
                   <td >${stuff.depart!""}</td>
             </tr>
             
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>申请内容：</td>
                   <td  >
                        <div class="form-group">
                         
                          <textarea class="form-control" rows="7" id="description"></textarea>
                        </div>
                  
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>审批人：</td>
                   <td>
			          <div class="controls">
			            <select class="input-xlarge" style="width:150px;" id="approveId">
			              <option>请选择审批人</option>
			              <#list stuffList as stuff>
			              	<#if stuff.rank gt 0>
			              		<option>${stuff.username!""}</option>
			              	</#if>
			              </#list>
			            </select>
          		     </div>
                   </td>
             </tr>
             <tr>
	             <td>
			          <div class="controls">
			            <button id="commitForm" class="btn btn-success"  onClick="clickHandler()" >提交</button>
			          </div>
		          </td>
             </tr>
           </tbody>
       </table>
      
</@left>
<script type="text/javascript">
	  
	  function clickHandler(){
		  var description= $('#description').val();
	      var approveId=$('#approveId').val();
	      var username=$('#username').val();
	      if(description==null || description==""){
	      	alert('申请理由不能为空', '友情提示！');
	      	return
	      }
	      if(approveId=="请选择审批人"){
	      	alert('请选择审批人', '友情提示！');
	      	return
	      }
	     $.get(
		     "/attendancemanage/nomal/leavareq/newApply.jhtml",
		     {'description':description,'approveId':approveId,"username":username},
		     function(msg){
			     window.location.href="/attendancemanage/nomal/leavareq/forwordMyApply.jhtml"
		     }
		     );
	     
	 }
	 		 
</script>
