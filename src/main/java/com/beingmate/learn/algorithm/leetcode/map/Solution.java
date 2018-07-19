package com.beingmate.learn.algorithm.leetcode.map;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.Iterator;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println(new Solution().isNStraightHand(datas, 3));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || W == 0) {
            return false;
        }
        if (W == 1) {
            return true;
        }
        int len = hand.length;
        if (len % W > 1) {
            return false;
        }
        LinkedMap<Integer, Integer> countMap = buildCountMap(hand);
        int group = len / W;
        int width = len / group;
        for (int g = 0; g < group; g++) {
            if (!findGroup(countMap, width)) {
                return false;
            }
        }
        return true;
    }

    private boolean findGroup(LinkedMap<Integer, Integer> countMap, int width) {
        Iterator<Map.Entry<Integer, Integer>> iter = countMap.entrySet().iterator();

        int[] nums = new int[width];
        for (int i = 0; i < width; i++) {
            nums[i] = iter.next().getValue();
        }
        if (!check(nums)) {
            return false;
        }
        Iterator<Map.Entry<Integer, Integer>> deduceIter = countMap.entrySet().iterator();
        for (int i = 1; i < width; i++) {
            Map.Entry<Integer, Integer> entry = deduceIter.next();
            Integer count = entry.getValue();
            if (count == 0) {
                return false;
            }
            entry.setValue(count - 1);
        }
        Iterator<Map.Entry<Integer, Integer>> removeIter = countMap.entrySet().iterator();
        while (removeIter.hasNext()) {
            Map.Entry<Integer, Integer> entry = deduceIter.next();
            Integer count = entry.getValue();
            if (count == 0) {
                iter.remove();
            }
        }
        return true;
    }


    private boolean check(int[] datas) {
        for (int i = 1; i < datas.length; i++) {
            int v1 = datas[i - 1];
            int v2 = datas[i];
            if ((v1 + 1) != v2) {
                return false;
            }
        }
        return true;
    }

    private LinkedMap<Integer, Integer> buildCountMap(int[] hand) {
        LinkedMap<Integer, Integer> countMap = new LinkedMap();
        for (Integer val : hand) {
            Integer cout = countMap.get(val);
            if (cout == null) {
                countMap.put(val, 1);
            } else {
                countMap.put(val, cout + 1);
            }
        }
        return countMap;
    }
}