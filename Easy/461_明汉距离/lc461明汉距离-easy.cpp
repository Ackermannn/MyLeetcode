#include<iostream>
using namespace std;
//leetcode 461
//
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//给出两个整数 x 和 y，计算它们之间的汉明距离。
//
//
//例子 :
//输入: x = 1, y = 4
//输出 : 2
//解释 :
//	1   (0 0 0 1)
//	4   (0 1 0 0)
//	↑   ↑
//	上面的箭头指出了对应二进制位不同的位置。
//
//	链接：https ://leetcode-cn.com/problems/hamming-distance
class Solution {
public:
	int hammingDistance(int x, int y) {
		int temp = x ^ y, ans = 0;
		// 数temp 中 1 的个数即可
		while (temp != 0) {
			ans += temp % 2;
			temp = temp / 2;
		}
		return ans;
	}
};

int main() {
	Solution solv;
	int ans, x, y;
	cout << "分别输入两个整数: " << endl;
	cin >> x >> y;
	ans = solv.hammingDistance(x, y);
	cout << x << " 与 "<< y <<" 的汉明距离为: " << ans << endl;
	//cout << "异或测试 1 ^ 2 = " << (1 ^ 2) << endl;
	//cout << "取余测试 3 % 2 = " << (3 % 2) << endl;
	return 0;
}