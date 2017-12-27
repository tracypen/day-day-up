package com.hp.up.test.designpattern.Singleton;

/**
 * 饿汉式实现
 * Created by haopeng on 2017/12/22 16:29
 */
public class Single4 {
    private static final Single4 INSTANCE = new Single4();

    private Single4() {
    }

    public static Single4 getInstance() {
        return INSTANCE;
    }
}

