#pragma execution_character_set("utf-8")
#include <iostream>
class Solution {
public:
	int positiveDiv(int dividend, int divisor) {
		// �˺������� �����뱻��������������ʱ�����
		int ans = 0, store_divisor = divisor; // ���� �����Ա��ݹ�
		int time = 1;
		if (dividend < divisor) return 0;
		while (dividend >= divisor) {
			ans = ans + time;
			dividend -= divisor;
			if (time > INT_MAX / 2) break; // ��ֹ���,���ѭ��
			time = time + time; // �̵���ֵ����
			if (divisor > INT_MAX / 2) break; // ��ֹ���,���ѭ��
			divisor += divisor; // ����������

		}

		return positiveDiv(dividend, store_divisor) + ans;
	}

	int divide(int dividend, int divisor) {
		int ans = 0;
		
		// ���� ������ Ϊ INT_MIN ʱ��Ĵ���
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