# 题目描述

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"LEETCODEISHIRING"` 行数为 3 时，排列如下：
```

L   C   I   R

E T O E S I I G

E   D   H   N
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

`string convert(string s, int numRows);`

**示例 1:**

	输入: `s = "LEETCODEISHIRING", numRows = 3`

	输出: `"LCIRETOESIIGEDHN"`

**示例 2:**

	输入: `s = "LEETCODEISHIRING", numRows = 4`

	输出: `"LDREOEIIECIHNTSG"`

**解释:**

```

L     D     R

E   O E   I I

E C   I H   N

T     S     G
```



# 解

找规律而已, Z字形把字符分成一组一组的,在示例1 中 LEET, CODE, ISHI, RING 被分成4组, 每组成员有`2 * numRows - 2`个

第一次循环输出 每个分组的第一个, 输出 L, C, I, R

第二次循环考虑 分组的 第2个 与 倒数第2个, 连着把这两个字符输出来: EE, OD, SH, IN

如果成员个数大于1, 如同上次循环 考虑 第k个 和倒数第k个,

直到每组剩下最后一个字符,输出它们: E, D, H, N

## code
```cpp
#include<iostream>
using namespace std;
class Solution {
public:
	string convert(string s, int numRows) {
		string ans;
		if (numRows == 1) return s;
		int groupLen = 2 * numRows - 2;
		for (int groupIndex = 0; groupIndex < numRows; groupIndex++) {
			if (groupIndex == 0 or groupIndex == numRows - 1) {
				for (int i = groupIndex; i < s.size(); i += groupLen) {
					ans.push_back(s[i]);
				}
			}
			else {
				for (int i = groupIndex; i < s.size(); i += groupLen) {
					ans.push_back(s[i]);
					if (i + groupLen - 2 * groupIndex < s.size())
						ans.push_back(s[i + groupLen - 2 * groupIndex]);
				}


			}
		}
		return ans;

	}
};
int main() {
	string s = "LEETCODEISHIRING";
	int numRows = 2;
	Solution solu;
	cout << solu.convert(s, numRows) << endl;

	return 0;
}
```

来源：力扣（LeetCode）

链接：https://leetcode-cn.com/problems/zigzag-conversion
