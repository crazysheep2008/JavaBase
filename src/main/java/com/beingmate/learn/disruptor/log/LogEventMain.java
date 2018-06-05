package com.beingmate.learn.disruptor.log;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/***
 * @author yfeng
 * @date 2018-04-11 19:55
 */
public class LogEventMain {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Consumer-Thread");
            }
        };
        EventFactory<LogEvent> eventFactory = new LogEventFactory();
        int ringBufferSize = 4;
        Disruptor<LogEvent> disruptor = new Disruptor<LogEvent>(
                eventFactory, ringBufferSize,
                threadFactory, ProducerType.SINGLE,
                new SleepingWaitStrategy());

        disruptor.handleEventsWith(new LogEventHandler());
        disruptor.start();

        LogEventProducer producer = new LogEventProducer(disruptor.getRingBuffer());

        for (int i = 0; i < 20; i++) {
            producer.publishEvent(i);
        }
    }
}