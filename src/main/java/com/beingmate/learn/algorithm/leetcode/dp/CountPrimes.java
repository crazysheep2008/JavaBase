package com.beingmate.learn.algorithm.leetcode.dp;

/***
 * https://leetcode-cn.com/problems/count-primes/description/
 * @author yfeng
 * @date 2018-08-03 19:55
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(499979));
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] flags = new boolean[n + 1];

        int count = 0;
        for (boolean flag : flags) {
            if (flag) {
                count++;
            }
        }
        return count;
    }
}