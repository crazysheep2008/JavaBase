package com.beingmate.learn.algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class MaxSqrCount {
    TreeMap<Integer, Integer> sqrMap = new TreeMap();
    boolean init = false;

    public static void main(String[] args) {
        MaxSqrCount msc = new MaxSqrCount();
        System.out.println(msc.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //init squrs
        int base = 0;
        List<Integer> sqrs = new ArrayList<>();
        while (true) {
            int square = base * base;
            if (square > n){
                break;
            }
            dp[square] = 1;
            sqrs.add(square);
            base++;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] > 0) {
                continue;
            }
            dp[i] = minValue(dp, i, sqrs);
        }
        return dp[n];
    }

    private int minValue(int[] dp, int num, List<Integer> sqrs) {
        List<Integer> nums = new ArrayList<>();
        int lastIdx = sqrs.size() - 1;
        for (int sqrIndex = lastIdx; sqrIndex >= 1; sqrIndex--) {
            int sqrNum = sqrs.get(sqrIndex);
            if (sqrNum > num) {
                continue;
            }
            int rest = num - sqrNum;
            nums.add(dp[rest] + 1);
        }
        return Collections.min(nums);
    }
}