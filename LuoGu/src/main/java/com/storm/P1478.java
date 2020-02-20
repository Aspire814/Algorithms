package com.storm;

import java.util.Collections;
import java.util.Scanner;

public class P1478 {

    private static int[] strenthArray = null;
    private static int[] appleHeightArray = null;
    private static int ret = 0;

    public static void sort(int low, int high) {
        if (low < high) {
            int middle = execute(low, high);
            sort(0, middle - 1);
            sort(middle + 1, high);
        }
    }

    public static int execute(int low, int high) {
        int standard = strenthArray[low];
        int s = appleHeightArray[low];
        while (low < high) {
            while (low < high && strenthArray[high] >= standard) {
                high--;
            }
            strenthArray[low] = strenthArray[high];
            appleHeightArray[low] = appleHeightArray[high];

            while (low < high && strenthArray[low] <= standard) {
                low++;
            }
            strenthArray[high] = strenthArray[low];
            appleHeightArray[high] = appleHeightArray[low];
        }
        strenthArray[low] = standard;
        appleHeightArray[low] = s;
        return low;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line1 = cin.nextLine();
        String line2 = cin.nextLine();
        String[] data1 = line1.split(" ");
        String[] data2 = line2.split(" ");

        int appleCount = Integer.parseInt(data1[0]);
        int strength = Integer.parseInt(data1[1]);
        int chairHeight = Integer.parseInt(data2[0]);
        int base_height = Integer.parseInt(data2[1]);
        strenthArray = new int[appleCount];
        appleHeightArray = new int[appleCount];

        int index = 0;
        while (cin.hasNext() && index < appleCount) {
            String tmp = cin.nextLine();
            String[] data = tmp.split(" ");
            int height = Integer.parseInt(data[0]);
            int s = Integer.parseInt(data[1]);
            strenthArray[index] = s;
            appleHeightArray[index] = height;
            index++;
        }
        sort(0, appleCount - 1);
        for (int i = 0; i < appleCount - 1; i++) {
            if (base_height >= appleHeightArray[i]) {
                ret++;
            } else if (strength - strenthArray[i] > 0 && base_height + chairHeight >= appleHeightArray[i]) {
                strength -= strenthArray[i];
                ret++;
            }
        }
        System.out.println(ret);
    }

}
