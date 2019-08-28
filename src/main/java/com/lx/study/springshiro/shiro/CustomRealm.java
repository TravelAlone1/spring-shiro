package com.lx.study.springshiro.shiro;

import com.lx.study.springshiro.entity.SysPerm;
import com.lx.study.springshiro.entity.SysRole;
import com.lx.study.springshiro.entity.UserInfo;
import com.lx.study.springshiro.service.RolePermService;
import com.lx.study.springshiro.service.SysPermService;
import com.lx.study.springshiro.service.UserInfoService;
import com.lx.study.springshiro.service.UserRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Set;


/**
 * @Author: lx
 * @Date: 2019/8/26 11:24
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userService;

    @Autowired
    private SysPermService sysPermService;

    /**
     * 告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
     */
    {
        //设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        hashMatcher.setHashAlgorithmName("md5");
        hashMatcher.setStoredCredentialsHexEncoded(true);
        //加密的次数
        hashMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashMatcher);
    }


    /**
     *  定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置");

        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        Set<String> perms;
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (userInfo.getIsSystem()==1){
            perms=sysPermService.getAllPermValue();
            System.out.println("获取用户所有权限");
        }else {
            perms=sysPermService.findPermValueByUserId(userInfo.getId());
            System.out.println("获取某个用户的权限");
        }
        simpleAuthorizationInfo.setStringPermissions(perms);
//        //获取当前用户的角色与权限，让simpleAuthorizationInfo去验证
//        for (SysRole sysRole : userInfo.getRoleList()) {
//            simpleAuthorizationInfo.addRole(sysRole.getRoleName());
//            for (SysPerm sysPermission : sysRole.getSysPermList()) {
//                simpleAuthorizationInfo.addStringPermission(sysPermission.getPermName());
//            }
//        }
        return simpleAuthorizationInfo;
    }


    /**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("用户登录");
        String username = (String) token.getPrincipal();
        //String password = new String((char[]) token.getCredentials());
        UserInfo user = userService.selectByName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        System.out.println(user.getState());
        String lock="0";
        if (lock.equals(user.getState().toString())){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),user.getUserName());
        System.out.println("输入的密码"+user.getPassword());
        System.out.println("数据库中项目"+ByteSource.Util.bytes(user.getCredentialsSalt()));
        return info;

    }


}
