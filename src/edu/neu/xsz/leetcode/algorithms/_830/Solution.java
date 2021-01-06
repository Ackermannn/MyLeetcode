package edu.neu.xsz.leetcode.algorithms._830;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * author: DownUpZ
 * create: 2021/1/5 下午 3:29
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        s = s + "A";
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        int end = start;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                end = i;
            } else {
                if (end - start >= 2) {
                    List<Integer> couple = new ArrayList<>();
                    couple.add(start);
                    couple.add(end);
                    ans.add(couple);
                }

                start = i;
                end = start;
            }
        }


        return ans;
    }


}

class Main {
    public static void main(String[] args) {

    }

}
