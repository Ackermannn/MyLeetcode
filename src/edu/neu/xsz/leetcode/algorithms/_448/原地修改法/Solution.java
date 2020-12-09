package edu.neu.xsz.leetcode.algorithms._448.原地修改法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx-1] > 0) nums[idx-1] *= -1;
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) arr.add(i+1);

        return arr;

    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("...");
    }
}
