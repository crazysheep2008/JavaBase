package com.beingmate.learn.algorithm.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/***
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 * @author yfeng
 * @date 2018-06-21 23:02
 */
public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = nums[i];
            indexMap.put(val, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            int deuceValue = target - curVal;
            Integer deduceIndex = indexMap.get(deuceValue);
            if (deduceIndex != null && deduceIndex.intValue() != i) {
                result[0] = i;
                result[1] = deduceIndex;
            }
        }
        return result;
    }
}
