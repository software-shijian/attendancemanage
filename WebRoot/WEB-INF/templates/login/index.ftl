<#include "../common/_left.ftl"/>
<@left>
sdf胜多负少地方
<div class="container-fluid">
  <div class="right_record">
    <!--右边导出行-->
        <div class="right_record ">
          <button type="button" class="btn btn-default"  data-toggle="button"> 导出</button>
            <div style="float:right;">
             <button type="button" class="btn btn-primary"  data-toggle="button"> 所有(1)</button>
             <button type="button" class="btn btn-default"  data-toggle="button"> 同意(0)</button>
             <button type="button" class="btn btn-default"  data-toggle="button"> 审批中(1)</button>
             <button type="button" class="btn btn-default"  data-toggle="button"> 不同意(0)</button>
             <button type="button" class="btn btn-default"  data-toggle="button"> 已撤回(0)</button>
            </div>
        </div>
    <!--右边审批行-->
       <div  class="right_record ">
          <table class="table table-head table-hover bottom-line" id="approveListTable" style="margin-top:10px;">
             <tbody>
                <tr>
                  <!--第一个th中加了下拉菜单-->
                  <th class="pd03 ws15">
                    <div class="btn-group">
                       <button type="button" class="btn btn-default">全部类型</button>
                      <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                         <span class="sr-only">切换下拉菜单</span>
                      </button>
                     <ul class="dropdown-menu" role="menu">
                           <li><a href="#">全部类型</a></li>
                           <li><a href="#">日常</a></li>
                           <li><a href="#">出差</a></li>
                           <li><a href="#">外勤</a></li>
                           <li><a href="#">借款</a></li>
                           <li><a href="#">休假</a></li>
                         
                           <li><a href="#">报销</a></li>
                           <li><a href="#">公文</a></li>
                           <li><a href="#">其他</a></li>
                     </ul>
                   </div>
                  </th>
                 
                  <th id="approveListcontent" style="width:48%;">申请内容</th>
                  <th id="approListCreateTime"  nowrap="nowrap">申请时间</th>
                  <th id="approListApproveUser" class="ws8" >审批人</th>
                  <th id="approListResult"  nowrap="nowrap">审批结果</th>
                </tr>
               <tr   onclick="  ">
                  <th >休假</th>
                  
                  <th >我要休假</th>
                  <th >2015-12-17</th>
                  <th  >经理</th>
                  <th  style="color:#080">审批中</th>
              </tr>
           </tbody>
        </table>
        </div>
</div>

</@left>