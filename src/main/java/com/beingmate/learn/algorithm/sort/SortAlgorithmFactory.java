package com.beingmate.learn.algorithm.sort;

/***
 * @author yfeng
 * @date 2018-06-07 12:59
 */
public class SortAlgorithmFactory {
    public static SortAlgorithm getSortAlgorithmInstance(Class className) {
        try {
            return (SortAlgorithm) className.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}