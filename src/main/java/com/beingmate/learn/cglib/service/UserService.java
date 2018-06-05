package com.beingmate.learn.cglib.service;

import java.util.Date;

/***
 * @auth yfeng
 * @create 2017-04-22 20:40
 */
public interface UserService {
    String getDefaultAvatar(String uid);

    boolean hasMobile(String uid);

    Date lastLogin(String uid);
}