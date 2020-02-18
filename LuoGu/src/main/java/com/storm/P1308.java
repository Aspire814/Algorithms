package com.storm;

import java.util.Scanner;

public class P1308 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String str = in.nextLine();
        String upperStr = str.toUpperCase();
        String upperTarger = target.toUpperCase();
        String[] data = upperStr.split(" ");
        int count = 0;
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(upperTarger)) {
                count++;
                flag = false;
            } else {
                if (flag) {
                    index += data[i].length() + 1;//空格
                }
            }
        }
        if (flag) {
            System.out.print(-1);
        } else {
            System.out.print(count + " " + index);
        }
    }
}
