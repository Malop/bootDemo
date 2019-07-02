package com.mwp.demo.controller;

import com.mwp.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Value("${user.info}")
    private String userInfo;

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String hello(){
        return "this is the response code:"+userInfo;
    }

    @RequestMapping("/getUserFromDB")
    @ResponseBody
    public String getUserInfo(String name){
        String res = demoService.sayHelloToDemo(name);
        return res;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/cards")
    public String cards(){
        return "cards";
    }

    @RequestMapping("/charts")
    public String charts(){
        return "charts";
    }

    @RequestMapping("/tables")
    public String tables(){
        return "tables";
    }

    @RequestMapping("/navbar")
    public String navbar(){
        return "navbar";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "forgetPassword";
    }

    @RequestMapping("/blank")
    public String blank(){
        return "blank";
    }

}
