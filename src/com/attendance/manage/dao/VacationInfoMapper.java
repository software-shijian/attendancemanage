package com.attendance.manage.dao;

import com.attendance.manage.model.VacationInfo;
import java.util.List;

public interface VacationInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vacation_info
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vacation_info
	 * @mbggenerated
	 */
	int insert(VacationInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vacation_info
	 * @mbggenerated
	 */
	VacationInfo selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vacation_info
	 * @mbggenerated
	 */
	List<VacationInfo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table vacation_info
	 * @mbggenerated
	 */
	int updateByPrimaryKey(VacationInfo record);
}