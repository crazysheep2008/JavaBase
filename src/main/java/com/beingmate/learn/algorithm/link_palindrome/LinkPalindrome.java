package com.beingmate.learn.algorithm.link_palindrome;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/description/
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2        输出: false
 * 输入: 1->2->2->1  输出: true
 * 要求 : 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LinkPalindrome {

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
    }

    /**
     * 反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，时间复杂度O（n），空间复杂度为O（1）满足题目要求。
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        return false;
    }
}
