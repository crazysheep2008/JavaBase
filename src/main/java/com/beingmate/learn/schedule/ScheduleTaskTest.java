package com.beingmate.learn.schedule;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/***
 * @author yfeng
 * @date 2018-04-19 12:52
 */
public class ScheduleTaskTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(3);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("------------");
            }
        };
        executorService.schedule(task, 3, TimeUnit.MINUTES);
    }
}
