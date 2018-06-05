package com.beingmate.learn.base;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/***
 * @author yfeng
 * @date 2018-05-23 17:37
 */
public class Base {
    public static void main(String[] args) {
        long mills = 365 * 24 * 60 * 60 * 1000L;
        System.out.println(mills);
        int[] arra1 = {2, 5, 6, 7, 8};
        int[] array2 = Arrays.copyOf(arra1, 7);
        System.out.println(JSON.toJSONString(array2));
    }
}
