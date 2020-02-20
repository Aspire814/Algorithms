package com.storm;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 回文质数
 */
public class P1217 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String data = in.nextLine();
        String data = "111 677";
        String[] array = data.split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        a = a % 2 == 0 ? a += 1 : a;
        for (int i = a; i <= b; i += 2) {
            if (isPrime(i)) {
                if (checkN(i)) System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        int s = (int) Math.sqrt(n);
        for (int i = 2; i <= s; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkN(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        while (n > 0) {
            array.add(n % 10);
            n /= 10;
        }
        for (int i = 0, j = array.size() - 1; j >= i; i++, j--) {
            if (array.get(i).intValue() != array.get(j)) {
                return false;
            }
        }
        return true;
    }
}
