package com.lx.study.springshiro.service;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lx.study.springshiro.dao.UserRoleMapper;
import com.lx.study.springshiro.entity.UserRole;

import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
@Service
public class UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    
    public int deleteByPrimaryKey(String id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    
    public UserRole selectByPrimaryKey(String id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }


    public List<String> getRolesByUserId(String userId){
        return userRoleMapper.getRolesByUserId(userId);
    }

    
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

}
