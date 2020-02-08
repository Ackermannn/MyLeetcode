#pragma execution_character_set("utf-8")
#include <iostream>
class Solution {
public:
	int positiveDiv(int dividend, int divisor) {
		// 此函数可以 除数与被除数都是正整数时的情况
		int ans = 0, store_divisor = divisor; // 储存 除数以备递归
		int time = 1;
		if (dividend < divisor) return 0;
		while (dividend >= divisor) {
			ans = ans + time;
			dividend -= divisor;
			if (time > INT_MAX / 2) break; // 防止溢出,打断循环
			time = time + time; // 商的增值翻倍
			if (divisor > INT_MAX / 2) break; // 防止溢出,打断循环
			divisor += divisor; // 被减数翻倍

		}

		return positiveDiv(dividend, store_divisor) + ans;
	}

	int divide(int dividend, int divisor) {
		int ans = 0;
		
		// 除数 被除数 为 INT_MIN 时候的处理
		if (dividend == INT_MIN and divisor == INT_MIN) return 1;
		if (divisor == INT_MIN) return 0;
		if (dividend == INT_MIN) {
			if (divisor == -1) return INT_MAX;
			if (divisor == 1) return dividend;
			dividend += abs(divisor);
			ans += 1;

		}

		ans += positiveDiv(abs(dividend), abs(divisor));
		if ((dividend < 0 and divisor > 0) or (dividend > 0 and divisor < 0)) ans = -ans;
		return ans;
	}
};
//-2147483648
//- 1

//2147483647
//1

//2147483647
//2

//-2147483648
//2

//-2147483648
//- 2147483648
int main() {
	int dividend = INT_MIN, divisor = 2;

	Solution s;
	std::cout << s.divide(dividend, divisor) << std::endl;
	return 0;
}