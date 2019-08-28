package com.lx.study.springshiro.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lx
 * @Date: 2019/8/27 17:52
 */
@Controller
public class ResourceInterceptor extends HandlerInterceptorAdapter {


    private static final String USER_AGENT = "user-agent";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(logger.isDebugEnabled()){
            String uri = request.getRequestURI();
            logger.info(uri);
            logger.info("UserAgent: {}", request.getHeader(USER_AGENT));
            //logger.info("用户访问地址: {}, 来路地址: {}", uri, IpUtil.getIpAddr(request));
        }
        return true;
    }
}
