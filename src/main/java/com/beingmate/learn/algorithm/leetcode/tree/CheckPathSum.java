package com.beingmate.learn.algorithm.leetcode.tree;

public class CheckPathSum {
    public static void main(String[] args) {
        CheckPathSum cps = new CheckPathSum();
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        root.right = node4;
        node4.left = node11;
        node4.right = new TreeNode(3);

        boolean has = cps.hasPathSum(root, 11);
        System.out.println(has);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        int rest = sum - root.val;
        return hasPathSum(root.left, rest) || hasPathSum(root.right, rest);
    }
}