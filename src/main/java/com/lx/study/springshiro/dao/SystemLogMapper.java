package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.SystemLog;

/**
*@Author: lx
*@Date: 2019/8/28 10:40
*/  
public interface SystemLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
}