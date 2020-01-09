package com.storm.simple;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


import org.junit.Test;

public class StringRelated {
    public String simplifyPath1(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        for (String string : stack) {
            res.append("/").append(string);
        }
        return res.toString();
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!item.isEmpty() && !item.equals("."))
                stack.push(item);
        }
        StringBuilder res = new StringBuilder();
        for (String d : stack)
            res.insert(0, "/" + d);
        return (res.length() == 0) ? "/" : res.toString();
    }

    /**
     * 报数序列
     */
    public String countAndSay(int n) {
        return countHelper("1", n);
    }

    private static String countHelper(String str, int n) {
        if (n == 1)
            return str;
        else {
            // 求下一个数
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            // 一直读数
            while (i < str.length()) {
                int count = 1;
                // 如果一直是同一个数
                while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                // 下一个数更新
                stringBuilder.append(Integer.toString(count)).append(str.charAt(i));
                i++;
            }
            str = stringBuilder.toString();
        }
        return countHelper(str, n - 1);
    }

    @Test
    public void reverse() {
        int x = -1534236469;
        String tmp;
        int result = 0;
        try {
            String str = String.valueOf(Math.abs(x));
            char[] array = str.toCharArray();
            tmp = "";
            for (int i = array.length - 1; i >= 0; i--) {
                tmp += array[i];
            }
            tmp = "-" + tmp;
            result = Integer.parseInt(tmp);
        } catch (NumberFormatException ignored) {
        }
    }

    // 不含有重复字符的 最长子串 的长度。
    @Test
    public void lengthOfLongestSubstring() {
        String s = "";
    }


    // 回文串
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        cnt--;
        while (j < cnt)
            if (cs[j++] != cs[cnt--])
                return false;
        return true;
    }

    // 找出独一元素 线性时间复杂度
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            try {
                map.remove(i);
            } catch (Exception e) {
                map.put(nums[i], nums[i]);
            }
        }
        return 0;
    }
}
