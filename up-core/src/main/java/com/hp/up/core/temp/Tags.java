package com.hp.up.core.temp;

import java.io.Serializable;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/8 15:17
 */

public class Tags implements Serializable {
    private static final long serialVersionUID = 8608275612277345642L;
    private List<String> names;
    private String namesStr;

    public Tags() {
    }

    public Tags(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getNamesStr() {
        return namesStr;
    }

    public void setNamesStr(String namesStr) {
        this.namesStr = namesStr;
    }

}
