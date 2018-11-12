package com.gzq.graduationproject.processModule.controller;

import com.github.pagehelper.Page;
import com.gzq.graduationproject.processModule.dao.ZhongYuanMapper;
import com.gzq.graduationproject.processModule.model.*;
import com.gzq.graduationproject.processModule.service.MailService;
import com.gzq.graduationproject.processModule.service.UserService;
import com.gzq.graduationproject.processModule.service.ZhongYuanLouPanService;
import com.gzq.graduationproject.processModule.util.DatatablesUtil;
import com.gzq.graduationproject.processModule.util.NanJingEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 耿志强
 * 2018/10/17
 * 15:12
 */


//中原地产restful风格接口
@RestController
@RequestMapping(value="/zhongyuan")
public class ZhongYuanController {

    @Autowired
    private ZhongYuanMapper zhongYuanMapper;
    @Autowired
    private ZhongYuanLouPanService zhongYuanLouPanService;
    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    //返回所有楼盘信息（未处理）
    @RequestMapping(value="/zhongyuanloupans", method= RequestMethod.GET)
    public List<ZhongYuanLouPan> getZhongYuanLouPans(){
        return zhongYuanMapper.getZhongYuanLouPans();
    }

    //返回所有二手房信息（未处理）
    @RequestMapping(value="/zhongyuanershoufangs", method= RequestMethod.POST)
    public DatatablesUtil getZhongYuanErShouFangs(@RequestParam Integer page, @RequestParam Integer pagesize, @RequestParam Integer draw){
        Page<ZhongYuanErShouFang> pageInfo = PageHelper.startPage(page, pagesize);
        List<ZhongYuanErShouFang> list = zhongYuanMapper.getZhongYuanErShouFangs();

        DatatablesUtil datatablesUtil = new DatatablesUtil();
        datatablesUtil.setDraw(draw);
        datatablesUtil.setData(list);
        datatablesUtil.setRecordsTotal((int)pageInfo.getTotal());
        datatablesUtil.setRecordsFiltered(datatablesUtil.getRecordsTotal());

        return datatablesUtil;
    }

    //返回所有租房信息（未处理）
    @RequestMapping(value="/zhongyuanzufangs", method= RequestMethod.GET)
    public List<ZhongYuanZuFang> getZhongYuanZuFangs(){
        return zhongYuanMapper.getZhongYuanZuFangs();
    }




    //根据位置查询楼盘信息
    @RequestMapping(value = "/zhongyuanloupans/weizhi", params = {"weizhi"})
    public List<ZhongYuanLouPan> getZhongYuanLouPansByWeiZhi(String weizhi){
        return zhongYuanMapper.getZhongYuanLouPansByWeiZhi(weizhi);
    }

    //返回南京各个行政区楼盘的平均房价
    @RequestMapping(value = "/zhongyuanloupans/loupanaverageprice",method = RequestMethod.GET)
    public Map louPanAveragePrice(){
        return zhongYuanLouPanService.nanJingLouPanAveragePrice();
    }

    //返回南京各个行政区二手房的平均房价
    @RequestMapping(value = "/zhongyuanloupans/ershoufangaverageprice",method = RequestMethod.GET)
    public Map erShouFangAveragePrice()
    {
        return zhongYuanLouPanService.nanJingErShouFangAveragePrice();
    }

    //返回南京各个行政区的平均房租
    @RequestMapping(value = "/zhongyuanloupans/zufangaverageprice",method = RequestMethod.GET)
    public Map zuFangAveragePrice(){
        return zhongYuanLouPanService.nanJingZuFangAveragePrice();
    }




    //返回南京各个行政区楼盘的数量
    @RequestMapping(value = "/zhongyuanloupans/numofloupans",method = RequestMethod.GET)
    public Map numOfLouPans(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        for (NanJingEnum e : NanJingEnum.values()){
            map.put(e.getShiQu(),zhongYuanMapper.numOfLouPans(e.getShiQu()));
        }
        return map;
    }

    //返回南京各个行政区二手房的数量
    @RequestMapping(value = "/zhongyuanloupans/numofershoufangs",method = RequestMethod.GET)
    public Map numOfErShouFangs(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        for (NanJingEnum e : NanJingEnum.values()){
            map.put(e.getShiQu(),zhongYuanMapper.numOfErShouFangs(e.getShiQu()));
        }
        return map;
    }

    //返回各个行政区出租房的数量
    @RequestMapping(value = "/zhongyuanloupans/numofzufangs",method = RequestMethod.GET)
    public Map numOfZuFangs(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        for (NanJingEnum e : NanJingEnum.values()){
            map.put(e.getShiQu(),zhongYuanMapper.numOfZuFangs(e.getShiQu()));
        }
        return map;
    }

    //返回楼盘历史信息
    @RequestMapping(value = "/historylp",method = RequestMethod.GET)
    public Map<String,List> getZhongYuanHistoryPrices(){
        return zhongYuanLouPanService.getZhongYuanHistoryPricesOfLouPan();
    }

    //返回二手房历史信息
    @RequestMapping(value = "/historyesf",method = RequestMethod.GET)
    public Map<String,List> getZhongYuanHistoryPricesOfErShoufang(){
        return zhongYuanLouPanService.getZhongYuanHistoryPricesOfErShoufang();
    }

    //返回租房历史信息
    @RequestMapping(value = "/historyzf",method = RequestMethod.GET)
    public Map<String,List> getZhongYuanHistoryPricesOfZuFang(){
        return zhongYuanLouPanService.getZhongYuanHistoryPricesOfZuFang();
    }


}
