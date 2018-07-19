package com.beingmate.learn.algorithm.array;

import com.alibaba.fastjson.JSON;

/***
 * @author yfeng
 * @date 2018-07-09 9:28
 */
public class ImageRotate {
    public static void main(String[] args) {
        int[][] imgs = new int[4][4];
        imgs[0] = new int[]{1,2,3,4};
        imgs[1] = new int[]{5,6,7,8};
        imgs[2] = new int[]{9,10,11,12};
        imgs[3] = new int[]{13,14,15,16};
        ImageRotate ir = new ImageRotate();
        printArray(imgs);
        ir.rotate(imgs);
        System.out.println("=--------");
        printArray(imgs);
    }

    private static void printArray(int[][] imgs) {
        for (int[] array : imgs) {
            System.out.println(JSON.toJSONString(array));
        }
    }

    public void rotate(int[][] matrix) {
        int maxLevel = matrix.length / 2 - 1;
        for (int i = 0; i <= maxLevel; i++) {
            rotateImage(matrix, i);
        }
    }

    private void rotateImage(int[][] matrix, int offset) {
        int width = matrix.length - offset * 2;
        int maxOffset = matrix.length - 1 - offset;
        for (int i = 0; i < width - 1; i++) {

            int tem = matrix[offset][offset + i];

            // 左上 <- 左下
            matrix[offset][offset + i] = matrix[maxOffset - i][offset];
            // 左下 <- 右下
            matrix[maxOffset - i][offset] = matrix[maxOffset][maxOffset - i];
            // 右下 <- 右上
            matrix[maxOffset][maxOffset - i] = matrix[offset + i][maxOffset];
            // 右上 <- 左上
            matrix[offset + i][maxOffset] = tem;
        }
    }
}
