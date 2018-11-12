package com.gzq.graduationproject.informationCollectionModule.pipeline;

import com.gzq.graduationproject.informationCollectionModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanErShouFang;
import org.apache.ibatis.session.SqlSession;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import static com.gzq.graduationproject.informationCollectionModule.pipeline.ZhongYuanLouPanPipeline.sqlSessionFactory;

/**
 * @author 耿志强
 * 2018/10/16
 * 9:26
 */

//二手房
public class ZhongYuanErShouFangPipeline implements PageModelPipeline<ZhongYuanErShouFang>{


    @Override
    public void process(ZhongYuanErShouFang zhongYuanErshoufang, Task task) {
        //使用mybatis dao保存结果
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ZhongYuanMapper zhongYuanMapper = sqlSession.getMapper(ZhongYuanMapper.class);


            ZhongYuanErShouFang erShouFangBak = zhongYuanMapper.selectErShouFang(zhongYuanErshoufang);
            if (erShouFangBak != null){
                erShouFangBak.setJiage(zhongYuanErshoufang.getJiage());
                zhongYuanMapper.updateErShouFang(erShouFangBak);
                sqlSession.commit();
            }else {
                zhongYuanErshoufang.setChengshi("南京");
                zhongYuanMapper.erShouFangAdd(zhongYuanErshoufang);
                sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
            }

        } finally {
            sqlSession.close();
        }
    }
}
