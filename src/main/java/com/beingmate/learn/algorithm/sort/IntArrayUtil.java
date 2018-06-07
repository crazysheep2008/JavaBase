package com.beingmate.learn.algorithm.sort;

/***
 * @author yfeng
 * @date 2018-06-07 12:47
 */
public class IntArrayUtil {
    public static void swap(int[] inputArray, int i, int j) {
        if (i == j) {
            return;
        }
        int jVal = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = jVal;
    }


    public static void cover(int[] newData, int[] targetData, int firstStartIndex) {
        for (int val : newData) {
            targetData[firstStartIndex++] = val;
        }
    }
}