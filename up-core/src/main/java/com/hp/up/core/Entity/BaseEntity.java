package com.hp.up.core.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * @Author haopeng
 * @Date 2017/9/5 16:41
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -5614960042080272133L;

    protected static final Logger logger = LoggerFactory.getLogger(BaseEntity.class);
    protected String createBy;
    protected Long createUid;
    protected String modifyBy;
    protected Long modifyUid;
    protected Date createDate;
    protected Date modifyDate;

    public BaseEntity() {
    }

    public static Logger getLogger() {
        return logger;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Long getModifyUid() {
        return modifyUid;
    }

    public void setModifyUid(Long modifyUid) {
        this.modifyUid = modifyUid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
