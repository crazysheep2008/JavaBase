package com.beingmate.learn.spring.tag;

import com.alibaba.fastjson.JSON;
import com.beingmate.learn.spring.tag.model.AopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * @auth yfeng
 * @create 2017-04-22 21:29
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-customer-tag.xml");
        AopConfig aopConfig = (AopConfig) ac.getBean("logConfig");
        System.out.println(JSON.toJSONString(aopConfig, true));
    }
}
