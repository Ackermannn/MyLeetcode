# 问题描述

给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:

    输入: "A"
    输出: 1
    
示例 2:

    输入: "AB"
    输出: 28

示例 3:

    输入: "ZY"
    输出: 701

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/excel-sheet-column-number

# 题解方案

26进制转换问题而已. 

1. 从左边开始循环,将第n位字符转化为数字 a = s - 'A' + 1

2. 该位置的数字a 乘以 26^n, n为位数

3. 累加 sum += a * 26^n

# Code
```cpp
#include<iostream>
using namespace std;
class Solution {
public:
	int titleToNumber(string s) {
		int sum = 0, n = 0;
		for (auto i = s.rbegin(); i < s.rend(); i++) {
			int a = (*i - 'A') + 1;
			sum += a * pow(26, n);
			n++;
		
		}
		return sum;
	}
};
```
