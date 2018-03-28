package com.imooc.demo.entity;

import java.util.Date;

public class Area {
    //主键
    private Integer areaId;
    //名称
    private String areaName;
    //权重，越大越靠前显示
    private Integer priority;
    //创建时间
    private Date createDate;
    //更新时间
    private Date LastEidtTime;

    public Integer getAreaId() {
        return areaId;
    }

    public Area setAreaId(Integer areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public Area setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public Area setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Area setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getLastEidtTime() {
        return LastEidtTime;
    }

    public Area setLastEidtTime(Date lastEidtTime) {
        LastEidtTime = lastEidtTime;
        return this;
    }
}
