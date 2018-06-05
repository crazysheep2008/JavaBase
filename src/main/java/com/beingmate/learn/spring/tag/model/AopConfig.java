package com.beingmate.learn.spring.tag.model;

import lombok.Data;

/***
 * @auth yfeng
 * @create 2017-04-22 21:23
 */
@Data
public class AopConfig {
    private boolean logPerformance;
    private boolean logReqSource;
    private String logFile;
}