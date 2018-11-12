package com.gzq.graduationproject.processModule.util;

import com.gzq.graduationproject.processModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.processModule.model.ZhongYuanHistoryPrices;
import com.gzq.graduationproject.processModule.service.ZhongYuanLouPanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.gzq.graduationproject.informationCollectionModule.util.TimeUtil.getTimeMillis;

/**
 * @author 耿志强
 * 2018/11/7
 * 13:44
 */
public class Timer {

    public void runTimer() {
        //定时器
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("19:30:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        executor.scheduleAtFixedRate(
                new runTime(),
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }
    
}

//需要延时执行的事务
class runTime implements Runnable{

    @Autowired
    private ZhongYuanLouPanService zhongYuanLouPanService;

    @Autowired
    private ZhongYuanMapper zhongYuanMapper;

    @Override
    public void run() {
        //返回各地区平均房租
        Map<String,Float> zufang = zhongYuanLouPanService.nanJingZuFangAveragePrice();

        //返回各地区平均
        Map<String,Float> ershoufang = zhongYuanLouPanService.nanJingZuFangAveragePrice();

        //返回各地区平均房租
        Map<String,Float> loupan = zhongYuanLouPanService.nanJingZuFangAveragePrice();

        for (String area : loupan.keySet()) {
            ZhongYuanHistoryPrices historyPrices = new ZhongYuanHistoryPrices();
            historyPrices.setArea(area);
            historyPrices.setLoupan(loupan.get(area));
            historyPrices.setErshoufang(ershoufang.get(area));
            historyPrices.setZufang(zufang.get(area));
            historyPrices.setTime(Util.getDate());
            zhongYuanMapper.insertHistory(historyPrices);
        }
    }
}