package com.mwp.demo.service.impl;

import com.mwp.demo.mapper.DemoMapper;
import com.mwp.demo.pojo.UserInfo;
import com.mwp.demo.service.DemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public String sayHelloToDemo(String name) {
        if(StringUtils.isBlank(name)){
            name = "mwp";
        }
        UserInfo user = demoMapper.selectByName(name);
        return "Hello!" + user.getUserId()+"-"+user.getUserName();
    }
}
