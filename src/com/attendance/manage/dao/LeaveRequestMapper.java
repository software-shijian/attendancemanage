package com.attendance.manage.dao;

import com.attendance.manage.model.LeaveRequest;

import java.util.HashMap;
import java.util.List;

public interface LeaveRequestMapper {
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
    
    List<LeaveRequest> selectApproveByID(HashMap<String,Object> paraMap);
    
    List<LeaveRequest> findMyApplyByStuffId(HashMap<String,Object> paraMap);
    List<LeaveRequest> selectApproveByID(Long id);
    //查询我的申请各种状态数量
    HashMap<String,Integer> findMyApplyAllConut(Long id);
    //查询我的审批各种状态的数量
    HashMap<String,Integer> findMyApproveAllConut(Long id);
    
    HashMap<String,Object> findApplyDetailByID(Long id);
}