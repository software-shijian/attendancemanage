package com.attendance.manage.model;

public class SystemConfig {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column system_config.s_key
	 * @mbggenerated
	 */
	private String sKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column system_config.s_value
	 * @mbggenerated
	 */
	private String sValue;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column system_config.s_key
	 * @return  the value of system_config.s_key
	 * @mbggenerated
	 */
	public String getsKey() {
		return sKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column system_config.s_key
	 * @param sKey  the value for system_config.s_key
	 * @mbggenerated
	 */
	public void setsKey(String sKey) {
		this.sKey = sKey == null ? null : sKey.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column system_config.s_value
	 * @return  the value of system_config.s_value
	 * @mbggenerated
	 */
	public String getsValue() {
		return sValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column system_config.s_value
	 * @param sValue  the value for system_config.s_value
	 * @mbggenerated
	 */
	public void setsValue(String sValue) {
		this.sValue = sValue == null ? null : sValue.trim();
	}
}