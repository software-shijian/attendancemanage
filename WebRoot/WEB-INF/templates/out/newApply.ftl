<#include "../common/_common.ftl"/>
<link rel="stylesheet" type="text/css" href="${base}/css/jquery.datetimepicker.css"/ >
<script src="${base}/js/jquery.js"></script>
<script src="${base}/js/jquery.datetimepicker.js"></script>

<@common>
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li id="tabName">外出管理</li>
			
			</ol>
		</div><!--/.row-->	
<div class="row">		
		<div class="col-lg-12">
					<div class="panel panel-default bk-bg-white">
								<div class="panel-heading bk-bg-white">
									<h3><i class="fa fa-table"></i><span class="break"></span> 新建申请</h3>
								</div>
       <table class="table">
       	  <input type="hidden" id="username" value="${stuff.username!""}"/>
          <tbody>
              <tr>
                   <td style="width:10%;text-align:right;">申请人：</td>
                   <td >${stuff.username!""}</td>
              </tr>
               <tr>
	               <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>申请类型：</td>
	               <td>
			          <div class="controls">
			            <select class="input-xlarge" style="width:150px;" id="leaveTypeId">
			              <option>请选择申请类型</option>
			              <#list outTypeList as outType>	              	
			              		<option value="${outType.id}">${outType.name}</option>
			              </#list>
			            </select>
	      		     </div>
	               </td>
             </tr>
          	  <tr>
                   <td style="width:10%;text-align:right;">申请部门：</td>
                   <td >${stuff.depart!""}</td>
             </tr>
              <tr>
                   <td style="width:13%;text-align:right;">外出开始时间：</td>
                   <td ><input type="text"  id="datetimepicker1"/></td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;">外出结束时间：</td>
                   <td ><input type="text"  id="datetimepicker2"/></td>
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
             	</td>
                 
	             <td>
			          <div class="controls">
			            <button id="commitForm" class="btn btn-success"  onClick="clickHandler()" >提交</button>
			          </div>
		          </td>
             </tr>
           </tbody>
       </table>
        	</div>
	</div>
       
</div>      
</@common>
<script type="text/javascript">
	  
	  function clickHandler(){
		  var description= $('#description').val();
	      var approveId=$('#approveId').val();
	      var username=$('#username').val();
	      var datetimepicker1=$('#datetimepicker1').val();
	      var datetimepicker2=$('#datetimepicker2').val();
	      var leaveTypeId=$('#leaveTypeId').val();
	      if(description==null || description==""){
	      	alert('申请理由不能为空', '友情提示！');
	      	return
	      }
	      if(approveId=="请选择审批人"){
	      	alert('请选择审批人', '友情提示！');
	      	return
	      }
	      
	       if(leaveTypeId=="请选择申请类型"){
	      	alert('请选择申请类型', '友情提示！');
	      	return
	      }
	      if(datetimepicker1=="" || datetimepicker1==null){
	      	alert('请选择开始时间', '友情提示！');
	      	return
	      }
	      if(datetimepicker2=="" || datetimepicker2==null){
	      	alert('请选择结束时间', '友情提示！');
	      	return
	      }
	      
	       if(datetimepicker2<datetimepicker1){
	      	alert('请选择开始时间不能大于结束时间', '友情提示！');
	      	return
	      }
	     $.post(
		     "/attendancemanage/nomal/out/newApply.jhtml",
		     {'description':description,'approveId':approveId,"username":username,"datetimepicker1":datetimepicker1,"datetimepicker2":datetimepicker2,"leaveTypeId":leaveTypeId},
		     function(msg){
			     window.location.href="/attendancemanage/nomal/out/forwordMyApply.jhtml?status=3"
		     }
		     );
	     
	 }
	$('#datetimepicker1').datetimepicker();
	$('#datetimepicker2').datetimepicker();

	 		 
</script>
