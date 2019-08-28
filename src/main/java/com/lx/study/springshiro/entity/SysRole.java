package com.lx.study.springshiro.entity;

import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
public class SysRole {
    /**
    * 角色名称
    */
    private String id;

    /**
    * 角色名称，用于显示
    */
    private String roleName;

    /**
    * 角色描述
    */
    private String roleDesc;

    /**
    * 角色值，用于权限判断
    */
    private String roleValue;

    private Date createTime;

    private Date updateTime;

    /**
    * 是否禁用
    */
    private Integer isDisable;

    @Transient
    private List<SysPerm> sysPermList;
    @Transient
    private List<UserInfo> userInfoList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public List<SysPerm> getSysPermList(){
       return sysPermList;
    }

    public void setSysPermList(List<SysPerm> sysPermList){
        this.sysPermList=sysPermList;
    }

    public List<UserInfo> getUserInfoList(){
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList){
        this.userInfoList=userInfoList;
    }
}