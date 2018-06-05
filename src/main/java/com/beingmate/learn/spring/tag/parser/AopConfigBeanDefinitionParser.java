package com.beingmate.learn.spring.tag.parser;

import com.beingmate.learn.spring.tag.model.AopConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/***
 * @auth yfeng
 * @create 2017-04-22 21:27
 */
public class AopConfigBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    public Class<?> getBeanClass(Element element) {
        return AopConfig.class;
    }

    @Override
    public void doParse(Element element, BeanDefinitionBuilder builder) {
        String logFile = element.getAttribute("logFile");
        String logPerformance = element.getAttribute("logPerformance");
        String logReqSource = element.getAttribute("logReqSource");

        if (StringUtils.hasText(logFile)) {
            builder.addPropertyValue("logFile", logFile);
        }
        if (StringUtils.hasText(logPerformance)) {
            builder.addPropertyValue("logPerformance", Boolean.parseBoolean(logPerformance));
        }
        if (StringUtils.hasText(logReqSource)) {
            builder.addPropertyValue("logReqSource", Boolean.parseBoolean(logReqSource));
        }
    }
}