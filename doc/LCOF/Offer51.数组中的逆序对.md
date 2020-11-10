# 剑指 Offer 51. 数组中的逆序对

## 问题
 
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 
 
 
 示例 1:
 
     输入: [7,5,6,4]
     
     输出: 5
 
 
 限制：
 
     0 <= 数组长度 <= 50000
 
 来源：力扣（LeetCode）
 
 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof

## 解答

参见官方视频解答，可让您大彻大悟！

https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/

### Code



```java

public class Solution {
    private int ans = 0; // 存储答案

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) return ans;
        mergeSort(nums);
        return this.ans;
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) return;

        // 分出去两半
        int[] left = new int[len / 2];
        int[] right = new int[len - len / 2];
        int i = 0;
        for (; i < left.length; i++) {
            left[i] = nums[i];
        }
        for (int j = 0; j < right.length; j++, i++) {
            right[j] = nums[i];
        }

        // 递归调用
        mergeSort(left);
        mergeSort(right);

        // 归并排序
        int pl = 0; // 左指针
        int pr = 0; // 右指针
        for (int k = 0; k < len; k++) {
            if (pl < left.length && (pr >= right.length || left[pl] <= right[pr])) {
                nums[k] = left[pl];
                pl++;
            } else {
                nums[k] = right[pr];
                this.ans += left.length - pl;  // 对逆序进行计数
                pr++;
            }
        }
    }
}
```