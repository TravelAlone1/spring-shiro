package com.lx.study.springshiro.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.lx.study.springshiro.entity.UserInfo;
import com.lx.study.springshiro.exception.ServiceException;
import com.lx.study.springshiro.service.UserInfoService;
import com.lx.study.springshiro.util.MD5Utils;
import com.lx.study.springshiro.util.Result;
import com.lx.study.springshiro.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/8/25 20:58
 */
@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, value = "用户相关业务的接口")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectById")
    public Result selectById(@RequestParam Integer id){
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        return Result.success(userInfo);
    }

    @PostMapping("/testException")
    public Result testException(Integer id){
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        return Result.success(userInfo);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size) {
        PageInfo<UserInfo> pageInfo = userInfoService.selectAll(page, size);
        //return RetResponse.makeOKRsp(pageInfo);
        return Result.success(ResultCode.SUCCESS,pageInfo);

    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        // 密码MD5加密
        //password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //登录
        try {
            subject.login(token);
            return Result.success(ResultCode.SUCCESS);
        }catch (UnknownAccountException e) {
            return Result.failure(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.failure(e.getMessage());
        } catch (LockedAccountException e) {
            return Result.failure(e.getMessage());
        } catch (AuthenticationException e) {
            return Result.failure("认证失败");
        }
    }

    @PostMapping("/userDel")
    @RequiresPermissions("admin:delete")//删除的权限
    public Result del(Integer id){
        int i=0;
        if (id !=null){
            i = userInfoService.deleteByPrimaryKey(id);
        }
        //0为操作失败，1 为操作成功
        System.out.println(i);
        return Result.success(ResultCode.SUCCESS,i);
    }

    @PostMapping("/add")
    @RequiresPermissions("admin:add")//删除的权限
    public Result add(String id , String username, String password, String salt, Integer state, Integer isSystrm){
        UserInfo userInfo = new UserInfo();
        if (!Strings.isNullOrEmpty(id)){
            userInfo.setId(id);
        }
        if (!Strings.isNullOrEmpty(username)){
            userInfo.setUserName(username);
        }
        if (!Strings.isNullOrEmpty(password)){
            userInfo.setPassword(password);
        }
        if (!Strings.isNullOrEmpty(salt)){
            userInfo.setSalt(salt);
        }
        if (state !=null){
            userInfo.setState(state);
        }
        if (isSystrm!=null){
            userInfo.setIsSystem(isSystrm);
        }
        int i = userInfoService.insertSelective(userInfo);
        return Result.success(ResultCode.SUCCESS,i);


    }

    @PostMapping("/upload")
    @RequiresPermissions("admin:upload")//
    public Result upload(String id , String username, String password, String salt, Integer state, Integer isSystrm){
        UserInfo userInfo = new UserInfo();
        if (!Strings.isNullOrEmpty(id)){
            userInfo.setId(id);
        }
        if (!Strings.isNullOrEmpty(username)){
            userInfo.setUserName(username);
        }
        if (!Strings.isNullOrEmpty(password)){
            userInfo.setPassword(password);
        }
        if (!Strings.isNullOrEmpty(salt)){
            userInfo.setSalt(salt);
        }
        if (state !=null){
            userInfo.setState(state);
        }
        if (isSystrm!=null){
            userInfo.setIsSystem(isSystrm);
        }

        int i = userInfoService.updateByPrimaryKeySelective(userInfo);
        return Result.success(ResultCode.SUCCESS,i);
    }
}
