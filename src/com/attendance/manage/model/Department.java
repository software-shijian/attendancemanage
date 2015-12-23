package com.attendance.manage.model;

import java.util.Date;

public class Department {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column department.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column department.create_date
	 * @mbggenerated
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column department.modify_date
	 * @mbggenerated
	 */
	private Date modifyDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column department.department_name
	 * @mbggenerated
	 */
	private String departmentName;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column department.id
	 * @return  the value of department.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column department.id
	 * @param id  the value for department.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column department.create_date
	 * @return  the value of department.create_date
	 * @mbggenerated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column department.create_date
	 * @param createDate  the value for department.create_date
	 * @mbggenerated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column department.modify_date
	 * @return  the value of department.modify_date
	 * @mbggenerated
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column department.modify_date
	 * @param modifyDate  the value for department.modify_date
	 * @mbggenerated
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column department.department_name
	 * @return  the value of department.department_name
	 * @mbggenerated
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column department.department_name
	 * @param departmentName  the value for department.department_name
	 * @mbggenerated
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName == null ? null : departmentName
				.trim();
	}
}