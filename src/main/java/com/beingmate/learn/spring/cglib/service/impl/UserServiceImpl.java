package com.beingmate.learn.spring.cglib.service.impl;

import com.beingmate.learn.spring.cglib.service.UserService;

import java.util.Date;

/***
 * @auth yfeng
 * @create 2017-04-22 20:42
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getDefaultAvatar(String uid) {
        return String.format("http://www.site.com/avatar/%s.jpg", uid);
    }

    @Override
    public boolean hasMobile(String uid) {
        if (uid.equals("zhangsan")) {
            return true;
        }
        return false;
    }
    @Override
    public Date lastLogin(String uid) {
        return new Date();
    }
}
