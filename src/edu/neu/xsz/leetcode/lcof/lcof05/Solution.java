package edu.neu.xsz.leetcode.lcof.lcof05;

/**
 * 学习 StringBuilder
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);

            }
        }
        return stringBuilder.toString();

    }
}
