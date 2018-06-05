package com.beingmate.learn.spring.tag;

import com.beingmate.learn.spring.tag.parser.AopConfigBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/***
 * @auth yfeng
 * @create 2017-04-22 21:34
 */
public class AopNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("aopConfig", new AopConfigBeanDefinitionParser());
    }
}