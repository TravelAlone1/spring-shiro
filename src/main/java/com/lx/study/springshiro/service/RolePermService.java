package com.lx.study.springshiro.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lx.study.springshiro.entity.RolePerm;
import com.lx.study.springshiro.dao.RolePermMapper;

import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:20
*/  
@Service
public class RolePermService{

    @Resource
    private RolePermMapper rolePermMapper;

    
    public int deleteByPrimaryKey(String id) {
        return rolePermMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(RolePerm record) {
        return rolePermMapper.insert(record);
    }

    
    public int insertSelective(RolePerm record) {
        return rolePermMapper.insertSelective(record);
    }

    
    public RolePerm selectByPrimaryKey(String id) {
        return rolePermMapper.selectByPrimaryKey(id);
    }

    public List<String> getPermsByUserId(String userId){
        return rolePermMapper.getPermsByUserId(userId);
    }
    
    public int updateByPrimaryKeySelective(RolePerm record) {
        return rolePermMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(RolePerm record) {
        return rolePermMapper.updateByPrimaryKey(record);
    }

}
