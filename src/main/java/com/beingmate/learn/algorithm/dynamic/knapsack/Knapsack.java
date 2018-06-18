package com.beingmate.learn.algorithm.dynamic.knapsack;

import com.alibaba.fastjson.JSON;
import lombok.Setter;

/**
 * 0-1背包问题
 */
public class Knapsack {
    @Setter
    private int[] weights;
    @Setter
    private int[] values;
    @Setter
    private int capacity;

    private int[][] result;

    private void initResult() {
        if (result != null) {
            return;
        }
        result = new int[weights.length + 1][capacity + 1];
    }

    public void caculateResult() {
        initResult();
        for (int i = 1; i <= weights.length; i++) {
            int value = values[i - 1];
            int weight = weights[i - 1];
            for (int j = 1; j <= capacity; j++) {
                if (weight > j) {
                    result[i][j] = result[i - 1][j];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - weight] + value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.setCapacity(8);
        knapsack.setWeights(new int[]{2, 3, 4, 5});
        knapsack.setValues(new int[]{3, 4, 5, 6});
        knapsack.caculateResult();
        for (int[] array : knapsack.result) {
            System.out.println(JSON.toJSONString(array));
        }

    }
}