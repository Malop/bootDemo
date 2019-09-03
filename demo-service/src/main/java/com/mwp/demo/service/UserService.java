package com.mwp.demo.service;

import com.mwp.demo.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    String sayHelloToDemo(String name);

    UserInfo getUserByName(String name);

    void insert(@Param(value = "userName") String userName,
                @Param(value = "password")String password);
}
