package com.hp.up.test.designpattern.Singleton;

/**
 * 双重检查（Double-Check）版本
 * Created by haopeng on 2017/12/22 16:21
 */

/**
 * 给getInstance方法加锁，虽然会避免了可能会出现的多个实例问题，但是会强制除T1之外的所有线程等待，实际上会对程序的执行效率造成负面影响。
 */
public class Single3 {
    private static Single3 instance;

    private Single3() {
    }

    public static Single3 getInstance() {
        if (instance == null) {
            synchronized (Single3.class) {
                if (instance == null) {
                    instance = new Single3();
                }
            }
        }
        return instance;
    }

    /**
     * 第一个if (instance == null)，其实是为了解决Version2中的效率问题，只有instance为null的时候，才进入synchronized的代码段大大减少了几率。
     　　第二个if (instance == null)，则是跟Version2一样，是为了防止可能出现多个实例的情况。
     */
}
