package com.attendance.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.manage.dao.OutTypeMapper;
import com.attendance.manage.model.OutType;
import com.attendance.manage.service.OutTypeService;

@Service
public class OutTypeServiceImpl implements OutTypeService {
	@Autowired
	private OutTypeMapper outTypeDao;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table out_type
	 * 
	 * @mbggenerated
	 */
	public int deleteByPrimaryKey(Long id) {
		return outTypeDao.deleteByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table out_type
	 * 
	 * @mbggenerated
	 */
	public int insert(OutType record) {
		return outTypeDao.insert(record);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table out_type
	 * 
	 * @mbggenerated
	 */
	public OutType selectByPrimaryKey(Long id) {
		return outTypeDao.selectByPrimaryKey(id);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table out_type
	 * 
	 * @mbggenerated
	 */
	public List<OutType> selectAll() {
		return outTypeDao.selectAll();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table out_type
	 * 
	 * @mbggenerated
	 */
	public int updateByPrimaryKey(OutType record) {
		return outTypeDao.updateByPrimaryKey(record);
	}
}