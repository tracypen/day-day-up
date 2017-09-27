package com.hp.up.core.web.shiro;

/**
 * @Author haopeng
 * @Date 2017/9/8 11:55
 */
public class UserShiro {

    private Long id;

    private String name;

    private String password;

    private String realName;

    public UserShiro() {
    }

    public UserShiro(Long id, String name, String password, String realName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.realName = realName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realname) {
        this.realName = realname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserShiro)) return false;

        UserShiro userShiro = (UserShiro) o;

        if (id != null ? !id.equals(userShiro.id) : userShiro.id != null) return false;
        if (name != null ? !name.equals(userShiro.name) : userShiro.name != null) return false;
        if (password != null ? !password.equals(userShiro.password) : userShiro.password != null) return false;
        return realName != null ? realName.equals(userShiro.realName) : userShiro.realName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "UserShiro{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realName + '\'' +
                '}';
    }
}
