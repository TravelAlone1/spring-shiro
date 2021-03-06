package com.lx.study.springshiro.entity;

import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

/**
*@Author: lx
*@Date: 2019/8/26 11:19
*/  
public class SysPerm {
    private String id;

    /**
    * 权限名称
    */
    private String permName;

    /**
    * 权限描述
    */
    private String permDesc;

    /**
    * 权限值
    */
    private String permValue;

    private Date createTime;

    private Date updateTime;

    /**
    * 是否禁用
    */
    private Integer isDisable;

    @Transient
    private List<SysRole> roleList;

    @Transient
    private List<UserInfo> userInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    public String getPermValue() {
        return permValue;
    }

    public void setPermValue(String permValue) {
        this.permValue = permValue;
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
}