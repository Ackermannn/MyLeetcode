package edu.neu.xsz.leetcode.algorithms.easy._860;
// https://leetcode-cn.com/problems/lemonade-change/

// 柠檬水找零

class Solution {
    public boolean lemonadeChange(int[] bills) {

        int fiveChangeCount = 0;
        int tenChangeCount = 0;
        for (int bill : bills) {
            if (bill == 5) fiveChangeCount++;
            else if (bill == 10) {
                fiveChangeCount--;
                tenChangeCount++;
            }
            else { // bill 是10
                if (tenChangeCount >= 1) { // 先看看10块的能不能顶得住
                    tenChangeCount--;
                    fiveChangeCount--;

                }else{ // 10的顶不住，只能来三个5块了
                    fiveChangeCount -= 3;
                }
            }
            // 如果余下的零钱数小于零————没法干了
            if (fiveChangeCount < 0 || tenChangeCount < 0) return false;
        }
        return true;

    }

}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,5,5,10,20}; // true
//        int[] nums = {5,5,10,10,20}; // false

        boolean ret = solution.lemonadeChange(nums) ;
        System.out.println(ret);
    }

}