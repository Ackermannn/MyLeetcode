/*
题目地址：
https://leetcode-cn.com/problems/edit-distance/

编辑最小距离

解答：

动态规划

维护一个二位数组

dp[i][j] 代表 word1的从最左边到第i个位置的截取子串 与 word2的从最左边到第j个位置的截取子串 之间的编辑距离

状态转移方程：
从官方题解中可以启发到

当下的dp 是 one: word1在尾部插入 + 1
			two: word2在尾部插入 + 1
			three: 和word1尾部改变 三个情况中 取最小

即 
dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j] + 1) 尾部字符不同word1[i]=word[j]
dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j] ) 尾部字符相同word1[i]=word[j]

*/
#include <iostream>
#include<vector>
#include<algorithm>
//using namespace std::numeric_limits;
using namespace std;

class Solution {
public:
	int minDistance(string word1, string word2) {
		int n = word1.size() + 1, m = word2.size() + 1;
		vector<int> line(m, 0);
		vector<vector<int>> dp(n, line);
		int a, b, c;
		for (int i = 0; i < n; i++) { // 算出整个矩阵的数题目就解决了
			for (int j = 0; j < m; j++) {
				if (i == 0 and j == 0) dp[i][j] = 0; // 两个都是空串的情况
				else if (i == 0 or j == 0) dp[i][j] = max(i, j); // 其中有一个是空串的情况
				else {
					a = dp[i - 1][j] + 1; // 第一个串尾部插入一个字符
					b = dp[i][j - 1] + 1; // 第二个串尾部插入一个字符
					if (word1[i - 1] == word2[j - 1])  // 两个串的尾部的字符都相同
						c = dp[i - 1][j - 1];
					else // 两个串的尾部的字符都不同
						c = dp[i - 1][j - 1] + 1;
					dp[i][j] = min(min(a, b), c);
				}
			}
		}
		for (auto x : dp) {
			for (int i : x) {
				cout << i << ',';
			}
			cout << endl;
		}
		return dp[n - 1][m - 1]; // 最后一个数就是答案

	}
};

int main()
{
	Solution* sol = new Solution();
	//string word1 = "horse", word2 = "ros";
	//string word1 = "cat", word2 = "cdad";
	string word1 = "plasma", word2 = "altruism"; // 6
	int ret = sol->minDistance(word1, word2);
	cout << ret << endl;
}


