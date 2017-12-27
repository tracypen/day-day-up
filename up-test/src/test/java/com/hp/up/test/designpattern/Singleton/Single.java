package com.hp.up.test.designpattern.Singleton;


/**
 * Created by haopeng on 2017/12/22 16:14
 */
public class Single {

    private static Single instance;

    /**
     * 构造器私有化----防止外部调用
     */
    private Single() {
    }

    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }

}
