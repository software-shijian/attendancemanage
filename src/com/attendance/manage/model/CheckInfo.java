package com.attendance.manage.model;

import java.util.Date;

public class CheckInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_info.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_info.check_time
     *
     * @mbggenerated
     */
    private Date checkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column check_info.stuff_id
     *
     * @mbggenerated
     */
    private Long stuffId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_info.id
     *
     * @return the value of check_info.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_info.id
     *
     * @param id the value for check_info.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_info.check_time
     *
     * @return the value of check_info.check_time
     *
     * @mbggenerated
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_info.check_time
     *
     * @param checkTime the value for check_info.check_time
     *
     * @mbggenerated
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column check_info.stuff_id
     *
     * @return the value of check_info.stuff_id
     *
     * @mbggenerated
     */
    public Long getStuffId() {
        return stuffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column check_info.stuff_id
     *
     * @param stuffId the value for check_info.stuff_id
     *
     * @mbggenerated
     */
    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }
}