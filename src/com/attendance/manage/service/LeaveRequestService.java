package com.attendance.manage.service;

import com.attendance.manage.model.LeaveRequest;
import java.util.List;

public interface LeaveRequestService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave_request
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave_request
     *
     * @mbggenerated
     */
    int insert(LeaveRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave_request
     *
     * @mbggenerated
     */
    LeaveRequest selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave_request
     *
     * @mbggenerated
     */
    List<LeaveRequest> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave_request
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LeaveRequest record);
}