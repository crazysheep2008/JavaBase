package com.beingmate.learn.algorithm.leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/***
 * @author yfeng
 * @date 2018-06-24 12:32
 */
public class LevelOrder {

    public static void main(String[] args) {
        LevelOrder mot = new LevelOrder();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = new TreeNode(4);
        node2.right = new TreeNode(5);

        node3.left = new TreeNode(7);
        node3.right = new TreeNode(8);

        List<List<Integer>> results = mot.levelOrder(root);
        for (List<Integer> line : results) {
            System.out.println(JSON.toJSONString(line));
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> curNodes = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        curNodes.add(root);
        while (!curNodes.isEmpty()) {
            List<Integer> curLevelResult = new ArrayList<>();
            for (TreeNode treeNode : curNodes) {
                curLevelResult.add(treeNode.val);
                if (treeNode.left != null) {
                    nextNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextNodes.add(treeNode.right);
                }
            }
            result.add(curLevelResult);
            curNodes.clear();
            curNodes.addAll(nextNodes);
            nextNodes.clear();
        }
        return result;
    }
}
