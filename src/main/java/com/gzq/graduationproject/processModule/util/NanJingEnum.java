package com.gzq.graduationproject.processModule.util;

/**
 * @author 耿志强
 * 2018/10/20
 * 15:42
 */
public enum NanJingEnum {

    XUANWU("玄武"),QINHUAI("秦淮"),GULOU("鼓楼"),JIANYE("建邺"),YUHUATAI("雨花台"),QIXIA("栖霞"),PUKOU("浦口"),LIUHE("六合"),JIANGNING("江宁"),LISHUI("溧水"),GAOCHUN("高淳");

    private String shiQu;

    NanJingEnum(String shiQu) {
        this.shiQu = shiQu;
    }

    public String getShiQu() {
        return shiQu;
    }

    public void setShiQu(String shiQu) {
        this.shiQu = shiQu;
    }
}
