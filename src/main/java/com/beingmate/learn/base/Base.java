package com.beingmate.learn.base;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 * @author yfeng
 * @date 2018-05-23 17:37
 */
public class Base {
    public static void main(String[] args) {
        List<String> vals = new ArrayList<>();
        vals.add("A");
        vals.add("3");
        vals.add("D");
        vals.add("Z");
        vals.add("B");
        vals.add("2");
        vals.add("4");


        long loopCount = 1000 * 1000 * 10;
        Stopwatch stopwatch = Stopwatch.createStarted();
        int val = 8;
        for (long i = 0L; i < loopCount; i++) {
            long f = i / 2;
        }
        long spend = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("/ spend:" + spend + "ms");

        stopwatch.reset().start();
        for (long i = 0L; i < loopCount; i++) {
            long f = i >> 1;
        }
        long spend2 = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(">>> spend:" + spend2 + "ms");
    }
}
