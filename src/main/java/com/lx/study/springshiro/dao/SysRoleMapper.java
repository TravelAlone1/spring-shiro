package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.SysRole;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}