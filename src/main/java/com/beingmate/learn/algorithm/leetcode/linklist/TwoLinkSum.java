package com.beingmate.learn.algorithm.leetcode.linklist;

import com.beingmate.learn.util.ListNodeUtil;

/***
 *
 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * @author yfeng
 * @date 2018-06-22 12:05
 */
public class TwoLinkSum {


    public static void main(String[] args) {

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node42 = new ListNode(4);

        node2.next = node4;
        node4.next = node3;


        node5.next = node6;
        node6.next = node42;

        TwoLinkSum tls = new TwoLinkSum();
        System.out.println("-----");
        ListNode newNode = tls.addTwoNumbers(new ListNode(5), new ListNode(5));
        System.out.println("-----");
        ListNodeUtil.printListNode(newNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode node1 = l1;
        ListNode node2 = l2;

        //同位节点求和
        ListNode curSumNode = null;
        while (node1 != null || node2 != null) {
            if (node1 == null){
                node1 = new ListNode(0);
            }
            if (node2 == null){
                node2 = new ListNode(0);
            }
            ListNode sumNode = new ListNode(node1.val + node2.val);
            if (resultNode == null) {
                curSumNode = sumNode;
                resultNode = curSumNode;
            } else {
                curSumNode.next = sumNode;
            }
            curSumNode = sumNode;
            node1 = node1.next;
            node2 = node2.next;
        }

        //超过10则取进位
        ListNode curNode = resultNode;
        while (curNode != null) {
            int val = curNode.val;
            if (val >= 10) {
                int tenVal = val / 10;
                int mod = val % 10;
                curNode.val = mod;

                if (curNode.next != null) {
                    curNode.next.val = curNode.next.val + tenVal;
                } else {
                    ListNode next = new ListNode(tenVal);
                    curNode.next = next;
                }
            }
            curNode = curNode.next;
        }

        //结果反转
       /* ListNode prev = null;
        while (resultNode != null) {
            ListNode nextVal = resultNode.next;
            resultNode.next = prev;
            prev = resultNode;
            resultNode = nextVal;
        }*/
        return resultNode;
    }
}
