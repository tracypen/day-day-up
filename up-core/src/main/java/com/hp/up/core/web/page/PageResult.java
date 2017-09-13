package com.hp.up.core.web.page;

/**
 * @Author haopeng
 * @Date 2017/9/13 16:16
 */
import com.alibaba.fastjson.JSONArray;


public class PageResult {

    private Integer sEcho;//
    private Integer iTotalRecords;//实际的行数
    private Integer iTotalDisplayRecords;//过滤之后，实际的行数。
    private String sColumns;//可选，以逗号分隔的列名，;
    private JSONArray aaData;

    public PageResult() {
        super();
    }

    public Integer getSEcho() {
        return sEcho;
    }

    public void setSEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    public Integer getITotalRecords() {
        return iTotalRecords;
    }

    public void setITotalRecords(Integer iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Integer getITotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setITotalDisplayRecords(Integer iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getSColumns() {
        return sColumns;
    }

    public void setSColumns(String sColumns) {
        this.sColumns = sColumns;
    }

    public JSONArray getAaData() {
        return aaData;
    }

    public void setAaData(JSONArray aaData) {
        this.aaData = aaData;
    }




}