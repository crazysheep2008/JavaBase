package com.beingmate.learn.algorithm.dynamic.knapsack;

import lombok.Data;

/***
 * 0-1背包问题
 * @author yfeng
 * @date 2018-06-14 22:23
 */
@Data
public class Knapsack {
    /**
     * 编号
     */
    private String num;
    /**
     * 重量
     */
    private int weight;
    /**
     * 价值
     */
    private int value;
}
