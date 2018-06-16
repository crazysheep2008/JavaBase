package com.beingmate.learn.concurrent.disruptor.log;

import com.lmax.disruptor.BatchStartAware;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.LifecycleAware;
import com.lmax.disruptor.TimeoutHandler;
import lombok.extern.slf4j.Slf4j;

/***
 * @author yfeng
 * @date 2018-04-11 19:58
 */
@Slf4j
public class LogEventHandler implements EventHandler<LogEvent>, LifecycleAware, TimeoutHandler,BatchStartAware {

    @Override
    public void onEvent(LogEvent logEvent, long sequence, boolean endOfBatch) throws Exception {
        log.info(">>>> onEvent : {}", logEvent.getValue());
    }

    @Override
    public void onStart() {
        System.out.println(Thread.currentThread().getName() + " onStart ....");
    }

    @Override
    public void onShutdown() {
        System.out.println(Thread.currentThread().getName() + " onShutdown ....");
    }

    @Override
    public void onTimeout(long sequence) throws Exception {
        System.out.println("..... onTimeout(" + sequence +  ")");
    }

    @Override
    public void onBatchStart(long batchSize) {
        System.out.println("=========== onBatchStart");
    }
}