package com.beingmate.learn.concurrent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * @author yfeng
 * @date 2018-06-24 17:20
 */
public class MutThreadFileWrite {
    private static int threadsNum = 10;

    private static CyclicBarrier cb = new CyclicBarrier(threadsNum + 1);
    private static CountDownLatch cdl = new CountDownLatch(threadsNum);
    private static Runnable task = () -> {
        try {
            FileWriter  fileWriter = new FileWriter(new File("D://logs//nutil_threads.log"));
            String threadName = Thread.currentThread().getName();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cb.await();
            for (int i = 0; i < 3000; i++) {
                String msg = String.format("%s %s print a new message\n", threadName, sdf.format(new Date()));
                fileWriter.append(msg);
               // TimeUnit.MICROSECONDS.sleep(random.nextInt(5));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cdl.countDown();
        }

    };

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(threadsNum);
        for (int i = 0; i < threadsNum; i++) {
            executorService.submit(task);
        }

        try {
            cb.await();
            cdl.await();
            System.out.println("完成!!!!!!!!!!!!!!!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
