package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.RolePerm;

import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:20
*/  
public interface RolePermMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePerm record);

    int insertSelective(RolePerm record);

    RolePerm selectByPrimaryKey(String id);

    List<String> getPermsByUserId(String userId);

    int updateByPrimaryKeySelective(RolePerm record);

    int updateByPrimaryKey(RolePerm record);
}