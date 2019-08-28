package com.lx.study.springshiro.controller;

import com.lx.study.springshiro.entity.UserInfo;
import com.lx.study.springshiro.util.MD5Utils;
import com.lx.study.springshiro.util.Result;
import com.lx.study.springshiro.util.ResultCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lx
 * @Date: 2019/8/26 14:09
 */
@Controller
public class LoginController {

//    @PostMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/login")
//    public Result login(String username, String password) {
//        // 密码MD5加密
//        //password = MD5Utils.encrypt(username, password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        // 获取Subject对象
//        Subject subject = SecurityUtils.getSubject();
//        //登录
//        try {
//            subject.login(token);
//            return Result.success(ResultCode.SUCCESS);
//        }catch (UnknownAccountException e) {
//            return Result.failure(e.getMessage());
//        } catch (IncorrectCredentialsException e) {
//            return Result.failure(e.getMessage());
//        } catch (LockedAccountException e) {
//            return Result.failure(e.getMessage());
//        } catch (AuthenticationException e) {
//            return Result.failure("认证失败");
//        }
//    }
//
//
//
//    //@RequestMapping("/")
//    public String redirectIndex() {
//        return "redirect:/index";
//    }
//
//    /**
//     * 用户查询;
//     * @return
//     */
//    @RequestMapping("/userList")
//    @RequiresPermissions("userInfo:view")//访问的权限
//    public String userList(){
//        return "userInfo";
//    }
//
//    /**
//     * 用户添加;
//     * @return
//     */
//    @RequestMapping("/userAdd")
//    @RequiresPermissions("userInfo:add")//新增的权限
//    public String userAdd(){
//        return "userInfoAdd";
//    }
//
//    /**
//     * 用户删除;
//     * @return
//     */
//    @RequestMapping("/userDel")
//    @RequiresPermissions("userInfo:del")//删除的权限
//    public String userDel(){
//        return "userInfoDel";
//    }





}
