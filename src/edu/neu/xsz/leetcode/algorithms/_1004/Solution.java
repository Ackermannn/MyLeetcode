package edu.neu.xsz.leetcode.algorithms._1004;

class Solution {
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int left = 0, right = 0;
        int ans = 0;
        int count = 0; // count zero number

        while (right < N) {
            if (A[right] == 0) count++; // 右指针碰到0时 count+1
            right++;
            while (count > K) {// count 达到 K 时， 移动left 直到从左边吐出0
                if (A[left] == 0) count--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        int ret = sol.longestOnes(A, K);
        System.out.println(ret);

    }
}