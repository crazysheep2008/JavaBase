package com.beingmate.learn.algorithm.leetcode.heap.max_k;

public class SimpleMaxK extends AbstractMaxK {
    private int minIndex = 0;

    public SimpleMaxK(int topK) {
        super(topK);
    }

    @Override
    public String name() {
        return "简单";
    }

    private void resetMinIndex() {
        if (itemCount == 1) {
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            if (result[i] < result[minIndex]) {
                minIndex = i;
            }
        }
    }

    @Override
    public void addNewItem(Long num) {
        if (itemCount < result.length) {
            result[itemCount++] = num;
            resetMinIndex();
            return;
        }

        if (num < result[minIndex]) {
            return;
        }

        result[minIndex] = num;
        resetMinIndex();
    }
}
