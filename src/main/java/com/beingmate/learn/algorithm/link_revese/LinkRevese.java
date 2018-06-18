package com.beingmate.learn.algorithm.link_revese;

import java.util.Stack;

public class LinkRevese {
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

    public static ListNode reverseList(ListNode head) {
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
