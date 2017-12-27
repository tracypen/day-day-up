package com.hp.up.test.designpattern.factory.SimpleFactory;

/**
 * 利用反射机制
 * Created by haopeng on 2017/12/22 16:51
 */
public class ProductFactory2 {
    public static Product produce(String className) throws Exception {
        try {
            Product product = (Product) Class.forName(className).newInstance();
            return product;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new Exception("没有该产品");
    }
}
