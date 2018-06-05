package com.beingmate.learn.algorithm.greedy.maxnum;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-06-03 22:06
 */
public class MaxNumAlg {
    public static void main(String[] args) {
        List<Long> inputs = Lists.newArrayList(20L, 12L, 4L, 9L, 91L, 8L, 82L);
        Collections.sort(inputs, (v1, v2) -> {
            Long v1v2 = Long.parseLong(Joiner.on("").join(v1, v2).toString());
            Long v2v1 = Long.parseLong(Joiner.on("").join(v2, v1).toString());
            return v2v1.compareTo(v1v2);
        });
        String val = Joiner.on("").skipNulls().join(inputs);
        System.out.println("最大拼接结果为: " + val);
    }
}