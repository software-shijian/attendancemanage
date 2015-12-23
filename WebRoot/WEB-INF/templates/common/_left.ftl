<#include "_head.ftl"/>
<#macro left>
	<@head></@head>
	<!--左边导航栏·-->
   	<div style="background-color:#c6c6ff">
           <div class="col-md-2 col-lg-2 col-xs-2 col-sm-2" style="margin-top: 40px;">
               <ul class="nav nav-pills nav-stacked">
                  <li class="active"><a href="#">考勤管理</a></li>
                  <li><a href="#">考勤记录</a></li>
                  <li class="active"><a href="#">请假管理</a></li>
                  <li><a href="#">申请</a></li>
                  <li><a href="#">我的申请</a></li>
                  <li><a href="#">我的审批</a></li>
                  <li class="active"><a href="#">系统管理</a></li>
                  <li><a href="#">XXXXX</a></li>
                  <li><a href="#">XXXXX</a></li>
                  <li class="active"><a href="#">导出管理</a></li>
                  <li><a href="#">考勤导出</a></li>
                  <li><a href="#">审批导出</a></li>
               </ul>
           </div>`
    </div>
	<div class="appealrecord">
	<div style="background-color:#edeff0;">
	<br>
	<#nested>
	</div>	
	</div>
</#macro>
