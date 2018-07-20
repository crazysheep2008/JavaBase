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

    public List<List<Integer>> buildResults(Pair p1, List<Pair> p2s) {
        List<List<Integer>> res = new ArrayList<>();
        if (p2s.isEmpty()) {
            return res;
        }
        for (Pair p2 : p2s) {
            res.add(buildResults(p1, p2));
        }
        return res;
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
        int[] inputs = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        FourNumSum fns = new FourNumSum();
        List<List<Integer>> datas = fns.fourSum(inputs, 0);
        System.out.println(JSON.toJSONString(datas));
    }

    private boolean checkContinsAndAdd(Set<Integer> oneSet, int val) {
        if (oneSet.contains(val)) {
            return true;
        }
        oneSet.add(val);
        return false;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> datas = new ArrayList();
        if (nums == null || nums.length < 4) {
            return datas;
        }
        Arrays.sort(nums);
        List<Pair> outPairs = new ArrayList<>();
        Set<Integer> oneSet = new HashSet<>();
        loopi:
        for (int i = 0; i < nums.length - 3; i++) {
            int iVal = nums[i];
            if (checkContinsAndAdd(oneSet, iVal)) {
                continue loopi;
            }

            Set<Integer> jSet = new HashSet<>();
            loopj:
            for (int j = i + 1; j < nums.length - 2; j++) {
                int jVal = nums[j];
                if (checkContinsAndAdd(jSet, jVal)) {
                    continue loopj;
                }
                Pair p = new Pair(iVal, nums[j]);
                outPairs.add(p);


                Set<Integer> hSet = new HashSet<>();
                Map<Integer, List<Pair>> restMap = new HashMap();
                looph:
                for (int h = j + 1; h < nums.length - 1; h++) {
                    int hVal = nums[h];
                    if (checkContinsAndAdd(hSet, hVal)) {
                        continue looph;
                    }

                    Set<Integer> kSet = new HashSet<>();
                    loopk:
                    for (int k = h + 1; k < nums.length; k++) {
                        int kVal = nums[k];
                        if (checkContinsAndAdd(kSet, kVal)) {
                            continue loopk;
                        }
                        Pair p2 = new Pair(hVal, kVal);
                        List<Pair> ps = restMap.get(p2.sum());
                        if (ps == null) {
                            ps = new ArrayList<>();
                            restMap.put(p2.sum(), ps);
                        }
                        ps.add(p2);
                    }
                }
                List<Pair> restPairs = restMap.get(target - p.sum());
                if (restPairs != null) {
                    datas.addAll(buildResults(p, restPairs));
                }
            }
        }
        return datas;
    }
}
