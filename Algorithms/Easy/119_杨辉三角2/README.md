# 题目-杨辉三角2

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

题目地址：

https://leetcode-cn.com/problems/pascals-triangle-ii/

# 示例

	输入: 3
	输出: [1,3,3,1]
	
# 代码

```cpp
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
	vector<int> getRow(int rowIndex) {
		if (rowIndex == 0)
			return { 1 };
		else
		{
			vector<int> last = getRow(rowIndex - 1); // 递归获取n-1的结果
			vector<int> res;
			res.push_back(1); // 输出开头的1
			for (int i = 1; i < last.size(); i++) {
				res.push_back(last[i - 1] + last[i]);
			}
			res.push_back(1); // 输出结束的1
			return res;
		}
	}
};

int main() {
	Solution solv;
	vector<int> res = solv.getRow(3);

	for (int x : res) {
		cout << x << ", ";
	}


}
```