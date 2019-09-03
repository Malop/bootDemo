package com.mwp.demo.service.impl;

import com.mwp.demo.mapper.UserMapper;
import com.mwp.demo.pojo.UserInfo;
import com.mwp.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public String sayHelloToDemo(String name) {
        if(StringUtils.isBlank(name)){
            name = "mwp";
        }
        UserInfo user = userMapper.selectByName(name);
        if(user == null){
            return "there is no one in the db!";
        }
        return "Hello!" + user.getId()+"-"+user.getUserName();
    }

    @Override
    public void insert(String userName, String password) {
        userMapper.insert(userName,password);
    }
}
