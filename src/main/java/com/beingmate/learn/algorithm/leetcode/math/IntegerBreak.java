package com.beingmate.learn.algorithm.leetcode.math;

/**
 * https://leetcode-cn.com/problems/integer-break/description/
 * 可考虑使用动态规划
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int mod = n % 3;
        switch (mod) {
            case 0:
                return (int) Math.pow(3, n / 3);
            case 1:
                return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
            default:
                return 2 * (int) Math.pow(3, (n - 2) / 3);
        }
    }
}