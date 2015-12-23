<#include "../common/_left.ftl"/>
<@left>
       <table class="table" style="margin-top:45px;">
          <tbody>
              <tr>
                   <td style="width:10%;text-align:right;">申请人：</td>
                   <td >杨刚</td>
              </tr>
              <tr>
                   <td style="width:10%;text-align:right;">申请部门：</td>
                   <td >技术部</td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>申请内容：</td>
                   <td  >
                        <div class="form-group">
                         
                          <textarea class="form-control" rows="5"></textarea>
                        </div>
                        <div>
                           <label class="sr-only" for="inputfile">文件输入</label>
                           <input type="file" id="inputfile">
                         </div>
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;"><span style="color:#F00">*</span>审批人：</td>
                   <td >
                     <button class="btn btn-link" data-toggle="modal" data-target="#myModal">
                                选择审批人
                     </button>
                     <!--开始模态框-->
                     <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                          <div class="modal-dialog">
                               <div class="modal-content">
                                 <div class="modal-header">
                                    <button type="button" class="close"  data-dismiss="modal" aria-hidden="true"> &times;
                                      </button>
                                     <h4 class="modal-title" id="myModalLabel"> 选择申请人 </h4>
                                 </div>
                                 <!--模态框主体-->
                                 <div class="modal-body">
                                       <!--搜索框-->
                                       <div>
                                          <form class="navbar-form navbar-left" role="search">
                                             <div class="form-group">
                                              <input type="text" class="form-control" placeholder="Search">
                                             </div>
                                             <button type="submit" class="btn btn-default">搜索</button>
                                          </form>    
                                        </div>

                                 </div>
                                 <div class="modal-footer">
                                      <button type="button" class="btn btn-primary">确定</button>
                                      <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
                                       
                                 </div>
                                </div>
                          </div>
                       </div>
                   </td>
             </tr>
             <tr>
                   <td style="width:10%;text-align:right;">提醒方式：</td>
                   <td >
                       <div>
                             <label class="checkbox-inline">
                                <input type="checkbox" id="inlineCheckbox1" value="option1"> 即时通讯
                             </label>
                             <label class="checkbox-inline">
                                <input type="checkbox" id="inlineCheckbox2" value="option2"> 邮件
                             </label>
                        </div>
                  </td>
             </tr>
           </tbody>
       </table>
</@left>
