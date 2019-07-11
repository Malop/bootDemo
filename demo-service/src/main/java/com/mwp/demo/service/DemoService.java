package com.mwp.demo.service;

import org.apache.ibatis.annotations.Param;

public interface DemoService {

    String sayHelloToDemo(String name);

    void insert(@Param(value = "userName") String userName,
                @Param(value = "password")String password);
}
