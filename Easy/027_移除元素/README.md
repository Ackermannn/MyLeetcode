# 题目描述

给定一个数组 `nums` 和一个值 `val`，你需要原地移除所有数值等于 `val` 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 `O(1)` 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

链接：https://leetcode-cn.com/problems/remove-element

**示例**:

    给定 nums = [3,2,2,3], val = 3,

    函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

    你不需要考虑数组中超出新长度后面的元素。

# 解决方案: 双指针

## 思路

既然问题要求我们就地删除给定值的所有元素，我们就必须用 O(1) 的额外空间来处理它。
如何解决？我们可以保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。

## 算法

当 `nums[j]` 与给定的值相等时，递增`j`以跳过该元素。只要 `nums[j]` != `val` ，我们就复制 `nums[j]` 到 `nums[i]` 
并同时递增两个索引。重复这一过程，直到 `j` 到达数组的末尾，该数组的新长度为 `i`。

链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/

# 代码

```cpp
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        		int i = 0, j;
		for (j = 0; j < nums.size(); j++) {
			if (nums[j] != val)
			{
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
    }
};
```
