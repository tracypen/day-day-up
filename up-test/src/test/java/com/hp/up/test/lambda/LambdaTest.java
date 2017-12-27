package com.hp.up.test.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by haopeng on 2017/12/22 15:30
 */
public class LambdaTest {

    /**
     * 1.用lambda表达式实现Runnable
     */
    @Test
    public void testMethod1() {
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        // Java 8之前：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

    }

    @Test
    public void testMethod2() {
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // Java 8之前：
        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);

    }

}
