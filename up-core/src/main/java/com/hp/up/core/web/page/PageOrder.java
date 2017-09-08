package com.hp.up.core.web.page;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @Author haopeng
 * @Date 2017/9/8 16:16
 */
public class PageOrder implements Serializable{

    public static final String ASC = "asc";
    public static final String DESC = "desc";

    private String name = "";
    private boolean asc = true;

    public PageOrder() {
    }

    public PageOrder(String name, boolean direction) {
        this.name = name;
        this.asc = direction;
    }

    public boolean isEmpty() {
        return StringUtils.isBlank(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isAsc() {
        return this.asc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public void parser(String expressions) {
        String[] array = expressions.split("==");
        this.name = array[0];
        if(StringUtils.equalsIgnoreCase("asc", array[1])) {
            this.asc = true;
        } else {
            this.asc = false;
        }

    }

    public String getOrderExpressions() {
        return this.getName() + "==" + (this.isAsc()?"asc":"desc");
    }

    public void setOrder(String expressions) {
        this.parser(expressions);
    }

    public String getOrder() {
        return this.getName() + " " + (this.isAsc()?"asc":"desc");
    }

    public void setDefault(String expressions) {
        if(this.isEmpty()) {
            this.parser(expressions);
        }

    }

}
