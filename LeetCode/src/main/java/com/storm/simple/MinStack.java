package com.storm.simple;

public class MinStack {
    int[] array;
    int index;
    int count;
    int min;

    public MinStack() {
        count = 16;
        array = new int[0];
        index = -1;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        index++;
        if (index >= array.length) {
            count *= 2;
            int[] arraypro = new int[count];
            for (int i = 0; i < array.length; i++) {
                arraypro[i] = array[i];
            }
            array = arraypro;
        }
        array[index] = x;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (index < 0) {
            return;
        }
        int tmp = array[index];
        array[index] = Integer.MAX_VALUE;
        index--;
        if (tmp == min) {
            tmp = array[0];
            for (int i = 0; i <= index; i++) {
                if (array[i] <= tmp) {
                    tmp = array[i];
                }
            }
            min = tmp;
        }

    }

    public int top() {
        return array[index];
    }

    public int getMin() {
        return min;

    }

}

