package com.attendance.manage.service;

import com.attendance.manage.model.RoleAuthority;
import java.util.List;

public interface RoleAuthorityService {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_authority
	 * @mbggenerated
	 */
	int insert(RoleAuthority record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table role_authority
	 * @mbggenerated
	 */
	List<RoleAuthority> selectAll();
}