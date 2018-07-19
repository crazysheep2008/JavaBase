package com.beingmate.learn.algorithm.partition;

import com.alibaba.fastjson.JSON;

/***
 *  https://leetcode-cn.com/problems/reverse-pairs/description/
 * @author yfeng
 * @date 2018-07-10 20:06
 */
public class WarReverse {
    public static void main(String[] args) {
        WarReverse wr = new WarReverse();
        int[] inputs = new int[]{1, 3, 2, 3, 1};
        System.out.println(wr.reversePairs(inputs));
        System.out.println(JSON.toJSONString(inputs));
    }

    public int reversePairs(int[] nums) {
        return mergeReversePairs(nums, 0, nums.length - 1);
    }

    private void swap(int[] datas, int i, int j) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    private int mergeReversePairs(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftCount = mergeReversePairs(nums, left, mid);
        int rightCount = mergeReversePairs(nums, mid + 1, right);

        int reverseCount = 0;

        int leftIndex = left;
        int rightIndex = mid + 1;

        return reverseCount + leftCount + rightCount;
    }
}