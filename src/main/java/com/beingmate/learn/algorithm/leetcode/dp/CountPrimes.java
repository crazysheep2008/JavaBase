package com.beingmate.learn.algorithm.leetcode.dp;

import java.util.LinkedHashSet;
import java.util.Set;

/***
 * https://leetcode-cn.com/problems/count-primes/description/
 * @author yfeng
 * @date 2018-08-03 19:55
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        // System.out.println(cp.countPrimes1(499979));
        System.out.println(cp.countPrimes(499979));
    }

    /****
     * spend :26095 ms
     * result :41537
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        long start = System.currentTimeMillis();
        if (n <= 2) {
            return 0;
        }
        Set<Integer> priSets = new LinkedHashSet();
        int[] dp = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            if (isPrimesNum(i - 1, priSets)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println("spend :" + (System.currentTimeMillis() - start));
        return dp[n];
    }

    public boolean isPrimesNum1(int num, Set<Integer> priSets) {
        if (num == 2) {
            priSets.add(2);
            return true;
        }

        for (int priNum : priSets) {
            if (num % priNum == 0) {
                return false;
            }
        }
        priSets.add(num);
        return true;
    }


    public int countPrimes(int n) {
        long start = System.currentTimeMillis();
        if (n <= 2) {
            return 0;
        }
        int wdith = Math.max(4, n + 1);
        boolean[] fuNums = new boolean[wdith];
        fuNums[0] = true;
        fuNums[1] = true;
        fuNums[2] = false;
        fuNums[3] = false;

        Set<Integer> priSets = new LinkedHashSet<>();
        double num = 1.0d * n;
        double sqr = Math.sqrt(num);
        for (int i = 2; i <= sqr; i++) {
            if (fuNums[i]) {
                continue;
            }
            if (isPrimesNum(i, priSets)) {
                rendData(fuNums, i, n);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = fuNums[i];
            if (!flag) {
                count++;
            }
        }
        System.out.println("spend :" + (System.currentTimeMillis() - start));
        return count;
    }

    public void rendData(boolean[] flags, int priemNum, int limit) {
        for (int i = priemNum; i <= limit / 2; i++) {
            int cv = priemNum * i;
            if (cv > limit) {
                break;
            }
            flags[cv] = true;
        }
    }

    public boolean isPrimesNum(int num, Set<Integer> priSets) {
        if (num == 2) {
            priSets.add(2);
            return true;
        }

        for (int priNum : priSets) {
            if (num % priNum == 0) {
                return false;
            }
        }
        priSets.add(num);
        return true;
    }
}