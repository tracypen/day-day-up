package com.hp.up.core.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hp.up.core.utils.date.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by haopeng on 2017/9/13  22:11.
 */
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = -5614960042080272133L;

    protected static final Logger logger = LoggerFactory.getLogger(BaseEntity.class);
    protected String createBy;
    protected Long createUid;
    protected String modifyBy;
    protected Long modifyUid;
    protected Date createDate;
    protected Date modifyDate;

    public abstract Long getId();

    public abstract void setId(Long var1);

    public void setTrackingModify() {
        this.setTrackingModify((String)null);
    }

    public void setTrackingModify(String modifyBy) {
        if(StringUtils.isNotBlank(modifyBy)) {
            this.modifyBy = modifyBy;
        }

        this.modifyDate = DateUtils.now();
    }

    public void setTrackingModify(String createBy, Long createUid) {
        this.setTrackingModify(this.modifyBy);
        this.createUid = createUid;
    }

    public void setTrackingSave(String createBy, String modifyBy) {
        Date now = DateUtils.now();
        this.setTrackingSave(createBy, now, modifyBy, now);
    }

    public void setTrackingSave(Long createUid) {
        this.setTrackingSave((Long)createUid, DateUtils.now(), (Long)null, (Date)null);
    }

    public void setTrackingSave(String createBy, Date createDate, String modifyBy, Date modifyDate) {
        this.createBy = createBy;
        this.createDate = createDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public void setTrackingSave(Long createUid, Date createDate, Long modifyUid, Date modifyDate) {
        this.createUid = createUid;
        this.createDate = createDate;
        this.modifyUid = modifyUid;
        this.modifyDate = modifyDate;
    }

    @JsonIgnore
    public boolean isNew() {
        return null == this.getId();
    }

    public void beforPersist() {
        this.setCreateDate(new Date());
    }

    public void afterPersist() {
    }

    public void beforUpdate() {
        this.setModifyDate(new Date());
    }

    public void afterUpdate() {
    }

    public void beforRemove() {
    }

    public void afterRemove() {
    }



    public BaseEntity() {
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
