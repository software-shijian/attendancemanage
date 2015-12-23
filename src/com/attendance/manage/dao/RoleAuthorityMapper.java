package com.attendance.manage.dao;

import java.util.List;

import com.attendance.manage.model.RoleAuthority;

public interface RoleAuthorityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table role_authority
	 * 
	 * @mbggenerated
	 */
	int insert(RoleAuthority record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table role_authority
	 * 
	 * @mbggenerated
	 */
	List<RoleAuthority> selectAll();

	List<String> findByRole(Long role);
}