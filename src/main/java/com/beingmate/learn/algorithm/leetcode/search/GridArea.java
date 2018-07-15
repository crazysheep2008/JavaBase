package com.beingmate.learn.algorithm.leetcode.search;

import java.util.*;

class GridArea {

    public static void main(String[] args) {
        int[][] datas = new int[8][13];
        datas[0] = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        datas[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        datas[2] = new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        datas[3] = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0};
        datas[4] = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        datas[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        datas[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        datas[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        GridArea ga = new GridArea();
        //  System.out.println(ga.maxAreaOfIsland(datas));


        int[][] datas2 = new int[4][5];
        datas2[0] = new int[]{1, 1, 0, 0, 0};
        datas2[1] = new int[]{1, 1, 0, 0, 0};
        datas2[2] = new int[]{0, 0, 0, 1, 1};
        datas2[3] = new int[]{0, 0, 0, 1, 1};
        System.out.println(ga.maxAreaOfIsland(datas2));
    }

    class Point {
        int h, w;

        Point(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append("[").append(this.h).append(",").append(this.w).append("]");
            return buf.toString();
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        if (width == 0) {
            return 0;
        }

        boolean[][] visit = new boolean[height][width];
        int area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int curArea = findArea(grid, i, j, visit);
                if (curArea > area) {
                    area = curArea;
                }
            }
        }
        return area;
    }

    public int findArea(int[][] grid, int h, int w, boolean[][] visit) {
        if (visit[h][w]) {
            return 0;
        }
        if (grid[h][w] == 0) {
            visit[h][w] = true;
            return 0;
        }
        int area = 0;
        Deque<Point> pointStack = new LinkedList<>();
        pointStack.push(new Point(h, w));
        while (!pointStack.isEmpty()) {
            Point p = pointStack.pop();
            if (isArea(grid, p, visit)) {
                area++;
                List<Point> nears = nears(grid, p);
                for (Point point : nears) {
                    if (notVisited(point, visit)) {
                        pointStack.push(point);
                    }
                }
            }
        }

        return area;
    }

    private List<Point> nears(int[][] grid, Point p) {
        List<Point> nears = new ArrayList<>();

        int height = grid.length;
        int width = grid[0].length;

        if (p.w > 0) {
            nears.add(new Point(p.h, p.w - 1));
        }
        if (p.w < width - 1) {
            nears.add(new Point(p.h, p.w + 1));
        }
        if (p.h > 0) {
            nears.add(new Point(p.h - 1, p.w));
        }
        if (p.h < height - 1) {
            nears.add(new Point(p.h + 1, p.w));
        }
        return nears;
    }

    private boolean notVisited(Point p, boolean[][] visit) {
        return !visit[p.h][p.w];
    }

    private boolean isArea(int[][] grid, Point p, boolean[][] visit) {
        if (!exist(p, grid)) {
            return false;
        }
        if (visit[p.h][p.w]) {
            return false;
        }
        visit[p.h][p.w] = true;
        return grid[p.h][p.w] == 1;
    }

    private boolean exist(Point p, int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        if (p.h < 0 || p.h >= height) {
            return false;
        }
        if (p.w < 0 || p.w > width) {
            return false;
        }
        return true;
    }
}