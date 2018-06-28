package com.beingmate.learn.algorithm.leetcode.stack;

/**
 *
 https://leetcode-cn.com/problems/min-stack/description/
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 *
 */
class MinStack {

    class StackNode {
        private int min;
        private int value;
        private StackNode next;

        StackNode(int min, int value) {
            this.min = min;
            this.value = value;
        }
    }

    private StackNode topNode;

    public MinStack() {
    }

    public void push(int x) {
        if (topNode == null) {
            topNode = new StackNode(x, x);
        } else {
            StackNode curTop = topNode;
            int min = Math.min(curTop.min, x);
            StackNode newTop = new StackNode(min, x);
            newTop.next = curTop;
            this.topNode = newTop;
        }
    }

    public void pop() {
        if (this.topNode == null) {
            return;
        }
        this.topNode = this.topNode.next;
    }

    public int top() {
        return this.topNode.value;
    }

    public int getMin() {
        return this.topNode.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // --> 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();

        // --> 返回 0.
        System.out.println(minStack.top());

        // --> 返回 -2.
        System.out.println(minStack.getMin());

    }
}
