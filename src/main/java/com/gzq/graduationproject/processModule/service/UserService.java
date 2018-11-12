package com.gzq.graduationproject.processModule.service;

import com.gzq.graduationproject.processModule.dao.UserMapper;
import com.gzq.graduationproject.processModule.model.User;
import com.gzq.graduationproject.processModule.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 耿志强
 * 2018/10/31
 * 22:40
 */
@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailService mailService;



    //将注册的用户信息保存在数据库，状态设为未激活
    public Boolean register(User user){
        if (userMapper.selectUserByName(user.getEmail()) != null ){
            return false;
        }

        //设置状态码
        user.setState(0);
        //设置激活码
        user.setCode(Util.getUUID());

        //将用户信息存入数据库
        int i= userMapper.insertUser(user);

        //发送一封激活邮件
        mailService.sendMail(user.getEmail(),user.getCode());

        if (i == 1){
            return true;
        }
        return false;
    }


    //激活用户
    public Boolean activeUser(String code){
        User user = userMapper.selectUserByCode(code);
        if(user != null){
            user.setState(1);
            user.setCode(null);
            userMapper.updateUser(user);
            return true;
        }else {
            return false;
        }
    }

    //验证账户是否可用获存在
    public Boolean authentication(String email,String password){
        User user = userMapper.selectUserByName(email);
        if (user.getState() == 0){
            return false;
        }else if (user.getState() == 1 && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    //返回用户昵称
    public String nickname(String email){
        User user = userMapper.selectUserByName(email);
        if (user != null){
            return user.getNickname();
        }
        return "";
    }

}
