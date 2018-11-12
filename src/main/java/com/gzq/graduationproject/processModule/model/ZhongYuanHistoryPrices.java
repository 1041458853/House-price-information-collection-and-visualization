package com.gzq.graduationproject.processModule.model;

import java.sql.Date;

/**
 * @author 耿志强
 * 2018/11/7
 * 13:33
 */

public class ZhongYuanHistoryPrices {

    private String area;

    private float loupan;

    private float ershoufang;

    private float zufang;

    private Date time;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getLoupan() {
        return loupan;
    }

    public void setLoupan(float loupan) {
        this.loupan = loupan;
    }

    public float getErshoufang() {
        return ershoufang;
    }

    public void setErshoufang(float ershoufang) {
        this.ershoufang = ershoufang;
    }

    public float getZufang() {
        return zufang;
    }

    public void setZufang(float zufang) {
        this.zufang = zufang;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
