package com.attendance.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.manage.dao.DepartmentMapper;
import com.attendance.manage.model.Department;
import com.attendance.manage.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentDao;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table department
	 * 
	 * @mbggenerated
	 */
	public int deleteByPrimaryKey(Long id) {
		return departmentDao.deleteByPrimaryKey(id);

	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table department
	 * 
	 * @mbggenerated
	 */
	public int insert(Department record) {
		return departmentDao.insert(record);

	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table department
	 * 
	 * @mbggenerated
	 */
	public Department selectByPrimaryKey(Long id) {
		return departmentDao.selectByPrimaryKey(id);

	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table department
	 * 
	 * @mbggenerated
	 */
	public List<Department> selectAll() {
		return departmentDao.selectAll();

	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table department
	 * 
	 * @mbggenerated
	 */
	public int updateByPrimaryKey(Department record) {
		return departmentDao.updateByPrimaryKey(record);

	}
}