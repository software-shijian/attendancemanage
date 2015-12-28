package com.attendance.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.attendance.manage.model.OutRequest;
import com.attendance.manage.model.OutType;
import com.attendance.manage.model.Stuff;
import com.attendance.manage.service.CheckInfoService;
import com.attendance.manage.service.OutRequestService;
import com.attendance.manage.service.OutTypeService;
import com.attendance.manage.service.StuffService;

@Scope("prototype")
@Controller
@RequestMapping("/nomal/out")
public class OutRequestController {
	@Autowired
	private CheckInfoService checkInfoServiceImpl;
	@Autowired
	private OutRequestService outRequestServiceImpl;
	@Autowired
	private StuffService stuffServiceImpl;
	@Autowired
	private OutTypeService outTypeServiceImpl;

	
	/**
	 * 跳转到新建申请页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordApply", method = RequestMethod.GET)
	public String forwordApply(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//员工信息
		Stuff stuff=stuffServiceImpl.findUserInfo("ling");
		//请假类型信息
		List<OutType> outTypeList=outTypeServiceImpl.selectAll();
		//经理信息
		List<Stuff> stuffList=stuffServiceImpl.selectAll();
		model.addAttribute("stuff", stuff);
		model.addAttribute("stuffList", stuffList);
		model.addAttribute("outTypeList", outTypeList);
		return "/out/newApply";

	}
	
	/**
	 * 申请
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newApply", method = RequestMethod.GET)
	public String newApply(String description,String approveId,String username,
			String datetimepicker1,String datetimepicker2,String leaveTypeId,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OutRequest outRequest=new OutRequest();
		outRequest.setDescription(description);
		outRequest.setLastHandler(stuffServiceImpl.findByUsername(approveId).getId());
		outRequest.setHandlerHistory(approveId);
		outRequest.setApplicationTime(new Date());
		outRequest.setCreateDate(new Date());
		
		outRequest.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((datetimepicker1.replace("/", "-")+":00")));
		outRequest.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetimepicker1.replace("/", "-")+":00"));
		outRequest.setStatus(0);
		outRequest.setModifyDate(new Date());
		outRequest.setStuffId(stuffServiceImpl.findByUsername(username).getId());
		outRequest.setTypeId(Long.parseLong(leaveTypeId));
		outRequestServiceImpl.newApply(outRequest);
		return null;

	}
	
	/**
	 * 跳转到我的申请页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordMyApply", method = RequestMethod.GET)
	public String forwordMyApply(int status,Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//参数MAP
		HashMap<String,Object> paraMap=new HashMap<String,Object>();
		paraMap.put("userId", Long.parseLong("1"));
		if(status!=3){
			paraMap.put("status", status);
		}
		//查询我的申请数据
		List<OutRequest> outRequestList=outRequestServiceImpl.findMyApplyByStuffId(paraMap);
		//查询我的申请各种状态数量
		HashMap<String,Integer> statusMap=outRequestServiceImpl.findMyApplyAllConut(Long.parseLong("1"));
		model.addAttribute("outRequestList", outRequestList);
		model.addAttribute("statusMap", statusMap);
		return "/out/myApply";

	}
	/**
	 * 跳转到我的审批页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordMyApprove", method = RequestMethod.GET)
	public String forwordMyApprove(int status,Model model, HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		//获取ID
		//参数MAP
		HashMap<String,Object> paraMap=new HashMap<String,Object>();
		paraMap.put("userId", Long.parseLong("1"));
		if(status!=3){
			paraMap.put("status", status);
		}else{
			paraMap.put("status1", status);
		}
		model.addAttribute("approveList", outRequestServiceImpl.selectApproveByID(paraMap));
		//查询我的申请各种状态数量
		HashMap<String,Integer> statusMap=outRequestServiceImpl.findMyApproveAllConut(Long.parseLong("1"));
		model.addAttribute("statusMap", statusMap);
		return "/out/myApprove";

	}
	
	/**
	 * 详情和审批页面
	 */
	/**
	 * 跳转到我的审批页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forwordApplyDetail", method = RequestMethod.GET)
	public String forwordApplyDetail(int type,long leaveRequestId,Model model, HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		//请假申请
		HashMap<String,Object> appylMap=outRequestServiceImpl.findApplyDetailByID(leaveRequestId);
		//获取审批人
		//经理信息
		List<Stuff> stuffList=stuffServiceImpl.selectAll();
		//获取申请信息
		if(type==1){
			model.addAttribute("type", 1);
		}else if(type==0){
			model.addAttribute("type", 0);
		}else{
			model.addAttribute("type", 2);
		}
		model.addAttribute("appylMap", appylMap);
		model.addAttribute("stuffList", stuffList);
		return "/out/detailApply";

	}
	/**
	 * 审批
	 */
	@RequestMapping(value = "/approveApply", method = RequestMethod.GET)
	public String approveApply(long apply_id,int approve_status,String approveId,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OutRequest outRequest=outRequestServiceImpl.selectByPrimaryKey(apply_id);
		
		if(approve_status==403){
			outRequest.setHandlerHistory(outRequest.getHandlerHistory()+";"+approveId);
			outRequest.setLastHandler(stuffServiceImpl.findByUsername(approveId).getId());
		}else{
			outRequest.setStatus(approve_status);
		}
		outRequestServiceImpl.updateByPrimaryKey(outRequest);
		return null;

	}

	

}