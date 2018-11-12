package com.gzq.graduationproject.informationCollectionModule.dao;

import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanErShouFang;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanLouPan;
import com.gzq.graduationproject.informationCollectionModule.model.ZhongYuanZuFang;

/**
 * @author 耿志强
 * 2018/10/15
 * 11:02
 */

public interface ZhongYuanMapper {

    //插入楼盘信息
    public void louPanAdd(ZhongYuanLouPan zhongYuanLoupan);

    //插入楼盘信息
    public void zuFangAdd(ZhongYuanZuFang zhongYuanZuFang);

    //插入楼盘信息
    public void erShouFangAdd(ZhongYuanErShouFang zhongYuanErShouFang);

    //根据名称返回楼盘信息
    public ZhongYuanLouPan selectLouPan(ZhongYuanLouPan zhongYuanLouPan);

    //根据名称返回二手房信息
    public ZhongYuanErShouFang selectErShouFang(ZhongYuanErShouFang zhongYuanLouPan);

    //根据名称返回租房信息
    public ZhongYuanZuFang selectZuFang(ZhongYuanZuFang zhongYuanLouPan);



    //更新楼盘记录
    public ZhongYuanLouPan updateLouPan(ZhongYuanLouPan zhongYuanLouPan);

    //更新二手房记录
    public ZhongYuanErShouFang updateErShouFang(ZhongYuanErShouFang zhongYuanLouPan);

    //更新租房记录
    public ZhongYuanZuFang updateZuFang(ZhongYuanZuFang zhongYuanLouPan);

}
