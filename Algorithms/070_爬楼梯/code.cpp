#include<iostream>
using namespace std;
class Solution {
public:
	// 递归法 太慢了 n=37 时 超出时间限制
	int climbStairs(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n >= 3) return (climbStairs(n - 1) + climbStairs(n - 2));

	}
	// 类似斐波那契数列
	int climbStairs2(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		int a1 = 0, a2 = 1, a3 = 2;
		if (n >= 3) {
			
			for (int i = 0; i < n - 2; i++) {
				a1 = a2;
				a2 = a3;
				a3 = a1 + a2;
			}
			return a3;
		}
	
	
	}
};
int main() {
	Solution solu;
	cout << solu.climbStairs2(37) << endl;
	return 0;

}
