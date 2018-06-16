package com.beingmate.learn.base.pid;

import java.lang.management.ManagementFactory;

/***
 * @author yfeng
 * @date 2018-04-13 18:38
 */
public class JVMTest {
    public static void main(String[] args) throws Exception {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        System.out.println(">>>>>> pid : " + pid);
    }

    private long update(long val){
        val = val + 1;
        return val;
    }
}