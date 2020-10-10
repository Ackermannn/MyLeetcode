package edu.neu.xsz.leetcode.algorithms.lc008_atoi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int myAtoi(String str) {
        int res = 0;
        long ans = 0;
        int sign = 1;
        str = str.trim(); // 去掉前面的空格

        if ("+".equals(str)) return 0; // 去掉"+"的情况
        if ("-".equals(str)) return 0; // 去除"-"的情况
        if (str.length() == 0) return 0; // 去除 ""
        char firstChar = str.charAt(0);  // 首字符
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) return 0; // 去除首字符 不是 + - 数字

        // 找到数字部分的结束
        int end_p = 1;
        for (; end_p < str.length(); end_p++) {
            if (!Character.isDigit(str.charAt(end_p)))
                break;
        }
        // 找到数字部分的开始，应对 "00001" 这种情况
        int start_p = 0;
        if (!Character.isDigit(firstChar)) start_p++;
        for (; start_p < end_p; start_p++) {
            if (str.charAt(start_p) != '0')
                break;
        }

        str = str.substring(start_p, end_p); // 只剩下数字位的str

        if (str.length()==0) return 0; // 应对 "000" 的情况

        // 位数太长的情况
        if (str.length() > 10) {
            if (firstChar == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

        ans = Long.parseLong(str);
        if (firstChar == '-') {
            res = (int) Math.max(-1 * ans, Integer.MIN_VALUE);

        }else
            res = (int) Math.min(ans, Integer.MAX_VALUE);
        return res;
    }

    // test
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "++1";
        int res = s.myAtoi(str);
        System.out.println(res);
    }
}
