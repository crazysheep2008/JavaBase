package com.beingmate.learn.util;

import java.util.List;

/***
 * @author yfeng
 * @date 2018-06-03 22:12
 */
public class ListUtil {
    public static void swap(List list, int from, int to) {
        Object objFrom = list.get(from);
        list.set(from, list.get(to));
        list.set(to, objFrom);
    }
}