package com.beingmate.learn.algorithm.leetcode.heap.max_k;

import com.google.common.base.Stopwatch;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractMaxK implements MaxKAlg {
    @Getter
    protected Long[] result = null;

    protected int itemCount;
    @Getter
    private long spend;

    public AbstractMaxK(int topK) {
        result = new Long[topK];
    }

    public void loadData(List<Long> datas) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (Long data : datas) {
            if (data == null) {
                break;
            }
            addNewItem(data);
        }
        spend += stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    public abstract void addNewItem(Long num);
}
