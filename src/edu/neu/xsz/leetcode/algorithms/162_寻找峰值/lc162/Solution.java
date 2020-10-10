/*

题目地址：
https://leetcode-cn.com/problems/find-peak-element/

*/
interface Solution {
    int findPeakElement(int[] nums);
}

class Solution1 implements Solution {
    /**
     * 暴力法， 不满足 对数时间复杂度的要求
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[0] > nums[1]) return 0;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) return i;
            } else {
                if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) return i;
            }
        }
        return 0;
    }

}

class Solution2 implements Solution {
    /**
     * 官方线性扫描法
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

}

class Solution3 implements Solution {
    /**
     * 二分查找, 要大的一半不要小的一半，来回迭代剩下的最后一个点就是结果。
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        int mid = 0;

        while ((right - left) > 1) {
            mid = (left + right - 1) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }

        }
        return left;
    }
}

class Main {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int[] nums = {1, 2};
//        Solution sol = new Solution1();
//        Solution sol = new Solution2();
        Solution sol = new Solution3();
        int ret = sol.findPeakElement(nums);
        System.out.println(ret);

    }
}
