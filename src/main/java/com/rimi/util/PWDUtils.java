package com.rimi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 密码加密
 *
 * @author wjy
 * @date 2019/9/18 0018 10:19
 */
public class PWDUtils {

    /**
     * 盐
     */
    private static final String SALT = "da89ih2jr19iPI(Y)89p=qo2oela/?dqmqeknbq";

    public static String getPwd(String source){
        //使用MD5  hash算法
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] digest1 = digest.digest((source+SALT).getBytes());
            //把加密后的字节转换成字符串
            String target = Base64.getEncoder().encodeToString(digest1);
            return target;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
