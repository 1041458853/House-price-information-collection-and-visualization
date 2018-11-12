package com.gzq.graduationproject.processModule.dao;

import com.gzq.graduationproject.processModule.model.User;
import com.gzq.graduationproject.processModule.model.ZhongYuanHistoryPrices;
import org.apache.ibatis.annotations.*;

/**
 * @author 耿志强
 * 2018/10/31
 * 9:44
 */
@Mapper
public interface UserMapper {

    //用户注册，将用户信息写入数据库
    @Insert("insert into user(email,password,nickname,state,code) value(#{email},#{password},#{nickname},#{state},#{code})")
    public int insertUser(User user);

    //根据邮件账户返回用户信息
    @Select("select * from user where email=#{email}")
    public User selectUserByName(@Param("email") String email);

    //根据激活码返回用户信息
    @Select("select * from user where code=#{code}")
    public User selectUserByCode(@Param("code") String code);

    //更新用户信息
    @Update("update user set email=#{email},password=#{password},nickname=#{nickname},state=#{state},code=#{code} where uid=#{uid}")
    public int updateUser(User user);


}
