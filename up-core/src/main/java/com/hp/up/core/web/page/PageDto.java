package com.hp.up.core.web.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author haopeng
 * @Date 2017/9/8 16:14
 */
public class PageDto implements Serializable{

    private int pageNum;
    private int pageSize;
    private PageOrder pageOrder;

    public PageDto() {
    }

    public PageDto(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageDto(int pageNum, int pageSize, PageOrder pageOrder) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageOrder = pageOrder;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageOrder getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(PageOrder pageOrder) {
        this.pageOrder = pageOrder;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
