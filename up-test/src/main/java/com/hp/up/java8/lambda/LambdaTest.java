package com.hp.up.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by haopeng on 2017/12/22 12:52
 */
public class LambdaTest {

    List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

    public static void main(String[] args) {
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();


        //Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        features.forEach(n -> System.out.println(n));

    }


}
