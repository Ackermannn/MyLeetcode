package edu.neu.xsz.华为机试.HJ3;
/**
 * 牛客的华为机试环境要自己写输入输出
 *
 * 题目地址 https://www.nowcoder.com/ta/huawei 题号HJ3
 */

import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public void solve(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) continue;
            else
                System.out.println(nums[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int len = scan.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = scan.nextInt();
            }
            sol.solve(arr);
        }
    }
}
