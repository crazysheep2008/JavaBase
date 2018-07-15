package com.beingmate.learn.algorithm.str_min_widow;

import org.apache.commons.lang3.StringUtils;

/**
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class StringMinWindow {

    public String minWindow(String src, String target) {
        if (StringUtils.isBlank(src) || StringUtils.isBlank(target)) {
            return "";
        }
        int srcLen = src.length();
        int targetLen = target.length();
        if (srcLen < targetLen) {
            return "";
        }

        int[] targetHash = new int[255];
        for (int i = 0; i < targetLen; i++) {
            targetHash[target.charAt(i)]++;
        }

        int[] desHash = new int[255];
        int found = 0;
        int begin = -1;
        int end = srcLen;
        int minLen = targetLen;
        int start = 0;
        for (int i = 0; i < srcLen; i++) {
            int curChar = src.charAt(i);
            desHash[curChar]++;
            if (desHash[curChar] <= targetHash[curChar]) {
                found++;
            }
            if (found == targetLen) {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while (start < i && desHash[curChar] > desHash[curChar]) {
                    desHash[curChar]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if (i - start < minLen) {
                    minLen = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                desHash[curChar]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;

            }
        }
        return null;
    }
}
