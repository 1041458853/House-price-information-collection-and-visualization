package com.gzq.graduationproject.informationCollectionModule.pipeline;

import com.gzq.graduationproject.informationCollectionModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanLouPan;
import com.gzq.graduationproject.informationCollectionModule.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author 耿志强
 * 2018/10/15
 * 9:57
 */

//楼盘
public class ZhongYuanLouPanPipeline implements PageModelPipeline<ZhongYuanLouPan>{

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }


    //zhongYuanLoupan   add() 方法
//    public static void louPanAdd(ZhongYuanLouPan zhongYuanLoupan) {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try {
//            ZhongYuanMapper zhongYuanMapper = sqlSession.getMapper(ZhongYuanMapper.class);
//            zhongYuanMapper.add(zhongYuanLoupan);
//            sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
//        } finally {
//            sqlSession.close();
//        }
//    }

    @Override
    public void process(ZhongYuanLouPan zhongYuanLoupan, Task task) {
        //使用mybatis dao保存结果
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ZhongYuanMapper zhongYuanMapper = sqlSession.getMapper(ZhongYuanMapper.class);


            ZhongYuanLouPan louPanBak = zhongYuanMapper.selectLouPan(zhongYuanLoupan);
            if (louPanBak != null){
                louPanBak.setJiage(zhongYuanLoupan.getJiage());
                zhongYuanMapper.updateLouPan(louPanBak);
                sqlSession.commit();
            }else {
                zhongYuanLoupan.setChengshi("南京");
                zhongYuanMapper.louPanAdd(zhongYuanLoupan);
                sqlSession.commit();// 这里一定要提交，不然数据进不去数据库中
            }

        } finally {
            sqlSession.close();
        }
    }
}
