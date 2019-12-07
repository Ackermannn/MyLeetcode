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
int main() {
	Solution solv;
	string s = "ZY";
	int ans = solv.titleToNumber(s);
	cout << ans << endl;
	return 0;
}