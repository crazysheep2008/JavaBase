package com.beingmate.learn.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        Runnable task = new Runnable() {
            public void run() {
                try {
                    lock.lockInterruptibly();

                    for (int i = 1; i < Integer.MAX_VALUE; i++) {
                        /*System.out.println("doing ........");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.interrupted();
                            System.out.println("======sleep Exception========");
                        }*/
                        System.out.print(".");
                        if (i % 10000 == 0){
                            System.out.println();
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("==============");
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t = new Thread(task);
        t.start();

        Thread.sleep(100);
        t.interrupt();

       t.join();
    }
}
