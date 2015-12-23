package com.attendance.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.manage.dao.VacationInfoMapper;
import com.attendance.manage.model.VacationInfo;
import com.attendance.manage.service.VacationInfoService;

@Service
public class VacationInfoServiceImpl implements VacationInfoService {

	@Autowired
	private VacationInfoMapper vacationInfoDao;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table vacation_info
	 * 
	 * @mbggenerated
	 */
	public int deleteByPrimaryKey(Long id) {
		return vacationInfoDao.deleteByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table vacation_info
	 * 
	 * @mbggenerated
	 */
	public int insert(VacationInfo record) {
		return vacationInfoDao.insert(record);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table vacation_info
	 * 
	 * @mbggenerated
	 */
	public VacationInfo selectByPrimaryKey(Long id) {
		return vacationInfoDao.selectByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table vacation_info
	 * 
	 * @mbggenerated
	 */
	public List<VacationInfo> selectAll() {
		return vacationInfoDao.selectAll();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table vacation_info
	 * 
	 * @mbggenerated
	 */
	public int updateByPrimaryKey(VacationInfo record) {
		return vacationInfoDao.updateByPrimaryKey(record);
	}
}