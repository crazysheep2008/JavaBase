package com.beingmate.learn.concurrent.disruptor.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author yfeng
 * @date 2018-04-11 19:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogEvent {
    private Integer value;
}