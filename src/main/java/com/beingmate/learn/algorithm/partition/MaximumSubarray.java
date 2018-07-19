package com.beingmate.learn.algorithm.partition;

/***
 * @author yfeng
 * @date 2018-07-10 12:18
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] data = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray(data));
    }

    public int maxSubArray(int[] nums) {
        return partionStradge(nums, 0, nums.length - 1);
    }

    public int partionStradge(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (left + 1 == right) {
            int sum = nums[left] + nums[right];
            return max(nums[left], nums[right], sum);
        }

        int mid = (left + right) / 2;
        int leftMax = partionStradge(nums, left, mid - 1);
        int rightMax = partionStradge(nums, mid + 1, right);
        int midMax = nums[mid];

        //向右拓展
        int temMax = midMax;
        for (int i = mid + 1; i <= right; i++) {
            temMax = temMax + nums[i];
            if (temMax > midMax) {
                midMax = temMax;
            }
        }

        //向左拓展
        temMax = midMax;
        for (int i = mid - 1; i >= left; i--) {
            temMax = temMax + nums[i];
            if (temMax > midMax) {
                midMax = temMax;
            }
        }
        return max(midMax, leftMax, rightMax);
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