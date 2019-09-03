package com.mwp.demo.service;

import com.mwp.demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //从库中获取用户
        UserInfo userInfo = userService.getUserByName(userName);
        if(userInfo == null){
            throw new UsernameNotFoundException("the name not found");
        }

        //定义权限列表
        List<GrantedAuthority> authorityList = new ArrayList();
        authorityList.add(new SimpleGrantedAuthority("ROLE_"+userInfo.getRole().name()));

        User userDetails = new User(userInfo.getUserName(),
                new BCryptPasswordEncoder().encode(userInfo.getPassword()),authorityList);
        return userDetails;
    }
}
