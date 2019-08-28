package com.lx.study.springshiro.controller;

import com.lx.study.springshiro.util.Result;
import com.lx.study.springshiro.util.ResultCode;
import com.lx.study.springshiro.util.UploadActionUtil;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/8/28 18:37
 */
public class UploadFileController {

    @PostMapping("/upload")
    public Result upload(HttpServletRequest httpServletRequest) throws Exception {
        List<String> list = UploadActionUtil.uploadFile(httpServletRequest);
        return Result.success(ResultCode.SUCCESS,list);
    }

}
