package com.beingmate.learn.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/***
 * @auth yfeng
 * @create 2017-04-23 17:24
 */
public class DebugClient {
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-one-bean.xml");
        Date time = ac.getBean(Date.class);
        System.out.println(time);
    }
}
