package com.lx.study.springshiro.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lx.study.springshiro.entity.SystemLog;
import com.lx.study.springshiro.dao.SystemLogMapper;
/**
*@Author: lx
*@Date: 2019/8/28 10:40
*/  
@Service
public class SystemLogService{

    @Resource
    private SystemLogMapper systemLogMapper;

    
    public int deleteByPrimaryKey(String id) {
        return systemLogMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SystemLog record) {
        return systemLogMapper.insert(record);
    }

    
    public int insertSelective(SystemLog record) {
        return systemLogMapper.insertSelective(record);
    }

    
    public SystemLog selectByPrimaryKey(String id) {
        return systemLogMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SystemLog record) {
        return systemLogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SystemLog record) {
        return systemLogMapper.updateByPrimaryKey(record);
    }

}
