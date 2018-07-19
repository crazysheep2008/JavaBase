package com.beingmate.learn.algorithm.leetcode.tree;

/***
 * @author yfeng
 * @date 2018-07-12 22:51
 */
public class LongestUnivaluePath {
    int maxPathVal = 0;

    public static void main(String[] args) {
        LongestUnivaluePath lup = new LongestUnivaluePath();

        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node1.left = node4;
        node4.left = new TreeNode(4);
        node4.right = new TreeNode(4);

        TreeNode node5 = new TreeNode(5);
        node1.right = node5;
        node5.left = new TreeNode(5);

        System.out.println(lup.longestUnivaluePath(node1));
    }

    public int longestUnivaluePath(TreeNode root) {
        getPathVal(root);
        return maxPathVal;
    }

    public int getPathVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftPath = getPathVal(root.left);
        int rightPath = getPathVal(root.right);
        int curPathVal = 0;
        if (!sameVal(root.left, root) && !sameVal(root.right, root)) {
            return 0;
        }

        leftPath = sameVal(root.left, root) ? leftPath + 1 : 0;
        rightPath = sameVal(root.right, root) ? rightPath + 1 : 0;

        curPathVal = Math.max(leftPath, rightPath);

        if (leftPath + rightPath > maxPathVal) {
            maxPathVal = leftPath + rightPath;
        }

        return curPathVal;
    }

    private boolean sameVal(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val;
    }
}
