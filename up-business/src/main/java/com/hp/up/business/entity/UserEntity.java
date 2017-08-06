package com.hp.up.business.entity;

import java.io.Serializable;

/**
 * com.hp.up.business.entity
 * Created by haopeng on 2017/8/6  22:41.
 */
public class UserEntity implements Serializable{
    private  Integer id;
    private  String  name;
    private  String  password;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
