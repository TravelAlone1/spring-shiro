package com.lx.study.springshiro.entity;

import lombok.Data;

/**
*@Author: lx
*@Date: 2019/8/26 11:20
*/  
@Data
public class RolePerm {
    private String id;

    /**
    * 权限id
    */
    private String permId;

    /**
    * 角色id
    */
    private String roleId;
}