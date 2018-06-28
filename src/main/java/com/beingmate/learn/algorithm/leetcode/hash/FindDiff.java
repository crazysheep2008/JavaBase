package com.beingmate.learn.algorithm.leetcode.hash;

/***
 * https://leetcode-cn.com/problems/find-the-difference/description/
 * @author yfeng
 * @date 2018-06-25 19:31
 */
public class FindDiff {

    public static void main(String[] args) {
        FindDiff diff = new FindDiff();
        char diffChar = diff.findTheDifference("abc", "dabc");
        System.out.println("" + diffChar);
    }

    public char findTheDifference(String s, String t) {
        int[] srcHash = new int[26];
        int offset = 97;
        for (int i = 0; i < s.length(); i++) {
            srcHash[s.charAt(i) - offset]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char curChar = t.charAt(i);
            if (srcHash[curChar - offset]-- == 0) {
                return curChar;
            }
        }
        return 0x00;
    }
}