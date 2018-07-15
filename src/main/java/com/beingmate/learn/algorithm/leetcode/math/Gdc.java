package com.beingmate.learn.algorithm.leetcode.math;

public class Gdc {

    public static int gdc(int a, int b) {
        if (a == b) {
            return a;
        }

        if (a < b) {
            return gdc(b, a);
        }
        // a > b
        if (b <= 3) {
            return b;
        }

        int mod = a % b;
        if (mod == 0) {
            return b;
        }
        return gdc(b, mod);
    }
}
