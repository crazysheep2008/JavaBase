package com.beingmate.learn.queue.lock_free;

/***
 * @author yfeng
 * @date 2018-05-12 17:31
 */
public class SimpleRingBuffer<T> {
    private static int DEFAULT_CAPACITY = 1 << 6;
    private int capacity;
    private Object datas;
    private int head = 0;
    private int tail = 0;

    public SimpleRingBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleRingBuffer(int size) {
        capacity = getTwoPowerValue(size);
        datas = new Object[capacity];
    }

    private boolean empty() {
        return head == tail;
    }

    private boolean full() {
        return ((tail) & capacity) == head;
    }

    public int size() {
        if (full()) {
            return capacity - 1;
        }
        if (empty()) {
            return 0;
        }
        return tail + 1;
    }

    private int getTwoPowerValue(int size) {
        int mod = size & (size - 1);
        if (mod == 0) {
            return size;
        }
        int v = 1;
        while (v < size) {
            v = v >> 1;
        }
        return v;
    }

    public T get() {
        return null;
    }

    public boolean put(T data) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=");
        System.out.println(Long.MAX_VALUE);
    }
}