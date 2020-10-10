package edu.neu.xsz.leetcode.lcof.lcof57;
import java.util.ArrayList;

class Solution {
    /**
     * 从 start 加到 end-1,
     */
    private int getSum(int start, int end) {
        int ans = 0;
        for (int i = start; i < end; i++) {
            ans += i;
        }
        return ans;
    }

    public int[][] findContinuousSequence(int target) {

        int left = 1;
        int right = 1;
        ArrayList<int[]> ans = new ArrayList<>();

        while (right <= target / 2 + 2) {
            int sum = getSum(left, right);
            if (sum < target) {
                right++;
            } else if (sum > target) left++;
            else {
                int[] tmp = new int[right - left];
                for (int i = left; i < right; i++) {
                    tmp[i - left] = i;
                }
                ans.add(tmp);
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}