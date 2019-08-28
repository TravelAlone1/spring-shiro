package com.lx.study.springshiro.dao;

import com.lx.study.springshiro.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/8/26 11:18
 */
@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> selectByAll(UserInfo userInfo);

    UserInfo selectByName(String username);

    List<UserInfo> selectAll();


}