package com.gzq.graduationproject;

import com.gzq.graduationproject.informationCollectionModule.ZhongYuanCrawler;
import com.gzq.graduationproject.processModule.util.Timer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraduationprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationprojectApplication.class, args);

		//定时执行爬虫
		new ZhongYuanCrawler().runCrawler();

		//定时保存各地区平均房价
        new Timer().runTimer();
    }
}
