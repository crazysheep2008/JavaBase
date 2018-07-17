package com.beingmate.learn.algorithm.longest_palindrome;

import com.beingmate.learn.util.SystemUtil;

public class LongPalindromeClient {

    public static void main(String[] args) {
        LongPalindrome longPalindrome = new ViolentMethod();
        String input = SystemUtil.scanSystemInput();
        System.out.println(longPalindrome.name() + " 查找结果:" + longPalindrome.find(input));
    }
}
