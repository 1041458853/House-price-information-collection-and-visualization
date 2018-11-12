package com.gzq.graduationproject.informationCollectionModule.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://\\w+.centanet.com/ershoufang/nj\\w+.html")
@HelpUrl("https://\\w+.centanet.com/ershoufang/g\\w+/")
public class ZhongYuanErShouFang {
  private Long id;

  @ExtractBy("//div[@class='infomid']/div[@class='xiaop']/p[@class='addr'][3]/span/a[1]/text()")
  private String name;

  @ExtractBy("//p[@class='price]/b[@class='nub fnub']/text()")
  private String jiage;

  @ExtractBy("//div[@class='infomid]/p[@class='big']/span[2]/text()")
  private String mianji;

  @ExtractBy("//div[@class='infomid]/p[@class='big']/span[1]/text()")
  private String huxing;

  @ExtractBy("//div[@class='infomid]/p[@class='small']/span[2]/text()")
  private String zhuangxiu;

  @ExtractBy("//div[@class='infomid]/p[@class='small']/span[1]/text()")
  private String louceng;

  @ExtractBy("//div[@class='infomid]/p[@class='small']/span[3]/text()")
  private String riqi;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[1]/span[@class='td']/text()")
  private String leixing;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[2]/span[@class='td']/text()")
  private String lvhualv;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[5]/span[@class='td']/text()")
  private String guanlifei;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[11]/span[@class='td']/text()")
  private String wuye;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[13]/span[@class='td']/text()")
  private String kaifashang;

  @ExtractBy("//ul[@class='baseinf-lists clearfix]/li[14]/span[@class='td']/text()")
  private String louti;

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

  public String getZhuangxiu() {
    return zhuangxiu;
  }

  public void setZhuangxiu(String zhuangxiu) {
    this.zhuangxiu = zhuangxiu;
  }

  public String getLouceng() {
    return louceng;
  }

  public void setLouceng(String louceng) {
    this.louceng = louceng;
  }

  public String getRiqi() {
    return riqi;
  }

  public void setRiqi(String riqi) {
    this.riqi = riqi;
  }

  public String getLeixing() {
    return leixing;
  }

  public void setLeixing(String leixing) {
    this.leixing = leixing;
  }

  public String getLvhualv() {
    return lvhualv;
  }

  public void setLvhualv(String lvhualv) {
    this.lvhualv = lvhualv;
  }

  public String getGuanlifei() {
    return guanlifei;
  }

  public void setGuanlifei(String guanlifei) {
    this.guanlifei = guanlifei;
  }

  public String getWuye() {
    return wuye;
  }

  public void setWuye(String wuye) {
    this.wuye = wuye;
  }

  public String getKaifashang() {
    return kaifashang;
  }

  public void setKaifashang(String kaifashang) {
    this.kaifashang = kaifashang;
  }

  public String getLouti() {
    return louti;
  }

  public void setLouti(String louti) {
    this.louti = louti;
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
