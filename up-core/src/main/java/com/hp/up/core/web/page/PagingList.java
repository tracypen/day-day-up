package com.hp.up.core.web.page;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author haopeng
 * @Date 2017/9/8 16:33
 */
public class PagingList <T> implements Iterable<T>, Serializable {

    private static final long serialVersionUID = -2300609512648267589L;
    private List<T> data;
    private PageInfo pageInfo;

    public PagingList(List<T> data, PageInfo pageInfo) {
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public List<T> getData() {
        if(this.data == null) {
            this.data = new ArrayList();
        }

        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageInfo getPaging() {
        return this.pageInfo;
    }

    public void setPaging(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Iterator<T> iterator() {
        return this.getData().iterator();
    }
}
