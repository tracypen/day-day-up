package com.hp.up.core.Entity;

import java.io.Serializable;

/**
 * 系统用户实体 tb_user
 * @Author haopeng
 * @Date 2017/9/5 16:41
 */
public class User extends IdEntity{
    private static final long serialVersionUID = 7308957349197738881L;
    private String name;
    private String password;
    private String salt;

    public User() {
    }

    public User(Long id, String name, String password) {
        this.name = name;
        this.password = password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
