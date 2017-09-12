package com.hp.up.backend.shiro.utils;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * shiro 密码加密工具类
 * @Author haopeng
 * @Date 2017/9/8 17:44
 */
public class PwdUtil {

    //生成uuid --作为盐值
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr.substring(0,10);
    }

    /**
     * 使用shiro工具进行加密
     * @param sourcePwd 原始密码
     * @param salt 盐值
     * @param hashIterations 散列次数
     * @return
     */
    public static   String  encrypt(String sourcePwd,String salt,int hashIterations){
       return new SimpleHash("md5", sourcePwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
    }

}
