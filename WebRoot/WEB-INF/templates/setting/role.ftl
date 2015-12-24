<#include "common.ftl"/>
<@common>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Advanced Table</div>
					<div class="panel-body">
						<table data-toggle="table" data-url="/attendancemanage/setting/role.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="name" data-checkbox="true" >Item ID</th>
						        <th data-field="description" >Item ID</th>
						        <th data-field="createDate"  data-sortable="true">Item Name</th>
						        <th data-field="isSystem" data-sortable="true">Item Price</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
		</div><!--/.row-->	
</@common>  