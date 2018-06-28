package com.beingmate.learn.algorithm.leetcode.string.longestPalindrome;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractLongPalindrome implements LongPalindrome {

    public String find(String input) {
        System.out.println("输入:" + input);
        if (StringUtils.isBlank(input)) {
            return input;
        }
        int inputLen = input.length();
        if (inputLen == 1) {
            return input;
        }
        String res = doFind(input);
        return res;
    }

    /**
     * 对长度大于1的字符串进行最长回文子窜查找
     *
     * @param input
     * @return
     */
    protected abstract String doFind(String input);

    public static boolean isPalindrome(String text) {
        int len = text.length();
        int startIndex = 0;
        int endIndex = len - 1;
        while (startIndex <= endIndex) {
            int charStart = text.charAt(startIndex++);
            int charEnd = text.charAt(endIndex--);
            if (charEnd != charStart) {
                return false;
            }
        }
        return true;
    }
}