package com.hp.up.test.designpattern.factory.SimpleFactory;

/**
 * Created by haopeng on 2017/12/22 16:33
 */
public class ProductFactory {
    public static Product produce(String productName) throws Exception {
        switch (productName) {
            case "tv":
                return new Tv();
            case "car":
                return new Car();
            default:
                throw new Exception("没有该产品");
        }
    }
}

