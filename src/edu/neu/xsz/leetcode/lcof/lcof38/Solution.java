package edu.neu.xsz.leetcode.lcof.lcof38;

import java.util.ArrayList;
import java.util.Arrays;

/*

 Question:

 https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/

  回溯法
*/
public class Solution {
    ArrayList<String> arrayList = new ArrayList<>();

    public String[] permutation(String s) {
        ArrayList<Character> opt = new ArrayList<>();

        // 排序去重，否则会超时
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);

        for (Character c : cArr) {
            opt.add(c);
        }

        recur("", opt);

        return arrayList.toArray(new String[0]);


    }

    void recur(String selected, ArrayList<Character> opt) {
        if (!opt.isEmpty()) {
            for (int i = 0; i < opt.size(); i++) {
                if (i != 0 && opt.get(i) == opt.get(i - 1)) continue;
                ArrayList<Character> newArr = new ArrayList<>(opt);
                newArr.remove(newArr.get(i));
                recur(selected + opt.get(i), newArr);
            }

        } else {
            arrayList.add(selected);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        String s = "abc";
//        String s = "aba";
        String s = "dkjphedy";
        String[] ret = sol.permutation(s);

        for (String x : ret) {
            System.out.println(x);
        }
    }
}
