package com.beingmate.learn.algorithm.tire_tree;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.Getter;

import java.util.Iterator;
import java.util.LinkedList;

/***
 * @author yfeng
 * @date 2018-05-14 20:13
 */
public class TireTree {
    @Getter
    private Node root = new Node(' ');

    @Data
    private class Node {
        private char content;
        private int wordCount;
        private boolean isLeaf;
        private LinkedList<Node> children;

        private Node(char content) {
            this.content = content;
            this.wordCount = 1;
        }

        private void wordCountIncrease() {
            this.wordCount++;
        }

        private void wordCountDescrease(long des) {
            this.wordCount -= des;
        }

        private Node searchInChildren(char checkContent) {
            if (null == children || children.isEmpty()) {
                return null;
            }
            for (Node node : children) {
                if (node.content == checkContent) {
                    return node;
                }
            }
            return null;
        }

        private int childrenMaxCount() {
            if (null == children || children.isEmpty()) {
                return 0;
            }
            int count = 0;
            for (Node node : children) {
                if (node.getWordCount() > count) {
                    count = node.getWordCount();
                }
            }
            return count;
        }

        private Node addNext(char content) {
            if (children == null) {
                children = new LinkedList<>();
            }
            Node newNode = new Node(content);
            children.add(newNode);
            return newNode;
        }

        private void deleteChild(Node node) {
            if (children == null || children.isEmpty()) {
                return;
            }
            Iterator<Node> nodeIterator = children.iterator();
            while (nodeIterator.hasNext()) {
                Node curNode = nodeIterator.next();
                if (curNode == node) {
                    nodeIterator.remove();
                    return;
                }
            }
        }

        private boolean hasChildren() {
            return null != children && children.size() > 0;
        }
    }

    public void save(String value) {
        insert(root, value.toCharArray(), 0);
    }

    private void insert(Node parent, char[] chars, int index) {
        if (index >= chars.length) {
            return;
        }
        char curChar = chars[index];
        Node node = parent.searchInChildren(curChar);
        if (node == null) {
            node = parent.addNext(curChar);
        } else {
            node.wordCountIncrease();
        }

        //
        int nextIndex = index + 1;
        if (nextIndex >= chars.length) {
            return;
        }
        if (nextIndex == chars.length - 1) {
            node.setLeaf(true);
        }
        insert(node, chars, nextIndex);
    }

    public long count(String data) {
        char[] chars = data.toCharArray();
        Node curNode = root;
        for (int i = 0; i < chars.length; i++) {
            curNode = curNode.searchInChildren(chars[i]);
            if (curNode == null) {
                return 0;
            }
        }
        return curNode.wordCount;
    }

    public boolean remove(String data) {
        return remove(data, false);
    }

    public boolean removeAll(String data) {
        return remove(data, true);
    }

    private boolean remove(String data, boolean removeAll) {
        char[] chars = data.toCharArray();
        Node curNode = root;
        LinkedList<Node> wordNodes = new LinkedList<>();
        long wordCount = 0;
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            curNode = curNode.searchInChildren(curChar);
            if (curNode == null) {
                return false;
            } else {
                wordNodes.add(curNode);
                wordCount = curNode.wordCount;
            }
        }

        long removeCount = removeAll ? wordCount : 1;
        Node parentNode = root;
        for (Node node : wordNodes) {
            if (node.wordCount == removeCount) {
                parentNode.deleteChild(node);
                return true;
            } else {
                node.wordCountDescrease(removeCount);
                parentNode = node;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TireTree tireTree = new TireTree();
        tireTree.save("china");
        tireTree.save("chinese");
        tireTree.save("love");
        tireTree.save("love");
        tireTree.save("chinese");
        tireTree.save("word");
        tireTree.save("美丽");
        tireTree.save("美丽");
        tireTree.save("美丽新世界");
        tireTree.save("美丽清晨");
        tireTree.save("chinese");
        System.out.println("---------------------------------------->>>");
        System.out.println(JSON.toJSONString(tireTree, true));
        System.out.println("---------------------------------------->>>");
        System.out.println("chinese ->" + tireTree.count("chinese"));
        System.out.println("love ->" + tireTree.count("love"));
        System.out.println("hate ->" + tireTree.count("hate"));
        System.out.println("美丽 ->" + tireTree.count("美丽"));
        System.out.println("chin ->" + tireTree.count("chin"));
        System.out.println("---------------------------------------->>>");
        tireTree.remove("love");
        System.out.println("love ->" + tireTree.count("love"));
        tireTree.removeAll("美丽");
        System.out.println("美丽 ->" + tireTree.count("美丽"));
        tireTree.removeAll("chinese");
        System.out.println("chinese ->" + tireTree.count("chinese"));
    }
}