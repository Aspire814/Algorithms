package com.storm;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = {2, 3, 1, 7, 5, 4, 8};
        sort(array, 0, 6);
        System.out.println();
    }


    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int middle = execute(array, low, high);
            sort(array, 0, middle - 1);
            sort(array, middle + 1, high);
        }
    }

    public static int execute(int[] arr, int low, int high) {
        int standard = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= standard) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= standard) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = standard;
        return low;
    }
}
