package com.attendance.manage.controller;

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

import com.attendance.manage.model.LeaveRequest;
import com.attendance.manage.model.Stuff;
import com.attendance.manage.service.CheckInfoService;
import com.attendance.manage.service.LeaveRequestService;
import com.attendance.manage.service.StuffService;

@Scope("prototype")
@Controller
@RequestMapping("/nomal/leavareq")
public class LeaveRequestController {
	@Autowired
	private CheckInfoService checkInfoServiceImpl;
	@Autowired
	private LeaveRequestService leaveRequestServiceImpl;
	@Autowired
	private StuffService stuffServiceImpl;

	/**
	 * 测试方法,HelloWord
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getProducts(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		model.addAttribute("name", checkInfoServiceImpl.selectAll().get(0)
				.getCheckTime());

		return "product/list";

	}
	
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
		//经理信息
		List<Stuff> stuffList=stuffServiceImpl.selectAll();
		model.addAttribute("stuff", stuff);
		model.addAttribute("stuffList", stuffList);
		return "/apply/newApply";

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
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LeaveRequest leaveRequest=new LeaveRequest();
		leaveRequest.setDescription(description);
		leaveRequest.setLastHandler(stuffServiceImpl.findByUsername(approveId).getId());
		leaveRequest.setApplicationTime(new Date());
		leaveRequest.setCreateDate(new Date());
		leaveRequest.setBeginTime(new Date());
		leaveRequest.setEndTime(new Date());
		leaveRequest.setStatus(0);
		leaveRequest.setModifyDate(new Date());
		leaveRequest.setStuffId(stuffServiceImpl.findByUsername(username).getId());
		leaveRequest.setTypeId(Long.parseLong("1"));
		leaveRequestServiceImpl.newApply(leaveRequest);
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
		List<LeaveRequest> leaveRequestList=leaveRequestServiceImpl.findMyApplyByStuffId(paraMap);
		//查询我的申请各种状态数量
		HashMap<String,Integer> statusMap=leaveRequestServiceImpl.findMyApplyAllConut(Long.parseLong("1"));
		model.addAttribute("leaveRequestList", leaveRequestList);
		model.addAttribute("statusMap", statusMap);
		return "/apply/myApply";

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
		model.addAttribute("approveList", leaveRequestServiceImpl.selectApproveByID(paraMap));
		//查询我的申请各种状态数量
		HashMap<String,Integer> statusMap=leaveRequestServiceImpl.findMyApproveAllConut(Long.parseLong("1"));
		model.addAttribute("statusMap", statusMap);
		return "/apply/myApprove";

	}
	

	

}