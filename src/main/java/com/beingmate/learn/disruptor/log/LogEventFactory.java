package com.beingmate.learn.disruptor.log;

import com.lmax.disruptor.EventFactory;

/***
 * @author yfeng
 * @date 2018-04-18 17:09
 */
public class LogEventFactory implements EventFactory<LogEvent> {

    @Override
    public LogEvent newInstance() {
        return new LogEvent();
    }
}
