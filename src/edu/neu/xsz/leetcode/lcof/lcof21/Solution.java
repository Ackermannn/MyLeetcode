package edu.neu.xsz.leetcode.lcof.lcof21;

class Solution {
    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) left++;
            else if (nums[right] % 2 == 0) right--;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;

    }
}

class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};

        int[] ret = solution.exchange(nums);

        for (int i : ret) {
            System.out.printf("%d,", i);
        }
        System.out.println(" ");

    }
}