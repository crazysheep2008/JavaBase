package com.beingmate.learn.algorithm.leetcode.heap.max_k;

import java.util.List;

public interface MaxKAlg {
    void loadData(List<Long> datas);

    String name() ;

    Long[] getResult();

    long getSpend();
}
