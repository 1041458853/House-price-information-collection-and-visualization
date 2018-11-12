package com.gzq.graduationproject.informationCollectionModule.pipeline;

import com.gzq.graduationproject.informationCollectionModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanZuFang;
import org.apache.ibatis.session.SqlSession;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import static com.gzq.graduationproject.informationCollectionModule.pipeline.ZhongYuanLouPanPipeline.sqlSessionFactory;

/**
 * @author 耿志强
 * 2018/10/16
 * 9:26
 */

//租房
public class ZhongYuanZuFangPipeline implements PageModelPipeline<ZhongYuanZuFang>{


    @Override
    public void process(ZhongYuanZuFang zhongYuanZufang, Task task) {
        //使用mybatis dao保存结果
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ZhongYuanMapper zhongYuanMapper = sqlSession.getMapper(ZhongYuanMapper.class);


            ZhongYuanZuFang zuFangBak = zhongYuanMapper.selectZuFang(zhongYuanZufang);
            if (zuFangBak != null){
                zuFangBak.setJiage(zhongYuanZufang.getJiage());
                zhongYuanMapper.updateZuFang(zuFangBak);
                sqlSession.commit();
            }else {
                zhongYuanZufang.setChengshi("南京");
                zhongYuanMapper.zuFangAdd(zhongYuanZufang);
                sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
            }
        } finally {
            sqlSession.close();
        }
    }
}
