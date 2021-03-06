package com.attendance.manage.service;

import com.attendance.manage.model.CheckInfo;

import java.util.Date;
import java.util.List;

public interface CheckInfoService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_info
     *
     * @mbggenerated
     */
    int insert(CheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_info
     *
     * @mbggenerated
     */
    CheckInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_info
     *
     * @mbggenerated
     */
    List<CheckInfo> selectAll();
    
    List<CheckInfo> selectAllAndSort();
    
    List<CheckInfo> selectAllStartAndEndTimes();
    
    List<CheckInfo> selectStartAndEndTimesByDate(int year,int month,int date);
    List<CheckInfo> selectStartAndEndTimesByDate(int year,int month);
    List<CheckInfo> selectStartAndEndTimesByDate(int year);
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CheckInfo record);
}