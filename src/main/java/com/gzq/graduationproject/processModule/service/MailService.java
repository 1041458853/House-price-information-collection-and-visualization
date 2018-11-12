package com.gzq.graduationproject.processModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author 耿志强
 * 2018/10/30
 * 20:41
 */

@Service
public class MailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /*
      *@Description: 发送邮件
      *@param: to
      *@param: code
      *@return: void
      *@Author: GengZhiQiang
      *@date: 2018/11/1
     * */
    public void sendMail(String to,String code){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(to);
        mailMessage.setSubject("房价分析系统激活邮件");
        mailMessage.setText("激活点击以此连接：http://localhost:8080/activeuser?code="+code);
        javaMailSender.send(mailMessage);
    }


    public void resetPassword(String to,String code){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(to);
        mailMessage.setSubject("房价分析系统激活邮件");
        mailMessage.setText("激活点击以此连接：http://localhost:8080/activeuser?code="+code);
        javaMailSender.send(mailMessage);
    }


}
