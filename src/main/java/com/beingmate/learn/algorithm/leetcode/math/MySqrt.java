package com.beingmate.learn.algorithm.leetcode.math;

public class MySqrt {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x / 2 + 1;
        int res = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sqr = mid * mid;
            if (sqr == x) {
                return sqr;
            }
            if (sqr > x) {
                return sqr;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
