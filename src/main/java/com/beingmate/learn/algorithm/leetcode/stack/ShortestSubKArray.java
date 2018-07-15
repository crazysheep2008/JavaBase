package com.beingmate.learn.algorithm.leetcode.stack;

/*****
 *
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/description/
 *
 */
public class ShortestSubKArray {

    public static void main(String[] args) {
        ShortestSubKArray ss = new ShortestSubKArray();
        int[] datas = new int[]{2, -1, 2};

        System.out.println(ss.shortestSubarray(datas, 3));
    }

    public int shortestSubarray(int[] A, int K) {


        int left = 0;
        int sum = 0;
        int right = A.length - 1;

        while (left < right) {

        }

        return 1;
    }
}
