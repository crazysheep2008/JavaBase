package com.beingmate.learn.algorithm.leetcode.dp;

import com.alibaba.fastjson.JSON;

import java.util.TreeMap;

class MaxSqrCount {
    TreeMap<Integer, Integer> sqrMap = new TreeMap();
    boolean init = false;

    public static void main(String[] args) {
        MaxSqrCount msc = new MaxSqrCount();
        System.out.println(msc.numSquares(12));

        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int i = 1; i <= 12; i++) {
            treeMap.put(i, i);
        }
        System.out.println(JSON.toJSONString(treeMap, true));
        System.out.println(treeMap.lowerKey(15));
        System.out.println(treeMap.higherKey(7));
    }

    private void initSqrMap(int n) {
        if (init) {
            return;
        }
        int val = 1;
        while (true) {
            int sqrNum = val * val;
            sqrMap.put(sqrNum, val);
            val++;
            if (sqrNum >= n) {
                break;
            }
        }
    }

    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }

        int maxSqr = maxSqrNum(n);
        return 1 + numSquares(n - maxSqr);
    }

    private int maxSqrNum(int n) {
        if (n <= 3) {
            return n;
        }
        initSqrMap(n);
        return sqrMap.lowerKey(n + 1);
    }
}