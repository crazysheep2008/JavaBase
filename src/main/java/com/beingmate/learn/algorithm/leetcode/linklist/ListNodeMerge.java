package com.beingmate.learn.algorithm.leetcode.linklist;

import java.util.ArrayList;
import java.util.List;

class ListNodeMerge {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = null;
        ListNode tailNode = null;
        NodeIter iter = new NodeIter();
        iter.addTreeNode(l1).addTreeNode(l2).init();
        
        while(iter.hasNext()){
            ListNode next = iter.next();
            if(newNode == null){
                newNode = next;
                tailNode = next;
            } else{
                tailNode.next = next;
                tailNode = next;
            }
        }
        return newNode;        
    }
    
    class NodeIter{
        private List<ListNode> nodes = new ArrayList();
        private int curIndex;
        NodeIter(){}       
        
        public NodeIter addTreeNode(ListNode node){
            if (node == null){
                return this;
            }
            nodes.add(node);
            return this;
        }
        
        public void init(){
            if (nodes.isEmpty()){
                return;
            }
            int minIndex = 0;
            for (int i = 1; i < nodes.size(); i++){
                ListNode node = nodes.get(i);                
                if (node.val < nodes.get(minIndex).val) {
                    minIndex = i;
                }
            }
            curIndex = minIndex;
        }
        
        private void caculateNext(){
            ListNode curNode = nodes.get(curIndex);
            if(curNode.next == null){
                nodes.remove(curNode);
            } else {
                nodes.set(curIndex , curNode.next);
            }

            init();
        }
        
        boolean hasNext(){
            return !nodes.isEmpty();
        }
        
        public ListNode next(){
            ListNode curNode = nodes.get(curIndex);
            caculateNext();
            return curNode;         
        }
    }
    
}