package com.hp.up.lombok;

/**
 * Created by haopeng on 2017/12/20 14:14
 */
public class TestLombok {

    public static void main(String[] args) {
        User user = new User();
        user.setId(123L);
        user.setName("youBatis");
        System.out.println(user.toString());
    }

}
