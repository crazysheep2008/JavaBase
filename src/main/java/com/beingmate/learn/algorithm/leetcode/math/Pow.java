package com.beingmate.learn.algorithm.leetcode.math;

public class Pow {
    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2, -2147483648));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Long.toBinaryString(2147483648L));
    }

    public double myPow(double x, int n) {
        if (n >= 0 && n <= 4) {
            return optimizePow(x, n);
        }
        long nv = n;
        long target = nv > 0 ? nv : -nv;
        double val = optimizePow(x, target);
        return n < 0 ? 1.0 / val : val;
    }

    public double optimizePow(double x, long n) {
        if (n <= 4) {
            double res = 1.0;
            for (int i = 0; i < n; i++) {
                res *= x;
            }
            return res;
        }

        long div = n / 4;
        long rest = n % 4;

        return optimizePow(optimizePow(x, div), 4) * optimizePow(x, rest);
    }
}
