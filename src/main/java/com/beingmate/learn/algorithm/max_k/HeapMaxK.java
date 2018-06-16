package com.beingmate.learn.algorithm.max_k;

import com.beingmate.learn.util.ArrayUtil;

public class HeapMaxK extends AbstractMaxK {

    public HeapMaxK(int topK) {
        super(topK);
    }

    @Override
  public   String name() {
        return "小顶堆方式";
    }

    private int pIndex(int cIndex) {
        return (cIndex - 1) / 2;
    }

    private int leftChildIndex(int cIndex) {
        return 2 * cIndex + 1;
    }

    private int rightChildIndex(int cIndex) {
        return 2 * cIndex + 2;
    }


    private void insert(Long num) {
        //放置到最后一个位置
        result[itemCount++] = num;
        if (itemCount == 1) {
            return;
        }
        popUp();
    }

    private void popUp() {
        int cIndex = itemCount - 1;
        int pIndex = pIndex(cIndex);
        while (pIndex >= 0) {
            if (result[cIndex] >= result[pIndex]) {
                return;
            }
            ArrayUtil.swap(result, cIndex, pIndex);
            cIndex = pIndex;
            pIndex = pIndex(cIndex);
        }
    }

    private void removeMin() {
        //首尾交换，并将尾部设置为空
        ArrayUtil.swap(result, 0, --itemCount);
        result[itemCount] = null;

        //开始下滤
        int cIndex = 0;
        int rChildIndex = rightChildIndex(cIndex);
        int lChildIndex = leftChildIndex(cIndex);
        int lastIndex = itemCount - 1;
        while (rChildIndex < itemCount || lChildIndex < itemCount) {
            if (rChildIndex > lastIndex) {
                if (result[lChildIndex] < result[cIndex]) {
                    ArrayUtil.swap(result, cIndex, lChildIndex);
                }
                return;
            }

            if (result[lChildIndex] >= result[cIndex] && result[rChildIndex] >= result[cIndex]) {
                return;
            }

            if (result[lChildIndex] <= result[rChildIndex]) {
                ArrayUtil.swap(result, cIndex, lChildIndex);
                cIndex = lChildIndex;
            } else {
                ArrayUtil.swap(result, cIndex, rChildIndex);
                cIndex = rChildIndex;
            }

            rChildIndex = rightChildIndex(cIndex);
            lChildIndex = leftChildIndex(cIndex);
        }
    }

    @Override
    public void addNewItem(Long num) {
        //填充初始的k个元素
        if (itemCount < result.length) {
            insert(num);
            return;
        }
        /*System.out.println("--------------------");
        System.out.print("准备加入: ");
        System.out.print(JSON.toJSONString(result));
        System.out.println("  加入：" + num);*/

        //新元素大于最小元素，直接跳过
        if (result[0] >= num) {
            //  System.out.println("无法加入>> ");
            return;
        }
        //移除最小元素
        removeMin();
        //  System.out.println("移除最小: " + JSON.toJSONString(result));
        //加入新元素
        insert(num);
        //  System.out.println("加入之后: " + JSON.toJSONString(result));
    }
}