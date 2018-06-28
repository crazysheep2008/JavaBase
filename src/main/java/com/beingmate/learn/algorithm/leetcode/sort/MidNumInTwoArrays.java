package com.beingmate.learn.algorithm.leetcode.sort;

/***
 * @author yfeng
 * @date 2018-06-22 23:58
 */
public class MidNumInTwoArrays {
    public static void main(String[] args) {
        MidNumInTwoArrays mnit = new MidNumInTwoArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5};
        System.out.println(mnit.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int midStart = (totalLen + 1) / 2;
        int midEnd = totalLen / 2 + 1;
        int[] result = new int[midEnd];

        int pos = 0;
        int num1Pos = 0;
        int num2Pos = 0;

        while (pos < midEnd) {
            if (num1Pos > nums1.length - 1) {
                result[pos++] = nums2[num2Pos++];
            } else if (num2Pos > nums2.length - 1) {
                result[pos++] = nums1[num1Pos++];
            } else {
                if (nums1[num1Pos] < nums2[num2Pos]) {
                    result[pos++] = nums1[num1Pos++];
                } else {
                    result[pos++] = nums2[num2Pos++];
                }
            }
        }
        return (result[midStart - 1] + result[midEnd - 1]) / 2d;
    }
}
