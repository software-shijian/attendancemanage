<#include "../common/_left.ftl"/>
<@left>
<div style="float:right;margin-top:10px;margin-bottom:5px;">
 <button type="button" class="btn btn-default"  data-toggle="button"> 所有(1)</button>
 <button type="button" class="btn btn-default"  data-toggle="button"> 同意(0)</button>
 <button type="button" class="btn btn-default"  data-toggle="button"> 未处理(0)</button>
</div>
<table class="table table-head table-hover bottom-line" id="approveListTable" style="margin-top:10px;">
     <tbody>
        <tr style="background:#DCDCF5;color:black;height:40px;">
          <!--第一个th中加了下拉菜单-->
          <th class="pd03 ws15"  style="width:10%;">申请类型</th>
          <th id="approveListcontent" style="width:48%;text-align:center">申请内容</th>
          <th id="approListCreateTime"  nowrap="nowrap">申请时间</th>
          <th id="approListApproveUser" class="ws8" >审批人</th>
          <th id="approListResult"  nowrap="nowrap">审批结果</th>
        </tr>
        <#list approveList as approve>
		       <tr>
		          <th >${approve.type_id!""}</th>
		          <th style="text-align:center">${approve.description}</th>
		          <th >${approve.application_time!""}</th>
		          <th  >${approve.last_handler!""}</th>
		          <th  style="color:#080">${approve.status!""}</th>
		       </tr>
	     </#list>
   </tbody>
</table>



</@left>
