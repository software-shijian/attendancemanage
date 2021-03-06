package com.attendance.manage.model;

import java.util.Date;

public class StuffRole {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuff_role.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuff_role.stuff_id
	 * @mbggenerated
	 */
	private Long stuffId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuff_role.create_date
	 * @mbggenerated
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuff_role.modify_date
	 * @mbggenerated
	 */
	private Date modifyDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column stuff_role.role
	 * @mbggenerated
	 */
	private Long role;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuff_role.id
	 * @return  the value of stuff_role.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuff_role.id
	 * @param id  the value for stuff_role.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuff_role.stuff_id
	 * @return  the value of stuff_role.stuff_id
	 * @mbggenerated
	 */
	public Long getStuffId() {
		return stuffId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuff_role.stuff_id
	 * @param stuffId  the value for stuff_role.stuff_id
	 * @mbggenerated
	 */
	public void setStuffId(Long stuffId) {
		this.stuffId = stuffId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuff_role.create_date
	 * @return  the value of stuff_role.create_date
	 * @mbggenerated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuff_role.create_date
	 * @param createDate  the value for stuff_role.create_date
	 * @mbggenerated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuff_role.modify_date
	 * @return  the value of stuff_role.modify_date
	 * @mbggenerated
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuff_role.modify_date
	 * @param modifyDate  the value for stuff_role.modify_date
	 * @mbggenerated
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column stuff_role.role
	 * @return  the value of stuff_role.role
	 * @mbggenerated
	 */
	public Long getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column stuff_role.role
	 * @param role  the value for stuff_role.role
	 * @mbggenerated
	 */
	public void setRole(Long role) {
		this.role = role;
	}
}