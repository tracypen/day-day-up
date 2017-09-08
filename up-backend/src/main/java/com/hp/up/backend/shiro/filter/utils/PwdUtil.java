package com.hp.up.backend.shiro.filter.utils;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @Author haopeng
 * @Date 2017/9/8 17:44
 */
public class PwdUtil {

    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr.substring(0,10);
    }

    public  String  encrypt(String sourcePwd,String salt,int hashIterations){
       return new SimpleHash("md5", sourcePwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
    }


}
