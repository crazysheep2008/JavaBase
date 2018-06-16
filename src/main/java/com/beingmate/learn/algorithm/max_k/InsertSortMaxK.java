package com.beingmate.learn.algorithm.max_k;

import com.beingmate.learn.util.ArrayUtil;

/**
 * 简单的MaxK算法，数组保存maxK元素，新进入元素比其中某个元素大，将最小元素移除，新元素放置正确位置
 */
public class InsertSortMaxK extends AbstractMaxK {

    public InsertSortMaxK(int topK) {
        super(topK);
    }

    @Override
    public String name() {
        return "插入排序方式";
    }

    private void initResult(Long num) {
        if (itemCount == 0) {
            result[itemCount++] = num;
            return;
        }

        //填充初始的k个元素
        result[itemCount++] = num;
        int newIndex = itemCount - 1;
        for (int i = itemCount - 2; i >= 0; i--) {
            if (result[i] < result[newIndex]) {
                ArrayUtil.swap(result, i, newIndex);
                newIndex = i;
            } else {
                break;
            }
        }
    }

    @Override
    public void addNewItem(Long num) {
        //填充初始的k个元素
        if (itemCount < result.length) {
            initResult(num);
            return;
        }

        //数组已经填满的情况
        if (num < result[itemCount - 1]) {
            return;
        }
        //替换掉最小的元素
        result[itemCount - 1] = num;

        //将新的元素放置到合适位置，插入排序的手段
        int curIndex = itemCount - 1;
        for (int i = itemCount - 2; i >= 0; i--) {
            if (result[i] < result[curIndex]) {
                ArrayUtil.swap(result, i, curIndex);
                curIndex = i;
            } else {
                break;
            }
        }
    }
}