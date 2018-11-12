package com.gzq.graduationproject.processModule.controller;

import com.gzq.graduationproject.processModule.config.WebSecurityConfig;
import com.gzq.graduationproject.processModule.model.User;
import com.gzq.graduationproject.processModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 耿志强
 * 2018/11/6
 * 10:59
 */
@Controller
public class viewController {

    @Autowired
    private UserService userService;

    @GetMapping("/loupan")
    public String viewLouPan(){
        return "loupan";
    }

    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }

    @GetMapping("/zufang")
    public String viewZufang(){
        return "zufang";
    }

    @GetMapping("/ershoufang")
    public String viewErshoufang(){
        return "ershoufang";
    }

    @GetMapping("/fenxi")
    public String viewFenxi(){
        return "fenxi";
    }

    @GetMapping("/zoushi")
    public String viewZoushi(){
        return "zoushi";
    }


    //用户相关的控制器

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/registerpost",method = RequestMethod.POST)
    public @ResponseBody boolean registerpost(User user){
        return userService.register(user);
    }

    //用户激活
    @RequestMapping(value = "/activeuser",method = RequestMethod.GET)
    public @ResponseBody String sendMail(String code){
        boolean b = userService.activeUser(code);
        if (b == true){
            return "激活成功,点击登录: http://localhost:8080/login";
        }else {
            return "激活失败,重新注册: http://localhost:8080/register";
        }
    }

    @RequestMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

    @RequestMapping("/loginpost")
    public @ResponseBody Map<String, Object> loginPost(String email, String password, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        if (userService.authentication(email,password)) {
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, email);
            map.put("success", true);
            map.put("message", "登录成功");
            return map;
        }
        map.put("success", false);
        map.put("message", "密码错误");
        return map;
    }

    @GetMapping("/userinfo")
    public @ResponseBody String userNickName(HttpSession session) {
        String email = (String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        return userService.nickname(email);
    }

    @GetMapping("/reset")
    public String resetPassword(HttpSession session) {
        return "reset";
    }

    @GetMapping("/resetpost")
    public @ResponseBody String resetPasswordpost(HttpSession session) {
        String email = (String) session.getAttribute(WebSecurityConfig.SESSION_KEY);
        return userService.nickname(email);
    }
}
