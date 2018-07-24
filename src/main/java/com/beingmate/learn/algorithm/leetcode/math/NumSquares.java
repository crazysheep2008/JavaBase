package com.beingmate.learn.algorithm.leetcode.math;

import java.util.TreeMap;

public class NumSquares {
    public static void main(String[] args) {
        NumSquares ns = new NumSquares();
        System.out.println();
    }

    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        TreeMap<Integer, Integer> sqrMap = new TreeMap<>();
        int num = 1;
        while (true) {
            int square = num * num;
            if (square > n) {
                break;
            }
            sqrMap.put(square, num);
            num++;
        }
        return 0;
    }
}
