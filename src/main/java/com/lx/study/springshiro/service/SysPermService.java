package com.lx.study.springshiro.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lx.study.springshiro.entity.SysPerm;
import com.lx.study.springshiro.dao.SysPermMapper;

import java.util.Set;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
@Service
public class SysPermService{

    @Resource
    private SysPermMapper sysPermMapper;

    
    public int deleteByPrimaryKey(String id) {
        return sysPermMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SysPerm record) {
        return sysPermMapper.insert(record);
    }

    
    public int insertSelective(SysPerm record) {
        return sysPermMapper.insertSelective(record);
    }

    
    public SysPerm selectByPrimaryKey(String id) {
        return sysPermMapper.selectByPrimaryKey(id);
    }

    public Set<String> findPermValueByUserId(String userId) {
        return sysPermMapper.findPermValueByUserId(userId);
    }

    public Set<String> getAllPermValue(){
        return sysPermMapper.getALLPermValue();
    }

    
    public int updateByPrimaryKeySelective(SysPerm record) {
        return sysPermMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SysPerm record) {
        return sysPermMapper.updateByPrimaryKey(record);
    }

}
