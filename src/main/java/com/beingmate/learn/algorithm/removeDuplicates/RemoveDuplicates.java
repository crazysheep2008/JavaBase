package com.beingmate.learn.algorithm.removeDuplicates;

import com.alibaba.fastjson.JSON;
import com.beingmate.learn.util.SystemUtil;

import java.util.Arrays;

/**
 * 移除数组中重复元素，返回无重复素组的长度
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] inputs = SystemUtil.scanInputArray();
        System.out.println("原始输入:" + JSON.toJSONString(inputs));
        int len = removeDuplicates(inputs);
        System.out.println("去重之后:" + JSON.toJSONString(inputs));
        System.out.println("新数组长度:" + len);
    }

    public static int removeDuplicates(int[] inputs) {
        if (inputs.length <= 1) {
            return inputs.length;
        }
        Arrays.sort(inputs);

        int checkVal = inputs[0];
        int updateIndex = 1;
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] != checkVal) {
                inputs[updateIndex++] = inputs[i];
                checkVal = inputs[i];
            }
        }
        return updateIndex;
    }
}
