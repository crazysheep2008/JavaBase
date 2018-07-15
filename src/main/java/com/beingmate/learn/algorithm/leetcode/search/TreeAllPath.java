package com.beingmate.learn.algorithm.leetcode.search;

import com.beingmate.learn.algorithm.leetcode.tree.TreeNode;

import java.util.*;

public class TreeAllPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList();
        if (root == null) {
            return results;
        }
        if (root.left == null && root.right == null) {
            results.add("" + root.val);
            return results;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);

        String curPath = root.val + "->";
        if (!leftPath.isEmpty()) {
            for (String subPath : leftPath) {
                results.add(curPath + subPath);
            }
        }
        if (!rightPath.isEmpty()) {
            for (String subPath : rightPath) {
                results.add(curPath + subPath);
            }
        }
        return results;
    }
}