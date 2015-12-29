package com.attendance.manage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import com.attendance.manage.model.LeaveType;
import com.attendance.manage.model.Stuff;
import com.attendance.manage.service.CheckInfoService;
import com.attendance.manage.service.LeaveRequestService;
import com.attendance.manage.service.LeaveTypeService;
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
	@Autowired
	private LeaveTypeService leaveTypeServiceImpl;

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
	public String forwordApply(HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName = (String) session.getAttribute("username");
		// 员工信息
		Stuff stuff = stuffServiceImpl.findUserInfo(userName);
		// 请假类型信息
		List<LeaveType> leaveTypeList = leaveTypeServiceImpl.selectAll();
		// 经理信息
		List<Stuff> stuffList1 = stuffServiceImpl.selectAll();
		List<Stuff> stuffList = new ArrayList<Stuff>();
		for (int i = 0; i < stuffList1.size(); i++) {
			if (!stuffList1.get(i).getUsername().equals(userName)) {
				stuffList.add(stuffList1.get(i));
			}
		}
		model.addAttribute("stuff", stuff);
		model.addAttribute("stuffList", stuffList);
		model.addAttribute("leaveTypeList", leaveTypeList);
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
	@RequestMapping(value = "/newApply", method = RequestMethod.POST)
	public String newApply(String description, String approveId,
			String username, String datetimepicker1, String datetimepicker2,
			String leaveTypeId, HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setDescription(description);
		leaveRequest.setLastHandler(stuffServiceImpl.findByUsername(approveId)
				.getId());
		leaveRequest.setHandlerHistory(approveId);
		leaveRequest.setApplicationTime(new Date());
		leaveRequest.setCreateDate(new Date());

		leaveRequest.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse((datetimepicker1.replace("/", "-") + ":00")));
		leaveRequest.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse(datetimepicker1.replace("/", "-") + ":00"));
		leaveRequest.setStatus(0);
		leaveRequest.setModifyDate(new Date());
		leaveRequest.setStuffId(stuffServiceImpl.findByUsername(username)
				.getId());
		leaveRequest.setTypeId(Long.parseLong(leaveTypeId));
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
	public String forwordMyApply(int status, HttpSession session, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 参数MAP
		HashMap<String, Object> paraMap = new HashMap<String, Object>();
		String userName = (String) session.getAttribute("username");
		// 员工信息
		Stuff stuff = stuffServiceImpl.findUserInfo(userName);
		paraMap.put("userId", stuff.getId());
		if (status != 3) {
			paraMap.put("status", status);
		}
		// 查询我的申请数据
		List<LeaveRequest> leaveRequestList = leaveRequestServiceImpl
				.findMyApplyByStuffId(paraMap);
		// 查询我的申请各种状态数量
		HashMap<String, Integer> statusMap = leaveRequestServiceImpl
				.findMyApplyAllConut(stuff.getId());
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
	public String forwordMyApprove(int status, HttpSession session,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 获取ID
		// 参数MAP
		HashMap<String, Object> paraMap = new HashMap<String, Object>();
		String userName = (String) session.getAttribute("username");
		// 员工信息
		Stuff stuff = stuffServiceImpl.findUserInfo(userName);
		paraMap.put("userId", stuff.getId());
		if (status != 3) {
			paraMap.put("status", status);
		} else {
			paraMap.put("status1", status);
		}
		model.addAttribute("approveList",
				leaveRequestServiceImpl.selectApproveByID(paraMap));
		// 查询我的申请各种状态数量
		HashMap<String, Integer> statusMap = leaveRequestServiceImpl
				.findMyApproveAllConut(stuff.getId());
		model.addAttribute("statusMap", statusMap);
		return "/apply/myApprove";

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
	public String forwordApplyDetail(int type, long leaveRequestId,
			Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		// 请假申请
		HashMap<String, Object> appylMap = leaveRequestServiceImpl
				.findApplyDetailByID(leaveRequestId);
		// 获取审批人
		// 经理信息
		List<Stuff> stuffList1 = stuffServiceImpl.selectAll();
		List<Stuff> stuffList = new ArrayList<Stuff>();
		for (int i = 0; i < stuffList1.size(); i++) {
			if (!stuffList1.get(i).getUsername()
					.equals(session.getAttribute("username"))
					&& stuffList1.get(i).getId() != (Long) appylMap
							.get("stuff_id")) {
				stuffList.add(stuffList1.get(i));
			}
		}
		// 获取申请信息
		if (type == 1) {
			model.addAttribute("type", 1);
		} else if (type == 0) {
			model.addAttribute("type", 0);
		} else {
			model.addAttribute("type", 2);
		}
		model.addAttribute("appylMap", appylMap);
		model.addAttribute("stuffList", stuffList);
		return "/apply/detailApply";

	}

	/**
	 * 审批
	 */
	@RequestMapping(value = "/approveApply", method = RequestMethod.GET)
	public String approveApply(long apply_id, int approve_status,
			String approveId, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LeaveRequest leaveRequest = leaveRequestServiceImpl
				.selectByPrimaryKey(apply_id);

		if (approve_status == 403) {
			leaveRequest.setHandlerHistory(leaveRequest.getHandlerHistory()
					+ ";" + approveId);
			leaveRequest.setLastHandler(stuffServiceImpl.findByUsername(
					approveId).getId());
		} else {
			leaveRequest.setStatus(approve_status);
		}
		leaveRequestServiceImpl.updateByPrimaryKey(leaveRequest);
		return null;

	}

}