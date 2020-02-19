package com.storm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class P1036 {
    private static int[] data = {};
    private static int ret = 0;
    private static int currentSum = 0;
    private static ArrayList<Integer> tmpArr = new ArrayList<>();

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // String data1 = in.nextLine();
        //String data2 = in.nextLine(); 
        String data1 = "4 3";
        String data2 = "1 2 3 4 ";
        String[] array1 = data1.split(" ");
        String[] array2 = data2.split(" ");
        int n = Integer.parseInt(array1[0]);
        int k = Integer.parseInt(array1[1]);
        data = toIntArray(array2);
        combine(0, k);
        System.out.println(ret);
    }

    public static void combine(int index, int k) {
        if (k == 1) {
            for (int i = index; i < data.length; i++) {
                tmpArr.add(data[i]);
                System.out.println(tmpArr.toString());
                if (isPrime(computeList(tmpArr))) {
                    ret++;
                }
                tmpArr.remove((Object) data[i]);
            }
        } else if (k > 1) {
            for (int i = index; i <= data.length - k; i++) {
                tmpArr.add(data[i]);
                combine(i + 1, k - 1);
                tmpArr.remove((Object) data[i]);
            }
        }
    }

    public static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] toIntArray(String[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = Integer.parseInt(array[i]);
        }
        return ret;
    }

    public static int computeList(List<Integer> list) {
        int sum = 0;
        for (Integer t : list) {
            sum += t;
        }
        return sum;
    }
}
