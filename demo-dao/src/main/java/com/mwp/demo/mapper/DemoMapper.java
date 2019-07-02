package com.mwp.demo.mapper;

import com.mwp.demo.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface DemoMapper {
    UserInfo selectByName(String userName);
}
