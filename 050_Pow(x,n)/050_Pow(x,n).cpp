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
};
int main() 
{
	Solution s;
	double x = 2;
	int n = INT_MIN;
	std::cout << s.myPow(x, n) << std::endl;
	return 0;
}
