package com.hp.up.test.designpattern.factory.SimpleFactory;

import org.junit.Test;

/**
 * Created by haopeng on 2017/12/22 16:50
 */
public class test {

    @Test
    public void testMethod1(){
        try {
            ProductFactory.produce("car");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ProductFactory2.produce("com.hp.up.test.designpattern.factory.SimpleFactory.Tv");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
