package com.beingmate.learn.concurrent.disruptor.log;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/***
 * @author yfeng
 * @date 2018-04-18 17:23
 */
@Slf4j
public class LogEventCleaner implements EventHandler<LogEvent> {

    @Override
    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
        log.info("clean logEvent: {}", event.getValue());
        event.setValue(null);
    }
}
