package com.gzq.graduationproject.processModule.service;

import com.gzq.graduationproject.processModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.processModule.model.ZhongYuanErShouFang;
import com.gzq.graduationproject.processModule.model.ZhongYuanHistoryPrices;
import com.gzq.graduationproject.processModule.model.ZhongYuanLouPan;
import com.gzq.graduationproject.processModule.model.ZhongYuanZuFang;
import com.gzq.graduationproject.processModule.util.NanJingEnum;
import com.gzq.graduationproject.processModule.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 耿志强
 * 2018/10/20
 * 15:40
 */
@Service
public class ZhongYuanLouPanService {

    @Autowired
    private ZhongYuanMapper zhongYuanMapper;


    //返回南京各个区楼盘的平均房价
    public Map<String,Float> nanJingLouPanAveragePrice(){
        Map<String,Float> map = new HashMap<String, Float>();
        for (NanJingEnum e : NanJingEnum.values()){
                map.put(e.getShiQu(),louPanAveragePrice(e.getShiQu()));
        }
        return map;
    }

    //返回南京各个区二手房的平均房价
    public Map<String,Float> nanJingErShouFangAveragePrice(){
        Map<String,Float> map = new HashMap<String, Float>();
        for (NanJingEnum e : NanJingEnum.values()){
            map.put(e.getShiQu(),erShouFangAveragePrice(e.getShiQu()));
        }
        return map;
    }

    //返回南京各个区的平均房租
    public Map<String,Float> nanJingZuFangAveragePrice(){
        Map<String,Float> map = new HashMap<String, Float>();
        for (NanJingEnum e : NanJingEnum.values()){
            map.put(e.getShiQu(),zuFangAveragePrice(e.getShiQu()));
        }
        return map;
    }


    //返回一个地区楼盘的平均房价
    private float louPanAveragePrice(String shiQu){
        float price = 0.0f;
        List<ZhongYuanLouPan> zhongYuanLouPanList = zhongYuanMapper.getZhongYuanLouPansByWeiZhi(shiQu);
        for (ZhongYuanLouPan zhongYuanLouPan : zhongYuanLouPanList) {
            if (zhongYuanLouPan.getJiage() != null){
                price += Util.change(zhongYuanLouPan.getJiage());
            }
        }

        if (zhongYuanLouPanList.size() != 0){
            return price/zhongYuanLouPanList.size();
        }else {
            return 20000f;
        }

    }

    //返回一个地区二手房的平均房价
    private float erShouFangAveragePrice(String shiQu){
        float price = 0.0f;
        List<ZhongYuanErShouFang> list = zhongYuanMapper.getZhongYuanErShouFangsByQu(shiQu);
        for (ZhongYuanErShouFang zhongYuanLouPan : list) {
            if (zhongYuanLouPan.getJiage() != null){
                price += Util.change(zhongYuanLouPan.getJiage());
            }
        }
        return price/list.size();
    }

    //返回一个地区的平均房租
    private float zuFangAveragePrice(String shiQu){
        float price = 0.0f;
        List<ZhongYuanZuFang> list = zhongYuanMapper.getZhongYuanZuFangsByQu(shiQu);
        for (ZhongYuanZuFang zhongYuanLouPan : list) {
            if (zhongYuanLouPan.getJiage() != null){
                price += Util.change(zhongYuanLouPan.getJiage());
            }
        }
        return price/list.size();
    }


    //返回历史七天内的平均楼盘的价格
    public Map<String,List> getZhongYuanHistoryPricesOfLouPan(){
        Map<String,List> map = new HashMap<String, List>();

        //将选择中的七天时间放入列表
        List<String> dates = new ArrayList<>();
        for (int i = 0; i<7; i++){
            dates.add(Util.getBeforeDate(-i).toString());
        }
        map.put("dates",dates);

        //将七天内的楼盘历史平均房价放入列表
        List<String> loupan = new ArrayList<>();
        for (NanJingEnum e : NanJingEnum.values()) {
            List<ZhongYuanHistoryPrices> list = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-7),Util.getBeforeDate(-1),e.getShiQu());
            List<Float> prices = new ArrayList<Float>();
            for (ZhongYuanHistoryPrices zhongYuanHistoryPrices : list){
                prices.add(zhongYuanHistoryPrices.getLoupan());
            }
            map.put(e.toString(),prices);
        }

        return map;



        //获取历史七天的记录
//        List<ZhongYuanHistoryPrices> list1 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-1),Util.getBeforeDate(-1));
//        List<ZhongYuanHistoryPrices> list2 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-2),Util.getBeforeDate(-2));
//        List<ZhongYuanHistoryPrices> list3 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-3),Util.getBeforeDate(-3));
//        List<ZhongYuanHistoryPrices> list4 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-4),Util.getBeforeDate(-4));
//        List<ZhongYuanHistoryPrices> list5 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-5),Util.getBeforeDate(-5));
//        List<ZhongYuanHistoryPrices> list6 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-6),Util.getBeforeDate(-6));
//        List<ZhongYuanHistoryPrices> list7 = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-7),Util.getBeforeDate(-7));
//
//        Map<String,Map> map = new HashMap<String,Map>();
//
//        //将所有地区添加进map
//        List<String> areas = new ArrayList<>();
//        for (NanJingEnum e : NanJingEnum.values()) {
//            areas.add(e.getShiQu());
//        }
//        map.put("area",areas);
//
//
//        Map<String,List> loupan = new HashMap<String, List>();
//
//        for (NanJingEnum e : NanJingEnum.values()) {
//            loupan.put(e.getShiQu(),)
//        }
//
//        map.put("楼盘",loupan);
//        return map;
    }

    //返回历史七天内的平均二手房价格
    public Map<String,List> getZhongYuanHistoryPricesOfErShoufang(){
        Map<String,List> map = new HashMap<String, List>();

        //将选择中的七天时间放入列表
        List<String> dates = new ArrayList<>();
        for (int i = 0; i<7; i++){
            dates.add(Util.getBeforeDate(-i).toString());
        }
        map.put("dates",dates);

        //将七天内的楼盘历史平均房价放入列表
        List<String> ershoufang = new ArrayList<>();
        for (NanJingEnum e : NanJingEnum.values()) {
            List<ZhongYuanHistoryPrices> list = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-7),Util.getBeforeDate(-1),e.getShiQu());
            List<Float> prices = new ArrayList<Float>();
            for (ZhongYuanHistoryPrices zhongYuanHistoryPrices : list){
                prices.add(zhongYuanHistoryPrices.getErshoufang());
            }
            map.put(e.toString(),prices);
        }

        return map;
    }

    //返回历史七天内的平均租房价格
    public Map<String,List> getZhongYuanHistoryPricesOfZuFang(){
        Map<String,List> map = new HashMap<String, List>();

        //将选择中的七天时间放入列表
        List<String> dates = new ArrayList<>();
        for (int i = 0; i<7; i++){
            dates.add(Util.getBeforeDate(-i).toString());
        }
        map.put("dates",dates);

        //将七天内的楼盘历史平均房价放入列表
        List<String> zufang = new ArrayList<>();
        for (NanJingEnum e : NanJingEnum.values()) {
            List<ZhongYuanHistoryPrices> list = zhongYuanMapper.getZhongYuanHistoryPrices(Util.getBeforeDate(-7),Util.getBeforeDate(-1),e.getShiQu());
            List<Float> prices = new ArrayList<Float>();
            for (ZhongYuanHistoryPrices zhongYuanHistoryPrices : list){
                prices.add(zhongYuanHistoryPrices.getZufang());
            }
            map.put(e.toString(),prices);
        }

        return map;
    }
}
