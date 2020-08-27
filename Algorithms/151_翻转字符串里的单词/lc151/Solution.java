package lc151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.strip().split("\\s+"); // 去除头部空格，split 部分涉及到正则表达式
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            res.append(strs[i]).append(" ");
        }
        res.append(strs[0]);
        return res.toString();
    }
    /*
    官方的库函数方法
     */
    public String reverseWords0(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }



    public static void main(String[] args) {

        var res = new Solution().reverseWords("   a    good!      example  ");
        System.out.println(res + ";");
    }
}
