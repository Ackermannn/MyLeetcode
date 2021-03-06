# 接雨水

## 问题

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

![Alt](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png)

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：<https://leetcode-cn.com/problems/trapping-rain-water>

## 思路

1.先找到最高的柱子.

2.从最左边开始扫描，能接住雨水的洼地，一直扫描到最高的柱子.扫描的时候记录历史最高的柱子高度为h，如果当下的高度height低于h,则
累加到water += h - height

3.从右边开始重复上面的操作.

## cpp代码

```cpp
#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;
class Solution {
public:
	int trap(vector<int>& height) {
  	if (height.empty()) return 0;
		stack<int> column;
		int water = 0;
		vector<int>::iterator biggest = max_element(height.begin(), height.end());
		int biggest_index = distance(height.begin(), biggest);
		column.push(0);
		for (int j = 0; j <= biggest_index; j++) {
			int i = height[j];
			if (i <= column.top()) water += column.top() - i;
			else column.push(i);
		}
		column.push(0);
		for (int j = height.size() - 1; j >= biggest_index; j--) {
			int i = height[j];
			if (i <= column.top()) water += column.top() - i;
			else column.push(i);
		}
		return water;
	}
};
// 执行用时4ms 击败97.62% 
int main() {
	vector<int> height = { 0,1,0,2,1,0,1,3,2,1,2,1 };
	Solution s;
 int water = s.trap(height);
 cout << water << endl;
 return 0;
}
```

## python代码

```python
class Solution:

    def trap(self,height):
        if not height: return 0
        hei_idx = height.index(max(height))
        water = column = 0
        for i in height[:hei_idx]:
            if i < column: water += column - i
            else: column = i
        column = 0
        for i in height[hei_idx:][::-1]:
            if i < column: water += column - i
            else: column = i
        return water


if __name__ == '__main__':
    s = Solution()
    height =  [2,1,23,1,15]
    print("the answer is: ",s.trap(height))
```
