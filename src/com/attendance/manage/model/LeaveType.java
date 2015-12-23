package com.attendance.manage.model;

import java.util.Date;

public class LeaveType {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.create_date
	 * @mbggenerated
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.modify_date
	 * @mbggenerated
	 */
	private Date modifyDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.description
	 * @mbggenerated
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.valid_days
	 * @mbggenerated
	 */
	private Integer validDays;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.full_days
	 * @mbggenerated
	 */
	private Integer fullDays;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column leave_type.discount
	 * @mbggenerated
	 */
	private Integer discount;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.id
	 * @return  the value of leave_type.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.id
	 * @param id  the value for leave_type.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.create_date
	 * @return  the value of leave_type.create_date
	 * @mbggenerated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.create_date
	 * @param createDate  the value for leave_type.create_date
	 * @mbggenerated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.modify_date
	 * @return  the value of leave_type.modify_date
	 * @mbggenerated
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.modify_date
	 * @param modifyDate  the value for leave_type.modify_date
	 * @mbggenerated
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.name
	 * @return  the value of leave_type.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.name
	 * @param name  the value for leave_type.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.description
	 * @return  the value of leave_type.description
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.description
	 * @param description  the value for leave_type.description
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.valid_days
	 * @return  the value of leave_type.valid_days
	 * @mbggenerated
	 */
	public Integer getValidDays() {
		return validDays;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.valid_days
	 * @param validDays  the value for leave_type.valid_days
	 * @mbggenerated
	 */
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.full_days
	 * @return  the value of leave_type.full_days
	 * @mbggenerated
	 */
	public Integer getFullDays() {
		return fullDays;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.full_days
	 * @param fullDays  the value for leave_type.full_days
	 * @mbggenerated
	 */
	public void setFullDays(Integer fullDays) {
		this.fullDays = fullDays;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column leave_type.discount
	 * @return  the value of leave_type.discount
	 * @mbggenerated
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column leave_type.discount
	 * @param discount  the value for leave_type.discount
	 * @mbggenerated
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}