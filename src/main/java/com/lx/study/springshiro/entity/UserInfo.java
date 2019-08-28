package com.lx.study.springshiro.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Author: lx
 * @Date: 2019/8/26 11:18
 */
@Getter
@Setter
public class UserInfo implements Serializable {
    private String id;

    private String userName;

    private String password;

    private String salt;

    private Integer state;

    private Integer isSystem;

    @Transient
    private List<SysRole> roleList;

    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    @Transient
    private List<String> perms;




    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }

}