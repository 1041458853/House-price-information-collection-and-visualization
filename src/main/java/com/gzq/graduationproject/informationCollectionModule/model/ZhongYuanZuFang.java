package com.gzq.graduationproject.informationCollectionModule.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;


@TargetUrl("https://\\w+.centanet.com/zufang/nj\\w+.html")
@HelpUrl("https://\\w+.centanet.com/zufang/g\\w+/")
public class ZhongYuanZuFang {
  private Long id;

  @ExtractBy("//div[@class='infomid']/div[@class='xiaop']/p[@class='addr'][3]/span/a[1]/text()")
  private String name;

  @ExtractBy("//p[@class='price]/b[@class='nub fnub']/text()")
  private String jiage;

  @ExtractBy("//div[@class='infomid]/p[@class='big']/span[2]/text()")
  private String mianji;

  @ExtractBy("//div[@class='infomid]/p[@class='big']/span[1]/text()")
  private String huxing;

  @ExtractBy("//div[@class='infomid]/p[@class='big']/span[3]/text()")
  private String chuzuleixing;

  @ExtractBy("//div[@class='infomid]/p[@class='small']/span[3]/text()")
  private String riqi;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[6]/span[@class='td']/text()")
  private String louti;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[1]/span[@class='td']/text()")
  private String wuye;

  @ExtractBy("//div[@class='infomid]/p[@class='small']/span[2]/text()")
  private String zhuangxiu;

  @ExtractBy("//div[@class='xiaop']/p[@class='addr'][3]/span/a[2]/text()")
  private String qu;

  @ExtractBy("//div[@class='xiaop']/p[@class='addr'][3]/span/a[3]/text()")
  private String jiedao;


  private String chengshi;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getJiage() {
    return jiage;
  }

  public void setJiage(String jiage) {
    this.jiage = jiage;
  }

  public String getMianji() {
    return mianji;
  }

  public void setMianji(String mianji) {
    this.mianji = mianji;
  }

  public String getHuxing() {
    return huxing;
  }

  public void setHuxing(String huxing) {
    this.huxing = huxing;
  }

  public String getChuzuleixing() {
    return chuzuleixing;
  }

  public void setChuzuleixing(String chuzuleixing) {
    this.chuzuleixing = chuzuleixing;
  }

  public String getRiqi() {
    return riqi;
  }

  public void setRiqi(String riqi) {
    this.riqi = riqi;
  }

  public String getLouti() {
    return louti;
  }

  public void setLouti(String louti) {
    this.louti = louti;
  }

  public String getWuye() {
    return wuye;
  }

  public void setWuye(String wuye) {
    this.wuye = wuye;
  }

  public String getZhuangxiu() {
    return zhuangxiu;
  }

  public void setZhuangxiu(String zhuangxiu) {
    this.zhuangxiu = zhuangxiu;
  }

  public String getQu() {
    return qu;
  }

  public void setQu(String qu) {
    this.qu = qu;
  }

  public String getJiedao() {
    return jiedao;
  }

  public void setJiedao(String jiedao) {
    this.jiedao = jiedao;
  }

  public String getChengshi() {
    return chengshi;
  }

  public void setChengshi(String chengshi) {
    this.chengshi = chengshi;
  }
}
