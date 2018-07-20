package com.beingmate.learn.algorithm.leetcode.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/****
 * https://leetcode-cn.com/problems/4sum/description/
 */
public class FourNumSum {
    public static void main(String[] args) {
        int[] inputs = new int[]{1, 0, -1, 0, -2, 2};
        FourNumSum fns = new FourNumSum();
        List<List<Integer>> datas = fns.fourSum(inputs, 0);
        System.out.println(JSON.toJSONString(datas));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> datas = new ArrayList();
        if (nums == null || nums.length == 0) {
            return datas;
        }
        List<Integer> inputs = new ArrayList();
        for (int v : nums) {
            inputs.add(v);
        }
        return findNums(inputs, target, 4);
    }

    private List<List<Integer>> findNums(List<Integer> nums, int target, int numCount) {
        List<List<Integer>> results = new ArrayList();
        if (nums.isEmpty() || nums.size() < numCount) {
            return results;
        }
        if (numCount == 1){
            List<Integer> subList = new ArrayList();
            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);
               if (target == num){
                   subList.add(num);
                   results.add(subList);
                   return results;
               }
            }
            return results;
        }
        if (numCount == nums.size()) {
            List<Integer> subList = new ArrayList();
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);
                sum = sum + num;
                subList.add(num);
            }
            if (sum == target) {
                results.add(subList);
            }
            return results;
        }

        Set<Integer> numSet = new HashSet();
        for (int i = 0; i < nums.size() - numCount + 1; i++) {
            int curNum = nums.get(i);
            if (numSet.contains(curNum)) {
                continue;
            }
            numSet.add(curNum);

            int rest = target - curNum;
            List<List<Integer>> subNums = findNums(nums.subList(i + 1, nums.size()), rest, numCount - 1);
            if (subNums.isEmpty()) {
                continue;
            }
            for (List<Integer> subList : subNums) {
                subList.add(curNum);
                results.add(subList);
            }
        }
        return results;
    }

}
