package com.beingmate.learn.util;

import com.beingmate.learn.algorithm.leetcode.linklist.ListNode;

/***
 * @author yfeng
 * @date 2018-06-22 12:26
 */
public class ListNodeUtil {

    public static void printListNode(ListNode node) {
        ListNode curNode = node;
        System.out.print(curNode.val + "=>");
        while ((curNode = curNode.next) != null) {
            System.out.print(curNode.val + "=>");
        }
        System.out.println("NULL");
    }
}
