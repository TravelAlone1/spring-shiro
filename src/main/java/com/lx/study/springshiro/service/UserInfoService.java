package com.lx.study.springshiro.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.study.springshiro.exception.ServiceException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lx.study.springshiro.entity.UserInfo;
import com.lx.study.springshiro.dao.UserInfoMapper;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/8/25 20:57
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;


    public int deleteByPrimaryKey(Integer id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }


    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }


    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }


    public UserInfo selectByPrimaryKey(Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if (userInfo == null) {
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }


    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    public UserInfo selectByName(String username){
       return userInfoMapper.selectByName(username);
    }

    public PageInfo<UserInfo> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }



}

