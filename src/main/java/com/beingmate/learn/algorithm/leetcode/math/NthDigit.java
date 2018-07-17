package com.beingmate.learn.algorithm.leetcode.math;

/****
 * https://leetcode-cn.com/problems/nth-digit/description/
 */
public class NthDigit {
    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        System.out.println(nd.findNthDigit(2147483647));
    }

    public int findNthDigit(int n) {
        //当前数字位数
        int numLevel = 1;

        //当前位数的起始值
        long levelStart = 1;

        //最大数字量
        long levelCount = 9;

        long targetN = n;
        //按照位数循环，先处理1位数
        while (targetN > levelCount * numLevel) {
            targetN = targetN - levelCount * numLevel;
            numLevel++;
            levelStart *= 10;
            levelCount *= 10;
        }

        long targetNum = levelStart + (targetN - 1) / numLevel;
        int digIndex = (int) (targetN - 1) % numLevel;

        String str = Long.toString(targetNum);
        return Character.getNumericValue(str.charAt(digIndex));
    }
}
