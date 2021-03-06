package com.lx.study.springshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lx
 * @Date: 2019/8/26 9:38
 */
//@RequestMapping("/testValue")
@RestController
public class TestValueController {

    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    public String name(){
        return this.name;
    }


//    @PostMapping("/doLogin")
//    public void doLogin(String username, String password) {
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(new UsernamePasswordToken(username, password));
//            System.out.println("登录成功!");
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            System.out.println("登录失败!");
//        }
//    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/login")
    public String  login() {
        return "please login!";
    }


}
