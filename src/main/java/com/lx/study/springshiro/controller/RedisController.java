package com.lx.study.springshiro.controller;

import com.lx.study.springshiro.service.RedisService;
import com.lx.study.springshiro.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: lx
 * @Date: 2019/8/26 10:38
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisService redisService;

    @PostMapping("/setRedis")
    public Result setRedis(String name) {
        redisService.set("name",name);
        return Result.success(name);
    }

    @PostMapping("/getRedis")
    public Result getRedis() {
        String name = redisService.get("name");
        return Result.success(name);
    }


}
