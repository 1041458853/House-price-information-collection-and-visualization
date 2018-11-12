package com.gzq.graduationproject.informationCollectionModule.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://\\w+.centanet.com/xinfang/lp-\\w+")
@HelpUrl("https://\\w+.centanet.com/xinfang/g\\w+/")
public class ZhongYuanLouPan {
  private Long id;

  @ExtractBy("//div[@class='caption']/h2/span[@class='name']/text()")
  private String name;

  @ExtractBy("//ul[@class='nhbase_txt clearfix']/li[1]/p[@class='txt_r']/text()")
  private String weizhi;

  @ExtractBy("//ul[@class='nhbase_txt clearfix']/li[2]/p[@class='txt_r']/text()")
  private String kaifashang;

  @ExtractBy("//div[@class='pricebox]/cite/span[@class='nub']/text()")
  private String jiage;

  @ExtractBy("//ul[@class='nhbase_txt clearfix']/li[3]/p[@class='txt_r']/text()")
  private String leixing;

  @ExtractBy("//p[@class='house-type fl']/span[@class='f0']/text()")
  private String huxing;


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

  public String getWeizhi() {
    return weizhi;
  }

  public void setWeizhi(String weizhi) {
    this.weizhi = weizhi;
  }

  public String getKaifashang() {
    return kaifashang;
  }

  public void setKaifashang(String kaifashang) {
    this.kaifashang = kaifashang;
  }

  public String getJiage() {
    return jiage;
  }

  public void setJiage(String jiage) {
    this.jiage = jiage;
  }

  public String getLeixing() {
    return leixing;
  }

  public void setLeixing(String leixing) {
    this.leixing = leixing;
  }

  public String getHuxing() {
    return huxing;
  }

  public void setHuxing(String huxing) {
    this.huxing = huxing;
  }

  public String getChengshi() {
    return chengshi;
  }

  public void setChengshi(String chengshi) {
    this.chengshi = chengshi;
  }
}
