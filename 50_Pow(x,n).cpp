#include<iostream>
using namespace std;
class Solution {
public:

	double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n < 0) 
		{
			long long n0 = n;
			return 1 / myPowzz(x, -n0);
		}
		else
			return myPowzz(x, n);
	}
	
	double myPowzz(double x, long long n) 
	{
		double res = x;
		long long m = 1;
		if (n == 0) return 1;
		if (n == 1) return x;
		while (m * 2 <= n) {
	
			res *= res;
			m *= 2;
		}
		return res * myPowzz(x, n - m);
	}
	

	// 超时的算法
	double myPow1(double x, int n) {

		double res = 1;
		if (x == 1) return 1;
		if (n == 0) return 1;
		else if (n > 0) {
			while (n)
			{
				res *= x;
				n--;
			}
			return res;
		}
		else
		{
			if (n == INT_MIN)
			{
				n = INT_MAX;
				while (n)
				{
					res *= x;
					n--;
				}
				return 1 / (res * x);
			}
			else
			{

				n = abs(n);
				while (n)
				{
					res *= x;
					n--;
				}
				return 1 / res;
			}

		}

	}
	// 超时的递归
	double mypowz(double x, long long n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		if (n % 2 == 0) return mypowz(x, n / 2) * mypowz(x, n / 2);
		else
			return mypowz(x, (n - 1) / 2) * mypowz(x, (n - 1) / 2) * x;
	}
};

int main() 
{
	Solution s;
	double x = 2;
	int n = INT_MIN;
	std::cout << s.myPow(x, n) << std::endl;
	cout << pow(x,n) << endl;
	return 0;
}