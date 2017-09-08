package com.hp.up.core.Entity;

import com.hp.up.core.enums.BooleanType;

import java.io.Serializable;
import java.util.Date;

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
    private String email;
    private int gender;
    private BooleanType active;
    private String realName;
    private Date lastLoginTime;
    private Date birthday;
    private int status;
    private String nickName;
    private String qq;
    private String avatar;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public BooleanType getActive() {
        return active;
    }

    public void setActive(BooleanType active) {
        this.active = active;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
