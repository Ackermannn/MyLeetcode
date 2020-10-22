package edu.neu.xsz.leetcode.lcof.locf45;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public String minNumber(int[] nums) {
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int x : nums) arr.add(String.valueOf(x));

        arr.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        arr.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
