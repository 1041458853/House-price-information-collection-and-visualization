package com.gzq.graduationproject.informationCollectionModule;

import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanErShouFang;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanLouPan;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanZuFang;
import com.gzq.graduationproject.informationCollectionModule.pipeline.ZhongYuanErShouFangPipeline;
import com.gzq.graduationproject.informationCollectionModule.pipeline.ZhongYuanLouPanPipeline;
import com.gzq.graduationproject.informationCollectionModule.pipeline.ZhongYuanZuFangPipeline;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.gzq.graduationproject.informationCollectionModule.util.TimeUtil.getTimeMillis;

/**
 * @author 耿志强
 * 2018/10/15
 * 10:51
 */

@Component
public class ZhongYuanCrawler {

    public void louPancrawler(){
        OOSpider.create(Site.me().setSleepTime(1000)
                ,new ZhongYuanLouPanPipeline(), ZhongYuanLouPan.class)
                .addUrl("https://nj.centanet.com/xinfang/")
                .thread(5)
                .run();
    }



    //租房
    public void zuFangcrawler(){
        OOSpider.create(Site.me().setSleepTime(1000)
                ,new ZhongYuanZuFangPipeline(), ZhongYuanZuFang.class)
                .addUrl("https://nj.centanet.com/zufang/")
                .thread(5)
                .run();
    }

    public void erShouFangcrawler(){
        OOSpider.create(Site.me().setSleepTime(1000)
                ,new ZhongYuanErShouFangPipeline(), ZhongYuanErShouFang.class)
                .addUrl("https://nj.centanet.com/ershoufang/")
                .thread(5)
                .run();
    }


    public void runCrawler() {
        //定时器
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("20:00:00") - System.currentTimeMillis();
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

    @Override
    public void run() {
            ZhongYuanCrawler zhongYuanCrawler = new ZhongYuanCrawler();
            zhongYuanCrawler.zuFangcrawler();
            zhongYuanCrawler.louPancrawler();
            zhongYuanCrawler.erShouFangcrawler();
    }
}
