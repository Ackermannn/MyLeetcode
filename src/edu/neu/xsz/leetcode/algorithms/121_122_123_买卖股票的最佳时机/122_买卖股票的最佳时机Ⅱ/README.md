# Question

https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

# Solution

## 版本一

这个想复杂了

```cpp

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		vector<int> ep,process;
		if (prices.empty()) return 0;
		
		// 横盘处理
		process = handleLine(prices);
		//for (vector<int>::iterator iter = prices.begin(); iter < prices.end() - 1;iter++) 
		//{
		//	if (*iter == *(iter + 1)) { prices.erase(iter, iter + 1);  };//iter--;
		//}
		
		ep = findExtremePoint(process);
		int ep_size = ep.size(), res = 0;

		if ((ep[1] - ep[0]) > 0) {    //  先上升   0 1 2
			for (int i = 0; i < ep_size - 1; i += 2)
			{
				res += ep[i + 1] - ep[i];
			}
		
		}
		else                     //  先下升   0 1 2
		{
			for (int i = 1; i < ep_size - 1; i += 2)
			{
				res += ep[i + 1] - ep[i];
			}
		}
		
		return res;
	}
private:
	vector<int> findExtremePoint(vector<int>& nums)
	{	// 找极值点 + 端点
		vector<int> res;
		res.push_back(nums.front());
		for (int i = 1; i < nums.size() - 1; i++)
		{
			//if (nums[i] == nums[i - 1]) continue;
			if ((nums[i-1] - nums[i]) * (nums[i] - nums[i + 1]) < 0) res.push_back(nums[i]);
		}
		res.push_back(nums.back());
		return res;
	}
	vector<int> handleLine(vector<int>& nums) {
		vector<int> out;
		for (int i = 0; i < nums.size() - 1; i++) 
		{
			if (nums[i] == nums[i + 1]) continue;
			out.push_back(nums[i]);
		}
		out.push_back(nums.back());
		return out;
	
	}
};
int main() {
	Solution s;
	vector<int> nums = { 0,0,1,1,2,1,1,0 };
	cout << s.maxProfit(nums) << endl;
	return 0;
}

```

## 版本二

[7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），所以一般人可能会想，怎么判断不是第三天就卖出了呢? 这里就把问题复杂化了，根据题目的意思，当天卖出以后，当天还可以买入，所以其实可以第三天卖出，第三天买入，第四天又卖出（（5-1）+ （6-5） === 6 - 1）。所以算法可以直接简化为只要今天比昨天大，就卖出。
[REF](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/comments/42837)

C++ 代码
```cpp
class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int res = 0;
		if (prices.size() <= 1) return 0;
		for (int i = 1; i < prices.size(); i++) {
			if ((prices[i] - prices[i - 1]) > 0) res += (prices[i] - prices[i - 1]);
		}
		return res;
	}
};
```
java 版本
```java
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int ret =0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                ret += prices[i] - prices[i-1];
        }
        return ret;

    }
}

```
