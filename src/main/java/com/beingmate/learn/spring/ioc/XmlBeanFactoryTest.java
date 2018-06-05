package com.beingmate.learn.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;

/***
 * @auth yfeng
 * @create 2017-04-23 16:59
 */
public class XmlBeanFactoryTest {

    public static void main(String[] args) {
        ClassPathResource cpr = new ClassPathResource("spring-one-bean.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.loadBeanDefinitions(cpr);
        Date time = (Date) defaultListableBeanFactory.getBean("time1");
        System.out.println(time);
    }
}
