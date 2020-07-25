# 问题
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

```
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
```
```
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
```
来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array

# 解答

直接使用自带的查找算法查找第一个出现的 target , 结尾的targer查找有两个方法:

1. 把nums倒过来直接查找

2. 把指向第一个target的指针一直向右移动直到找到尾巴


# 代码

## python 使用法1
```python
def searchRange(nums, target):
    length = len(nums)
    ans = [-1, -1]
    if target in nums:
        ans[0] = nums.index(target)
        ans[1] = length - 1 - nums[::-1].index(target)
    return ans
```
## c++ 使用法2
```cpp
vector<int> searchRange(vector<int>& nums, int target) {
  vector<int>::iterator ans1 = find(nums.begin(), nums.end(), target);
  vector<int> ans = { -1, -1 };
  if (ans1 != nums.end())
  {
      ans[0] = ans1 - nums.begin();
      while (ans1 != nums.end() and *ans1 == target)
      {
          ans[1] = ans1 - nums.begin();
          ans1++;
      }
  }
  return ans;
```

# 第三种解法

分别编写左边界二分法查找和右边界二分法查找

```java
class Solution {
    public int[] nums;
    int target;
    int size;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.size = nums.length;
        int resLeft = leftBinarySearch(-1, size);
        int resRight = rightBinarySearch(-1, size);
        return new int[]{resLeft, resRight};
    }

    public int leftBinarySearch(int start, int end) {
        if (start + 1 >= end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] < target) return leftBinarySearch(mid, end);
        else if (target < nums[mid]) return leftBinarySearch(start, mid);
        else  {
            if (mid != 0) {
                if (nums[mid] == nums[mid - 1]) {
                    return leftBinarySearch(start, mid);
                } else return mid;
            } else return 0;
        }
    }

    public int rightBinarySearch(int start, int end) {
        if (start + 1 >= end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] < target) return rightBinarySearch(mid, end);
        else if(target < nums[mid]) return rightBinarySearch(start, mid);
        else {
            if (mid != size - 1) {
                if (nums[mid] == nums[mid + 1]) {
                    return rightBinarySearch(mid, end);
                } else return mid;
            } else return size - 1;
        }
    }
}
```
