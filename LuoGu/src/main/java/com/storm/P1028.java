package com.storm;

import java.util.Scanner;

/**
 * 递归
 * 设f[i]为初始值为i时的满足条件总数，可得f[i]=f[1]+f[2]+f[3]+...+f[i/2];容易想到f[1]=1;
 * 因为f[i]=f[1]+f[2]+f[3]+...+f[i/2] 所以当i为奇数时f[i]=f[i-1],当i为偶数时f[i]=f[i-1]+f[i/2];
 */
public class P1028 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] f = new int[1001];
        f[1] = 1;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) {
                f[i] = f[i - 1] + f[i / 2];
            } else {
                f[i] = f[i - 1];
            }
        }
        System.out.println(f[num]);
    }
}
