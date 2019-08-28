package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.UserRole;

import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    List<String> getRolesByUserId(String userId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}