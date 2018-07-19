package com.beingmate.learn.base.schedule;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * @author yfeng
 * @date 2018-04-19 12:52
 */
public class ScheduleTaskTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable task1 = () -> {
            try {
                System.out.println("Task1 尝试获取锁");
                lock.lockInterruptibly();
                for (int i = 0; i < 100; i++) {
                    System.out.println("Task1 .....运行");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException .... task1");
            } finally {
                System.out.println("Task1 unlock");
                lock.unlock();
            }
            System.out.println("----- task1 结束");
        };
        Runnable task2 = () -> {
            try {
                System.out.println("Task2 尝试获取锁");
                lock.lock();
                for (int i = 0; i < 100; i++) {
                    System.out.println("Task2 .....运行");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException .... task2");
            } finally {
                System.out.println("Task2 unlock");
                lock.unlock();
            }
            System.out.println("----- task2 结束");
        };

        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(1);

        System.out.println("================================");
        //executorService.schedule(task1, 2, TimeUnit.SECONDS);
        executorService.schedule(task2, 5, TimeUnit.SECONDS);

        Thread thread = new Thread(task1);
        thread.start();

        try {
            Thread.sleep(7000);
            thread.interrupt();
        }catch (Exception ex){

        }
    }
}
