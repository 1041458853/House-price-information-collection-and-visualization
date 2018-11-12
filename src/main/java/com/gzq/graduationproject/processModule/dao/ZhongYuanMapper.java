package com.gzq.graduationproject.processModule.dao;

import com.gzq.graduationproject.processModule.model.ZhongYuanErShouFang;
import com.gzq.graduationproject.processModule.model.ZhongYuanHistoryPrices;
import com.gzq.graduationproject.processModule.model.ZhongYuanLouPan;
import com.gzq.graduationproject.processModule.model.ZhongYuanZuFang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

/**
 * @author 耿志强
 * 2018/10/15
 * 11:02
 */

@Mapper
public interface ZhongYuanMapper {

    //返回所有楼盘信息（未处理）
    @Select("select * from loupan")
    public List<ZhongYuanLouPan> getZhongYuanLouPans();

    //返回所有二手房信息（未处理）
    @Select("select * from ershoufang")
    public List<ZhongYuanErShouFang> getZhongYuanErShouFangs();

    //返回所有租房信息（未处理）
    @Select("select * from zufang")
    public List<ZhongYuanZuFang> getZhongYuanZuFangs();




    //根据地段返回楼盘信息
    @Select("select * from loupan where weizhi like CONCAT('%',#{weizhi},'%')")
    public List<ZhongYuanLouPan> getZhongYuanLouPansByWeiZhi(@Param("weizhi") String weizhi);

    //根据行政区返回二手房信息
    @Select("select * from ershoufang where qu like CONCAT('%',#{qu},'%')")
    public List<ZhongYuanErShouFang> getZhongYuanErShouFangsByQu(@Param("qu") String qu);

    //根据行政区返回租房信息
    @Select("select * from zufang where qu like CONCAT('%',#{qu},'%')")
    public List<ZhongYuanZuFang> getZhongYuanZuFangsByQu(@Param("qu") String qu);



    //根据位置返回当地楼盘的数量
    @Select("select count(*) from loupan where weizhi like CONCAT('%',#{weizhi},'%')")
    public int numOfLouPans(@Param("weizhi") String weizhi);

    //根据位置返回当地二手房的数量
    @Select("select count(*) from ershoufang where qu like CONCAT('%',#{qu},'%')")
    public int numOfErShouFangs(@Param("qu") String qu);

    //根据位置返回当地租房房源的数量
    @Select("select count(*) from zufang where qu like CONCAT('%',#{qu},'%')")
    public int numOfZuFangs(@Param("qu") String qu);


    //将历史信息存入数据库
    @Update("insert into history(area,loupan,ershoufang,zufang,time) value(#{area},#{loupan},#{ershoufang},#{zufang},#{time})")
    public int insertHistory(ZhongYuanHistoryPrices historyPrices);

    //根据时间提取历史信息
    @Select("select * from history where time between #{time1} and #{time2} and area = #{area}")
    public List<ZhongYuanHistoryPrices> getZhongYuanHistoryPrices(@Param("time1")Date date1,@Param("time2")Date date2,@Param("area")String area);
}
