package com.zl.service.impl;

import com.zl.domain.User;
import com.zl.service.UserService;

import java.util.Date;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserByUSerName(String userName) {
        User user=null;
        switch (userName){
            case "zhangsan":
                user=new User(1,"zhangsan","b106dc6352e5ec1f8aafd8c406d34d92",new Date());
                break;
            case "lisi":
                user=new User(2,"lisi","1234",new Date());
                break;
            case "wangwu":
                user=new User(3,"wangwu","12345",new Date());
                break;
        }
        return user;
    }
}
