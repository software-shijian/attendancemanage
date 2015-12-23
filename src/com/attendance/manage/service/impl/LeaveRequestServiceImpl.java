package com.attendance.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.manage.dao.LeaveRequestMapper;
import com.attendance.manage.model.LeaveRequest;
import com.attendance.manage.service.LeaveRequestService;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	@Autowired
	private LeaveRequestMapper leaveRequestDao;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table leave_request
	 * 
	 * @mbggenerated
	 */
	public int deleteByPrimaryKey(Long id) {
		return leaveRequestDao.deleteByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table leave_request
	 * 
	 * @mbggenerated
	 */
	public int insert(LeaveRequest record) {
		return leaveRequestDao.insert(record);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table leave_request
	 * 
	 * @mbggenerated
	 */
	public LeaveRequest selectByPrimaryKey(Long id) {
		return leaveRequestDao.selectByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table leave_request
	 * 
	 * @mbggenerated
	 */
	public List<LeaveRequest> selectAll() {
		return leaveRequestDao.selectAll();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table leave_request
	 * 
	 * @mbggenerated
	 */
	public int updateByPrimaryKey(LeaveRequest record) {
		return leaveRequestDao.updateByPrimaryKey(record);
	}
}