package com.mwp.demo.mapper;

import com.mwp.demo.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    UserInfo selectByName(String userName);

    void insert(String userName,String password);
}
