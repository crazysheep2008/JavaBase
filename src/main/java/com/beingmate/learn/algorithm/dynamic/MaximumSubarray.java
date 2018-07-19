package com.beingmate.learn.algorithm.dynamic;

/***
 * @author yfeng
 * @date 2018-07-10 12:18
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] data = new int[]{-4, 2, -1, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(data));
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            result = Math.max(sum, result);
        }
        return result;
    }


    public int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}