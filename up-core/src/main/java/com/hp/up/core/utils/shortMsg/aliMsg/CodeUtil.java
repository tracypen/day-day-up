package com.hp.up.core.utils.shortMsg.aliMsg;

import java.util.Random;

/**
 * 验证码生成-工具类
 * com.hp.up.core.utils.shortMsg.aliMsg
 * Created by haopeng on 2017/10/28  11:08.
 */
public class CodeUtil {

    public static final int FOUR_BIT = 4;

    public static final int SIX_BIT = 6;

    /**
     * 生成短信验证码随机数
     * @param bitNum 位数
     * @return 验证码String
     */
    public static String genarate(int bitNum){
        if (bitNum < 1){
            bitNum =  SIX_BIT;
        }
        Random random = new Random();
        StringBuilder result= new StringBuilder();
        for(int i=0;i<bitNum;i++){
            result.append(random.nextInt(10));
        }
        //System.out.print(result);
        return result.toString();
    }
}
