package com.hp.up.test.designpattern.Singleton;

/**
 *  synchronized版本
 * Created by haopeng on 2017/12/22 16:19
 */

/**
 * 如果有多个线程同时运行到if (instance == null)，都判断为null，那么两个线程就各自会创建一个实例——这样一来，就不是单例了。
 */
public class Single2 {
    private static Single2 instance;

    private Single2() {
    }

    public static synchronized Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}


