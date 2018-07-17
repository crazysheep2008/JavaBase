package com.beingmate.learn.algorithm.leetcode.recurse;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-07-12 20:46
 */
public class AllPrint {

    public static void main(String[] args) {
        int[] inputs = new int[]{1, 2, 3, 4};
        List<Integer> list = new ArrayList<>();
        for (int val : inputs) {
            list.add(val);
        }
        List<List<Integer>> datas = new AllPrint().iterateAll(list);
        System.out.println(JSON.toJSONString(datas));
    }

    public List<Integer> execludeList(List<Integer> inputs, int exeIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == exeIndex) {
                continue;
            }
            res.add(inputs.get(i));
        }
        return res;
    }

    public List<List<Integer>> iterateAll(List<Integer> inputs) {
        List<List<Integer>> curResults = new ArrayList<>();
        if (inputs.isEmpty()) {
            curResults.add(new ArrayList<>());
            return curResults;
        }
        boolean[] visitFlag = new boolean[inputs.size()];
        Arrays.fill(visitFlag, false);

        for (int i = 0; i < inputs.size(); i++) {
            if (visitFlag[i]) {
                continue;
            }
            Integer curInt = inputs.get(i);
            List<Integer> others = execludeList(inputs, i);
            List<List<Integer>> list = iterateAll(others);
            for (List<Integer> subList : list) {
                subList.add(curInt);
                curResults.add(subList);
            }
            visitFlag[i] = true;
        }
        return curResults;
    }
}
