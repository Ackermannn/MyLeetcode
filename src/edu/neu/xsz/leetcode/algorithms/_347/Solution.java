package edu.neu.xsz.leetcode.algorithms._347;

import java.util.*;

/**
 * create time: 2021/1/15 上午 11:01
 *
 * @author DownUpZ
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) ans[i] = pq.remove();

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ret = sol.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ret));
    }
}