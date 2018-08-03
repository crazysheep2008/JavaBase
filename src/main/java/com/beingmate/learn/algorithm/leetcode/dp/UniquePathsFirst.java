package com.beingmate.learn.algorithm.leetcode.dp;

public class UniquePathsFirst {
    public static void main(String[] args) {
        UniquePathsFirst upf = new UniquePathsFirst();
        System.out.println(upf.uniquePaths(3, 2));
    }

    /**
     * https://leetcode-cn.com/problems/unique-paths/description/
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * https://leetcode-cn.com/problems/unique-paths-ii/description/
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] dp = new int[height][width];
        for (int r = 0; r < height; r++) {
            loopInner:
            for (int c = 0; c < width; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                    continue loopInner;
                }
                if (r == 0 && c == 0) {
                    dp[r][c] = 1;
                    continue loopInner;
                }
                if (r == 0) {
                    if (dp[r][c - 1] == 0) {
                        dp[r][c] = 0;
                    } else {
                        dp[r][c] = 1;
                    }
                    continue loopInner;
                }
                if (c == 0) {
                    if (dp[r-1][c] == 0) {
                        dp[r][c] = 0;
                    } else {
                        dp[r][c] = 1;
                    }
                    continue loopInner;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[height - 1][width - 1];
    }
}
