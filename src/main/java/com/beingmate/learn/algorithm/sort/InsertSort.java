package com.beingmate.learn.algorithm.sort;

/***
 * @author yfeng
 * @date 2018-06-11 12:33
 */
public class InsertSort extends AbstractSort {
    @Override
    String algorithmName() {
        return "插入";
    }

    @Override
    void doSort(int[] inputArray) {
        if (inputArray == null || inputArray.length <= 1) {
            return;
        }
        int inputLen = inputArray.length;
        for (int i = 1; i < inputLen; i++) {
            insertSortItem(inputArray, i);
        }
    }

    private void insertSortItem(int[] inputArray, int curIndex) {
        for (int i = curIndex - 1; i >= 0; i--) {
            if (inputArray[i] > inputArray[curIndex]) {
                IntArrayUtil.swap(inputArray, i, curIndex);
                curIndex = i;
            }
        }
    }
}