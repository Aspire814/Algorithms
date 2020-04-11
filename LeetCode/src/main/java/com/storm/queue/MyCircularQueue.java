package com.storm.queue;

import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {
    int[] array;
    int front;
    int rear;
    int len;
    int count;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.array = new int[k];
        this.front = 0;//如何定义队头和队尾 0 还是-1 先移动指针还是先操作元素  这里采用先移动指针
        this.rear = -1;
        this.len = k;
        this.count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.rear = (this.rear + 1) % this.len;
        this.array[rear] = value;
        this.count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.len;
        this.count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.array[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.count == this.len;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(4);
        queue.Rear();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
