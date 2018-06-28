package com.beingmate.learn.algorithm.leetcode.string;

import com.beingmate.learn.util.SystemUtil;

import java.util.HashSet;

/***
 *
 给定一个字符串，找出不含有重复字符的最长子串的长度。
 示例：
 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * @author yfeng
 * @date 2018-06-21 18:10
 */
public class LengtOfLongestSubString {
    public static void main(String[] args) {
        LengtOfLongestSubString lls = new LengtOfLongestSubString();
        String input = SystemUtil.scanSystemInput();
        int maxSubLen = lls.lengthOfLongestSubstring(input);
        System.out.println(String.format("%s 最长字串长度:%s", input, maxSubLen));
    }

    public int lengthOfLongestSubstring(String input) {
        if (null == input || "".equals(input.trim())) {
            return 0;
        }
        int inputLen = input.length();
        if (inputLen == 1) {
            return 1;
        }
        HashSet<Character> set = new HashSet<Character>();

        //保存结果的变量
        int maxSubLen = 0;
        int startIndex = 0;
        int endIndex = 0;

        //滑动游标
        int left = 0;
        int right = 0;
        while (right < inputLen) {
            Character curChar = input.charAt(right);
            if (set.contains(curChar)) {
                if ((right - left) > maxSubLen) {
                    maxSubLen = right - left;
                    startIndex = left;
                    endIndex = right;
                }
                while (input.charAt(left) != curChar.charValue()) {
                    set.remove(input.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(curChar);
            }
            right++;
        }
        if ((right - left) > maxSubLen) {
            maxSubLen = right - left;
            startIndex = left;
            endIndex = right;
        }
        System.out.println("最大子串: " + input.substring(startIndex, endIndex));
        return maxSubLen;
    }
}
