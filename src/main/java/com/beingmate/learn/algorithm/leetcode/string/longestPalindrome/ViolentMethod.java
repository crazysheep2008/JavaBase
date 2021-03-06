package com.beingmate.learn.algorithm.leetcode.string.longestPalindrome;

/**
 * 暴力方法找到最长回文子串
 */
public class ViolentMethod extends AbstractLongPalindrome {

    @Override
    public String name() {
        return "暴力方法";
    }

    @Override
    protected String doFind(String input) {
        if (isPalindrome(input)) {
            return input;
        }
        int inputLen = input.length();
        for (int len = inputLen - 1; len >= 2; len--) {
            int taskCount = inputLen - len;
            for (int i = 0; i < taskCount; i++) {
                String subStr = input.substring(i, i + len);
                if (isPalindrome(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }
}
