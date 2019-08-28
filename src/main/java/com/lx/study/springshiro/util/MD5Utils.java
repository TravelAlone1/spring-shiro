package com.lx.study.springshiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: lx
 * @Date: 2019/8/26 13:52
 */
public class MD5Utils {

    private static final String SALT = "8d78869f470951332959580424d4bf4f";

    private static final String ALGORITH_NAME = "MD5"; ////散列算法:这里使用MD5算法

    private static final int HASH_ITERATIONS = 2;//散列的次数，相当于MD5(MD5(**))

    public static String encrypt(String pswd) { ////明文密码
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS)//salt：用户名 + salt
                .toHex();
        return newPassword;
    }

    public static String encrypt(String username, String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }
    public static void main(String[] args) {

        System.out.println(MD5Utils.encrypt("admin", "123456"));
    }

}
