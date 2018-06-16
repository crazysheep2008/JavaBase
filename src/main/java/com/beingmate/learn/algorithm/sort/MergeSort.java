package com.beingmate.learn.algorithm.sort;

import com.beingmate.learn.util.ArrayUtil;

/***
 * @author yfeng
 * @date 2018-06-07 12:42
 */
public class MergeSort extends AbstractSort {
    @Override
    String algorithmName() {
        return "归并";
    }

    @Override
    void doSort(int[] inputArray) {
        if (inputArray == null) {
            throw new RuntimeException("输入数组为null");
        }
        int len = inputArray.length;
        if (len <= 1) {
            return;
        }
        mergeSort(inputArray, 0, len - 1);
    }

    /**
     * 按照小到大排序
     */
    private void mergeSort(int[] inputData, int firstStart, int secondEnd) {
        if (firstStart >= secondEnd) {
            return;
        }
        if ((firstStart + 1) == secondEnd) {
            if (inputData[firstStart] > inputData[secondEnd]) {
                ArrayUtil.swap(inputData, firstStart, secondEnd);
            }
            return;
        }
        int mid = (firstStart + secondEnd) / 2;
        mergeSort(inputData, firstStart, mid, mid + 1, secondEnd);
    }

    private void mergeSort(int[] inputData, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        mergeSort(inputData, firstStart, firstEnd);
        mergeSort(inputData, secondStart, secondEnd);

        int[] tempArray = new int[secondEnd - firstStart + 1];
        int tmpIndex = 0;
        int curFirstIndex = firstStart;
        int curSecondIndex = secondStart;
        while (curFirstIndex <= firstEnd || curSecondIndex <= secondEnd) {
            if (curFirstIndex > firstEnd) {
                tempArray[tmpIndex++] = inputData[curSecondIndex++];
            } else if (curSecondIndex > secondEnd) {
                tempArray[tmpIndex++] = inputData[curFirstIndex++];
            } else if (inputData[curFirstIndex] > inputData[curSecondIndex]) {
                //第二个区间当前元素更小，则需要交换
                tempArray[tmpIndex++] = inputData[curSecondIndex++];
            } else {
                //第一个区间当前元素更小
                tempArray[tmpIndex++] = inputData[curFirstIndex++];
            }
        }

        //将排序号的数据回写到当前数组
        int coverIndex = firstStart;
        for (int val : tempArray) {
            inputData[coverIndex++] = val;
        }
    }
}