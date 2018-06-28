package com.beingmate.learn.algorithm.leetcode.linklist;

import java.util.Stack;

public class LinkedNodesRevese {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printListNode(node1);

        ListNode newNode = reverseList(node1);
        printListNode(newNode);
    }

    private static void printListNode(ListNode node) {
        ListNode curNode = node;
        System.out.print(curNode.val + "=>");
        while ((curNode = curNode.next) != null) {
            System.out.print(curNode.val + "=>");
        }
        System.out.println("NULL");
    }

    /**
     * 直接在链表上做修改，时间复杂度O(N) ,空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseListSimple(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        ListNode curNode = preNode.next;
        boolean first = true;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (first) {
                preNode.next = null;
                first = false;
            }
            curNode.next = preNode;
            if (nextNode == null) {
                return curNode;
            }
            //切换到下一个
            preNode = curNode;
            curNode = nextNode;
        }
        return curNode;
    }

    /**
     * 使用栈存储，时间复杂度O(N) ,空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public static ListNode reverseListWithStack(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = null;
            nodeStack.push(curNode);

            //切换到下一个
            curNode = nextNode;
        }

        ListNode newNode = nodeStack.pop();
        curNode = newNode;
        while (!nodeStack.empty()) {
            ListNode newPop = nodeStack.pop();
            curNode.next = newPop;
            curNode = newPop;
        }
        return newNode;
    }
}
