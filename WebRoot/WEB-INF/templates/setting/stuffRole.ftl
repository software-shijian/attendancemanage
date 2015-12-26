<#include "common.ftl"/>
<@common>
		<link href="${base}/vendor/skycons/css/skycons.css" rel="stylesheet" />
		<link href="${base}/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		<link href="${base}/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />					
		<link href="${base}/css/add-ons.min.css" rel="stylesheet" />
	<script>
	$(document).ready(function() {;
   });
	</script>
		<div class="row">		
						<div class="col-lg-12">
							<div class="panel panel-default bk-bg-white">
								<div class="panel-heading bk-bg-white">
									<h3><i class="fa fa-table"></i><span class="break"></span> 员工角色设定</h3>
								</div>
								<div class="panel-heading bk-bg-white">
									<div class="panel-actions">
										<a href="#" class="btn-minimize" href="javascript:void(0)" onclick="update(this);"><i class="fa fa-edit">  新增</i></a>
									</div>
								</div>
								<div class="panel-body">
									<div class="table-responsive">	
										<table class="table table-striped table-bordered bootstrap-datatable datatable">
											<thead>
												<tr>
													<th> 姓名</th>
													<th> 用户名</th>
													<!--<th>状态</th>-->
													<th> 角色</th>
													<th> 操作</th>
												</tr>
											</thead>   
											<tbody>			
											<#list rows as roleAuthority> 				
												<tr id="tr${roleAuthority.id}">
													
													<#list stuffs as stuff>											
													<#if stuff.id==roleAuthority.stuffId>
													<td>
													${stuff.name}
													</td>
													<td>
													${stuff.username}
													</td>
													</#if>	
													</#list>	
													
													<td>
													<#list roles as ro>											
													<#if ro.id==roleAuthority.role>
													
													${ro.name}
													</#if>	
													</#list>	
													</td>
													
													
													
													<!--<td>
														<span class="label label-warning">Pending</span>
													</td>-->
													<td>
														<a class="btn btn-info" href="javascript:void(0)" onclick="update(this)">
															<i class="fa fa-edit " ></i>                                            
														</a>
														<a class="btn btn-danger" href="javascript:void(0)" onclick="showDlg(this)">
															<i class="fa fa-trash-o "></i> 
														</a>
													</td>
												</tr>
											</#list>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>					
					</div>


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
         <form id="dataform" name="dataform">
             <table>
                                  <tr>
                                    <th><span style="color:#F00">*</span> 员工：</th>
                                    <th >
                                       <input type="hidden" id ="id" name="id">
                                       <select class="form-control" id ="stuffId" name="stuffId">
                                       <#list stuffs as stuff>											
													<#if (stuff.rank>0)>
													<option value ="${stuff.id}">${stuff.name}</option>
													<#else>
													<option value ="${stuff.id}">&emsp;----${stuff.name}</option>
													</#if>
													</#list>	
									   </select>
                                       <input type="hidden"  id ="_method" name="_method">
                                    </th>
                                  </tr>
                                  <tr>
                                    <th><span style="color:#F00">*</span> 角色：</th>
                                    <th >
                                    <select class="form-control" id ="role" name="role">										
									   <#list roles as ro>
													<option value ="${ro.id}">${ro.name}</option>
									   </#list>	
								    </select>
                                    </th>
                                  </tr>
                                  
                                  
             </table>
         </form>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" id="confirmSubmit">
              	 确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<div class="modal fade" id="myDlg" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
            		   是否删除？
            </h4>
         </div>
         <div >
         <input type="hidden"  id ="todelete" name="todelete">
         </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" id="confirmDelete" onclick="deleteData(this)">
             	  确定
            </button>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
<script>

 
function showDlg(obj){
$('.modal-title').text("是否删除？");
//alert("wdw");
var keyorid=$(obj).parent().parent().attr("id");//
//alert();
$('#todelete').val(keyorid.substring(2));
$('#myDlg').modal('show');
}

function update(obj){
	//alert($('#dataform').serialize());
		var tds=$(obj).parent().parent().find('td');
		if($(obj).hasClass("btn-minimize")){
		$('.modal-title').text("新增");
		$('#name').removeAttr("readonly");
		$('#age').val("");
		$('#name').val("");
		$('#gender').val("");
		$('#days').val("");
		$('#seniority').val("");
		$('#id').val("");
		$("#confirmSubmit").removeAttr("onclick");
		$("#confirmSubmit").attr("onclick","submitData('post');");
				//alert($('#dataform').serialize());
		}else{
		$('.modal-title').text("编辑");
		$("#confirmSubmit").removeAttr("onclick");
		$("#confirmSubmit").attr("onclick","submitData('put');");
		$('#name').attr("readonly","readonly");
		var keyorid=$(obj).parent().parent().attr("id");
		$('#id').val(keyorid.substring(2));
		$('#name').val(tds.eq(0).text());
		$('#days').val(tds.eq(1).text());
		$('#seniority').val(tds.eq(2).text());
		$('#age').val(tds.eq(3).text());
		$('#gender').val(tds.eq(4).text().substring(0,1));
		if(isNaN(tds.eq(2).text())){
		$('#seniority').val("");
		}
		if(tds.eq(4).text().substring(0,1)=="3"){
		$('#gender').val("");
		}
		if(tds.eq(3).text()){
		$('#age').val("");
		}
		}
		$('#myModal').modal('show');
	}
	
function submitData(reqtype){
	$('#_method').val(reqtype);
	$.ajax({type:"post",
	url:"/attendancemanage/setting/stuffRole/"+reqtype+".json",
	contentType: "application/x-www-form-urlencoded;charset=utf-8", 
	data:$('#dataform').serialize(),
	success: function(data){
	//alert("sdf");
 if(data.result=='1'){
 $('#myModal').modal('hide');
 location.reload();}
 else {$('#myModal').modal('hide');toastr["info"]("操作失败!");}
 }
 }); 
}

function deleteData(obj){
keyv=$('#todelete').val();
//alert(keyv);
$.ajax({type:"post",
	url:"/attendancemanage/setting/stuffRole/delete.json",
	contentType: "application/x-www-form-urlencoded; charset=utf-8",
	data:{"id":keyv,"_method":"delete"},
	success: function(data){
	//alert("sdf");
 if(data=='1'){
 $('#myDlg').modal('hide');
 location.reload();}
 else {$('#myDlg').modal('hide');toastr["info"]("操作失败!");}
 }
 }); 
}

</script>
</@common>  