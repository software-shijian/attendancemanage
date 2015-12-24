<#include "../common/common.ftl"/>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<@common>
<div style="float:right;margin-top:10px;margin-bottom:5px;">
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(3);"> 所有(${statusMap.all_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(1);"> 同意(${statusMap.ok_approve})</button>
 <button type="button" class="btn btn-default"  data-toggle="button" onClick="all_status(0);"> 未处理(${statusMap.approve})</button>
</div>
<table class="table table-head table-hover bottom-line" id="approveListTable" style="margin-top:10px;">
     <tbody>
        <tr style="background:#DCDCF5;color:black;height:40px;">
          <!--第一个th中加了下拉菜单-->
          <th class="pd03 ws15"  style="width:10%;">序号</th>
          <th class="pd03 ws15"  style="width:10%;">申请类型</th>
          <th id="approveListcontent" style="width:40%;text-align:center">申请内容</th>
          <th id="approListCreateTime"  nowrap="nowrap">申请时间</th>
          <th id="approListApproveUser" class="ws8" >审批人</th>
          <th id="approListResult"  nowrap="nowrap">审批结果</th>
           <th id="approListResult"  nowrap="nowrap">操作</th>
        </tr>
        <#list approveList as approve>
		       <tr data-toggle="modal"  data-target="#myModal">
		       	  <th >${approve_index?number+1}</th>
		          <th >${approve.type_id!""}</th>
		          <th style="text-align:center">${approve.description}</th>
		          <th >${approve.application_time!""}</th>
		          <th  >${approve.last_handler!""}</th>
		          <th>
		          <#if approve.status??>
			          <#if approve.status==0>
			                              审批中
			          <#elseif approve.status==1>
			         	同意
			          <#else>
			                            不同意
			          </#if>
			       </#if>
			      </th>
			      <#if approve.status==0>
			      	<th><button class="btn btn-primary btn-lg" data-toggle="modal"  data-target="#myModal">
			      		审批
                  </button></th>
			      <#else>
			      	<th></th>
			      </#if>
		       </tr>
	     </#list>
   </tbody>
</table>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               模态框（Modal）标题
            </h4>
         </div>
         <div class="modal-body">
            在这里添加一些文本
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<script type="text/javascript">
   			
		
		function all_status(para){
		 var status=""; 
		
		 if(para==0){
			 status="?status=0"
		 }else if(para==1){
		 	 status="?status=1"
		 }else{
		 	 status="?status=3"
		 }
	   	window.location.href="/attendancemanage/nomal/leavareq/forwordMyApprove.jhtml"+status
	     
	 	}
</script>

</@common>


