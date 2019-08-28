package com.lx.study.springshiro.util;

import lombok.Data;

/**
 * @Author: lx
 * @Date: 2019/8/25 21:19
 */
@Data
public class Result {

    private Integer code;

    private String msg;

    private Object data;

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    //成功 不返回数据直接返回成功信息
    public static Result success(){
        Result result=new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    //成功 并且加上返回数据
    public static Result success(Object data){
        Result result =new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    //成功 自定义成功返回状态 加上数据
    public static Result success(ResultCode resultCode,Object data){
        Result result=new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode){
        Result result=new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode,Object data){
        Result result=new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }
    public static Result failure(ResultCode resultCode,String msg, Object data){
        Result result=new Result();
        result.setResultCode(resultCode);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result failure(Object data){
        Result result = new Result();
        result.setData(data);
        return result;
    }

}
