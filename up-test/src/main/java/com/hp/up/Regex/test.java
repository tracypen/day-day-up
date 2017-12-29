package com.hp.up.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java正则表达式
 * Created by haopeng on 2017/12/28 14:02
 */
public class test {

    public static void main(String[] args) {
        //------------------------匹配验证-验证Email是否正确-----------------------------------------
        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);

        //---------------------------在字符串中查询字符或者字符串----------------------------------------------------------------------------


        // 要验证的字符串
         String str1 = "baike.xsoftlab.net";
        // 正则表达式规则
         String regEx1 = "baike.*";
        // 编译正则表达式
         Pattern pattern1 = Pattern.compile(regEx1);
        // 忽略大小写的写法
         Pattern pat1 = Pattern.compile(regEx1, Pattern.CASE_INSENSITIVE);
         Matcher matcher1 = pattern1.matcher(str1);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
         boolean rs1 = matcher1.find();
         System.out.println(rs1);
    }


 /*   一个或多个汉字：^[\u0391-\uFFE5]+$
    邮政编码：^[1-9]\d{5}$
    QQ号码：^[1-9]\d{4,10}$
    邮箱：^[a-zA-Z]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}.){1,3}[a-zA-z-]{1,}$
    用户名（字母开头 + 数字/字母/下划线）：^[A-Za-z][A-Za-z1-9-]+$
    手机号码：^1[3|4|5|8][0-9]\d{8}$
    URL：^((http|https)://)?([\w-]+.)+[\w-]+(/[\w-./?%&=]*)?$
    18位身份证号：^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X|x)?$
*/

// http://www.imooc.com/article/7615

}



