package com.storm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1200 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                'Z'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i + 1);
        }
        String data1 = in.nextLine();
        String data2 = in.nextLine();
        char[] array1 = data1.toCharArray();
        char[] array2 = data2.toCharArray();
        int num1 = 1;
        int num2 = 1;
        for (char value : array1) {
            num1 *= map.get(value);
        }
        for (char c : array2) {
            num2 *= map.get(c);
        }
        if (num1 % 47 == num2 % 47) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }
    }
}
