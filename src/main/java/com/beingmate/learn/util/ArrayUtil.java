package com.beingmate.learn.util;

/***
 * @author yfeng
 * @date 2018-06-07 12:47
 */
public class ArrayUtil {
    public static void swap(int[] inputArray, int i, int j) {
        if (i == j) {
            return;
        }
        int jVal = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = jVal;
    }

    public static void swap(Long[] inputArray, int i, int j) {
        if (i == j) {
            return;
        }
        Long jVal = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i] = jVal;
    }

    public static void cover(int[] newData, int[] targetData, int firstStartIndex) {
        for (int val : newData) {
            targetData[firstStartIndex++] = val;
        }
    }
}