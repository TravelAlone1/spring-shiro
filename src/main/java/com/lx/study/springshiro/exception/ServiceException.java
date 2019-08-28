package com.lx.study.springshiro.exception;

import java.io.Serializable;

/**
 * @Author: lx
 * @Date: 2019/8/25 21:53
 */
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1213855733833039552L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
