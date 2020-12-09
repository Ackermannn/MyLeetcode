package edu.neu.xsz.leetcode.algorithms._448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*排序+二分法查找*/
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (Arrays.binarySearch(nums, i) < 0) ans.add(i);
        }
        return ans;


    }
}
