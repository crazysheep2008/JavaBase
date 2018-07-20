package com.beingmate.learn.algorithm.leetcode.array;

import com.alibaba.fastjson.JSON;

import java.util.*;

/****
 * https://leetcode-cn.com/problems/4sum/description/
 */
public class FourNumSum {

    class Pair {
        int l, r;

        public Pair(int v1, int v2) {
            this.l = v1;
            this.r = v2;
        }

        public int sum() {
            return l + r;
        }
    }

    public List<Integer> buildResults(Pair p1, Pair p2) {
        List<Integer> res = new ArrayList<>();
        res.add(p1.l);
        res.add(p1.r);
        res.add(p2.l);
        res.add(p2.r);
        return res;
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{1, 0, -1, 0, -2, 2};
        FourNumSum fns = new FourNumSum();
        List<List<Integer>> datas = fns.fourSum(inputs, 0);
        System.out.println(JSON.toJSONString(datas));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> datas = new ArrayList();
        if (nums == null || nums.length < 4) {
            return datas;
        }
        int numLimit = 4;
        List<Pair> outPairs = new ArrayList<>();

        for (int i = 0; i < nums.length - numLimit + 1; i++) {
            for (int j = i + 1; j < nums.length - numLimit + 2; j++) {
                Pair p = new Pair(nums[i], nums[j]);
                outPairs.add(p);
                Map<Integer, Pair> restMap = new HashMap();
                for (int h = j + 1; h < nums.length - 1; h++) {
                    for (int k = h + 1; k < nums.length; k++) {
                        Pair p2 = new Pair(nums[h], nums[k]);
                        restMap.put(p2.sum(), p2);
                    }
                }
                Pair restPair = restMap.get(target - p.sum());
                if (restPair != null) {
                    datas.add(buildResults(p, restPair));
                }
            }
        }
        return datas;
    }
}
