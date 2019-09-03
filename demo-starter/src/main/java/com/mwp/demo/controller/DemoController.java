package com.mwp.demo.controller;

import com.mwp.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserService userService;

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
        String res = userService.sayHelloToDemo(name);
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

    @RequestMapping("/login4user")
    public String login4user(){
        return "login4user";
    }

    @RequestMapping(value = "/login4info",method = RequestMethod.POST)
    @ResponseBody
    public String login4info(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        logger.info("获取到的用户信息为:userName="+userName+",password="+password);
        userService.insert(userName,password);
        return "ok";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
