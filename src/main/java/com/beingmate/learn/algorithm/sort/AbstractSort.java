package com.beingmate.learn.algorithm.sort;

import com.alibaba.fastjson.JSON;

/***
 * @author yfeng
 * @date 2018-06-07 12:42
 */
public abstract class AbstractSort implements SortAlgorithm {

    abstract String algorithmName();

    @Override
    public void sort(int[] inputArray) {
        System.out.println("原始输入：" + JSON.toJSONString(inputArray));
        doSort(inputArray);
        System.out.println(String.format("%s排序输出：%s", algorithmName(), JSON.toJSONString(inputArray)));
    }

    abstract void doSort(int[] inputArray);
}