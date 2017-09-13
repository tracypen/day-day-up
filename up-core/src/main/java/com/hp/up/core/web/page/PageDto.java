package com.hp.up.core.web.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author haopeng
 * @Date 2017/9/8 16:14
 */
public class PageDto implements Serializable{

    private int sEcho;//页数
    private int iColumns;//
    private String sColumns;
    private int iDisplayStart;
    private int iDisplayLength;
    private int pageNum;

    public int getPageNum() {
        pageNum = 1;
        if(iColumns > 0){
            pageNum =  iDisplayStart / iDisplayLength + 1;
        }
        return pageNum;
    }



    public int getsEcho() {
        return sEcho ;
    }
    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }
    public int getiColumns() {
        return iColumns == 0 ? 15 :iColumns;
    }
    public void setiColumns(int iColumns) {
        this.iColumns = iColumns == 0 ? 15 :iColumns;
    }
    public String getsColumns() {
        return sColumns;
    }
    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }
    public int getiDisplayStart() {
        return iDisplayStart;
    }
    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }
    public int getiDisplayLength() {
        return iDisplayLength;
    }
    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }
}
