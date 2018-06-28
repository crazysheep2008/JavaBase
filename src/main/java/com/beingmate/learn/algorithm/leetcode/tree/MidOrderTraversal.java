package com.beingmate.learn.algorithm.leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.*;

/***
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * @author yfeng
 * @date 2018-06-24 8:14
 */
public class MidOrderTraversal {
    public static void main(String[] args) {
        MidOrderTraversal mot = new MidOrderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        List<Integer> results = mot.inorderTraversal(root);
        System.out.println(JSON.toJSONString(results));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<Guide> path = new ArrayDeque<>();
        path.addFirst(new Guide(0, root));
        while (!path.isEmpty()) {
            Guide guide = path.removeFirst();
            if (guide.node == null) {
                continue;
            }
            if (guide.oper == 1) {
                result.add(guide.node.val);
            } else {
                path.addFirst(new Guide(0, guide.node.right));
                path.addFirst(new Guide(0, guide.node.left));
                path.addFirst(new Guide(1, guide.node));
            }
        }
        return result;
    }

    class Guide {
        /**
         * 0 访问  1 打印
         */
        int oper;
        TreeNode node;

        public Guide(int oper, TreeNode node) {
            this.oper = oper;
            this.node = node;
        }
    }
}