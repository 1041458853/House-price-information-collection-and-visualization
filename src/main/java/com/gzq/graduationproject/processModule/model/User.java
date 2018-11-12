package com.gzq.graduationproject.processModule.model;

/**
 * @author 耿志强
 * 2018/10/31
 * 8:43
 */

//用户模型类
public class User{
    private Integer uid;

    private String email;

    private String password;

    private String nickname;

    //账户状态  0为未激活 1为正常
    private Integer state;

    //验证码
    private String code;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
