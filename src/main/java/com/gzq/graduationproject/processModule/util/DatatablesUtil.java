package com.gzq.graduationproject.processModule.util;

import java.util.List;

/**
 * @author 耿志强
 * 2018/10/29
 * 13:37
 */

//分页封装实体类
public class DatatablesUtil<T> {

    //每页显示集合
    private List<T> data;//LIST（结果集）
    //总记录数
    private long recordsTotal;

    private long recordsFiltered;

    //请求次数
    private long draw;

    public DatatablesUtil() {

    }

    public long getDraw() {
        return draw;
    }

    public void setDraw(long draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

}
