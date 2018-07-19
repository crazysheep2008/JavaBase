package com.beingmate.learn.algorithm.leetcode.recurse;

import java.util.ArrayList;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-07-12 23:32
 */
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int val : nums) {
            list.add(val);
        }
        int sum = sum(list);
        if (k % sum != 0) {
            return false;
        }
        int seg = sum / k;
        return checkPartitionKSubsets(list, seg, k);
    }

    private int sum(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public boolean checkPartitionKSubsets(List<Integer> nums, int seg, int k) {
        return false;
    }
}