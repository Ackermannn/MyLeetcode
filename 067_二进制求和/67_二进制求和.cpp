#include<iostream>
using namespace std;
class Solution {
public:
	string addBinary(string a, string b) {
		if (a.size() < b.size()) swap(a, b); // set a is longer one
		string ans = "";
		int flag = 0;
		auto iter_b = b.rbegin();
		for (auto iter_a = a.rbegin(); iter_a < a.rend(); iter_a++) {
			int num1 = *iter_a - '0';
			int num2;
			if (iter_b != b.rend()) {
				num2 = *iter_b - '0';
				iter_b++;
			}
			else num2 = 0;
			ans = char((num1 ^ num2 ^ flag) + '0') + ans;
			flag = ((num1 & num2) | (flag & (num1 ^ num2)));
		}
		if (flag == 1) {
			ans = '1' + ans;
		}
		return ans;

	}
};
int main() {
	string a = "10101";
	string b = "111";
	Solution solu;
	auto ans = solu.addBinary(a, b);
	cout << "ans = \n"<<ans << endl;
}