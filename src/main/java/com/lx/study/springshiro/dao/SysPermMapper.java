package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.SysPerm;

import java.util.Set;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
public interface SysPermMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysPerm record);

    int insertSelective(SysPerm record);

    SysPerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPerm record);

    int updateByPrimaryKey(SysPerm record);

    Set<String> findPermValueByUserId(String userId);

    Set<String> getALLPermValue();
}