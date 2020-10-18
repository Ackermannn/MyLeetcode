package edu.neu.xsz.leetcode.lcof.lcof40;

import java.util.PriorityQueue;

/**
 * 使用堆
 */
public class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length, (o1, o2) -> o1 - o2);
        for (int x : arr) pq.offer(x);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = pq.poll();
        return ans;
    }
}
