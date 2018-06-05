package com.beingmate.learn.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/***
 * @author yfeng
 * @date 2018-03-17 13:35
 */
public class InputLimitTest {
    public static void main(String[] args) {
        //每秒2个令牌
        RateLimiter rateLimiter = RateLimiter.create(2);
        rateLimiter.acquire();
        List<Runnable> tasks = new ArrayList<Runnable>();
        for (int i = 1; i <= 100; i++) {
            tasks.add(new UserRequest(i, rateLimiter));
        }
        int threadSize = 4;
        BlockingQueue queue = new ArrayBlockingQueue<Runnable>(100);
        Executor executor = new ThreadPoolExecutor(threadSize, threadSize, 1L, TimeUnit.MILLISECONDS, queue);
        for (Runnable task : tasks) {
            executor.execute(task);
        }
    }

    @AllArgsConstructor
    @Data
    private static class UserRequest implements Runnable {
        private int id;
        private RateLimiter rateLimiter;

        @Override
        public void run() {
            /**
             * 同步阻塞模式 rateLimiter.acquire();
             */
            boolean acq = rateLimiter.tryAcquire(1, 2, TimeUnit.SECONDS);
            if (acq) {
                runJob();
            } else {
                System.out.println(id + " - fail");
            }
        }

        private void runJob() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(new Date()) + " - " + id);
        }


    }
}
