package com.beingmate.learn.algorithm.sort;

import com.beingmate.learn.util.ArrayUtil;

/***
 * @author yfeng
 * @date 2018-06-12 13:01
 */
public class QuickSort extends AbstractSort {
    @Override
    String algorithmName() {
        return "快速";
    }

    @Override
    void doSort(int[] inputArray) {
        if (inputArray == null) {
            return;
        }
        if (inputArray.length <= 1) {
            return;
        }
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private void quickSort(int[] inputArray, int start, int end) {
        if (start >= end) {
            return;
        }
        if (start + 1 == end) {
            if (inputArray[start] > inputArray[end]) {
                ArrayUtil.swap(inputArray, start, end);
            }
            return;
        }
        int curIndex = start;
        boolean rightPos = true;
        int leftIndex = start + 1;
        int rightIndex = end;
        while (leftIndex < rightIndex) {
            if (rightPos) {
                //左坑右挖
                if (inputArray[curIndex] > inputArray[rightIndex]) {
                    ArrayUtil.swap(inputArray, curIndex, rightIndex);
                    curIndex = rightIndex;
                    //调整方向
                    rightPos = false;
                } else {
                    rightIndex--;
                }
            } else {
                //右坑左挖
                if (inputArray[leftIndex] > inputArray[curIndex]) {
                    ArrayUtil.swap(inputArray, leftIndex, curIndex);
                    curIndex = leftIndex;
                    //调整方向
                    rightPos = true;
                } else {
                    leftIndex++;
                }
            }
        }

        //分治处理两边
        quickSort(inputArray, start, curIndex - 1);
        quickSort(inputArray, curIndex + 1, end);
    }
}