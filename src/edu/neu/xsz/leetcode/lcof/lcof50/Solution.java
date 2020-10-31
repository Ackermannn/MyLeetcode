package edu.neu.xsz.leetcode.lcof.lcof50;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        // 建立有序字典
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for(Character ch:map.keySet()){
            if (map.get(ch)==1) return ch;
        }
        return ' ';
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abaccdeff";
        char ret = solution.firstUniqChar(s);
        System.out.println(ret);

    }

}