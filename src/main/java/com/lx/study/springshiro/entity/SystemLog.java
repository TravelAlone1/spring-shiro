package com.lx.study.springshiro.entity;

import java.util.Date;
import lombok.Data;

/**
*@Author: lx
*@Date: 2019/8/28 10:40
*/  
@Data
public class SystemLog {
    private String id;

    /**
    * 日志信息描述
    */
    private String description;

    /**
    * 方法名称
    */
    private String method;

    /**
    * 日志类型 0是正常，1是异常
    */
    private String logType;

    /**
    * 请求的ip
    */
    private String requestIp;

    /**
    * 异常错误码
    */
    private String exceptionCode;

    /**
    * 异常详情
    */
    private String exceptionDetail;

    /**
    * 请求参数
    */
    private String params;

    /**
    * 请求的用户id
    */
    private String userId;

    private Date createTime;
}