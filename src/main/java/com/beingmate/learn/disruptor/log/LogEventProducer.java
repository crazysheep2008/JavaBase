package com.beingmate.learn.disruptor.log;

import com.lmax.disruptor.RingBuffer;
import lombok.AllArgsConstructor;

/***
 * @author yfeng
 * @date 2018-04-11 19:54
 */
@AllArgsConstructor
public class LogEventProducer {
    private RingBuffer<LogEvent> ringBuffer;

    public void publishEvent(Integer value) {
        long sequence = ringBuffer.next();
        try {
            LogEvent logEvent = ringBuffer.get(sequence);
            logEvent.setValue(value);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
