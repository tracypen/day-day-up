package com.hp.up.core.utils.date;

import java.text.SimpleDateFormat;

/**
 * @Author haopeng
 * @Date 2017/9/7 16:19
 */
public interface DateFormat {
    String STRING_SHORT_FORMAT = "yyyy-MM-dd";
    String STRING_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat SIMPLE_SHORT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat SIMPLE_LONG_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}