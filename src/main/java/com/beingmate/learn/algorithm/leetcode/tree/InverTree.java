package com.beingmate.learn.algorithm.leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Stack;

/***
 * @author yfeng
 * @date 2018-06-24 12:56
 */
public class InverTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
     //   root.right = node3;
      //  node2.left = new TreeNode(4);
        node2.right = new TreeNode(5);

        node3.left = new TreeNode(6);
        node3.right = new TreeNode(7);

        LevelOrder lo = new LevelOrder();
        List<List<Integer>> datas1 = lo.levelOrder(root);
        System.out.println(JSON.toJSONString(datas1));
        InverTree it = new InverTree();
        it.invertTree(root);

        List<List<Integer>> datas2 = lo.levelOrder(root);
        System.out.println(JSON.toJSONString(datas2));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            TreeNode tmp = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tmp;
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        return root;
    }
}
