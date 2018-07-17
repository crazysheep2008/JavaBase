package com.beingmate.learn.algorithm.leetcode.rand;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/****
 *
 * https://leetcode-cn.com/problems/shuffle-an-array/description/
 *
 */
public class ShullfeArray {
    private int[] nums;
    private Random rand = new Random();

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ShullfeArray obj = new ShullfeArray(datas);
        System.out.println(JSON.toJSONString(obj.shuffle()));
        System.out.println(JSON.toJSONString(obj.shuffle()));
        System.out.println(JSON.toJSONString(obj.shuffle()));
        System.out.println(JSON.toJSONString(obj.shuffle()));
        System.out.println(JSON.toJSONString(obj.shuffle()));
        System.out.println(JSON.toJSONString(obj.shuffle()));
    }

    public ShullfeArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] results = new int[nums.length];
        int[] datas = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            datas[i] = nums[i];
        }

        int dataRest = datas.length;
        for (int i = 0; i < datas.length; i++) {
            int randIdx = rand.nextInt(dataRest);
            int randVal = datas[randIdx];
            results[i] = randVal;
            if (randIdx != dataRest - 1) {
                datas[randIdx] = datas[dataRest - 1];
            }
            dataRest--;
        }
        return results;
    }
}
