#include<iostream>
#include<vector>
using namespace std;
// 镜面反射法
// 12 ms
/* class Solution {   
public:
	vector<int> grayCode(int n) {
		if (n == 0) return { 0 };
		vector<int> temp = grayCode(n - 1), ans = temp;
	
		reverse(temp.begin(), temp.end());
		for (auto& x : temp) {
			x += temp.size();
		}
		ans.insert(ans.end(), temp.begin(), temp.end());
		return ans;
	}
}; */
// 8 ms
class Solution {
public:
    vector<int> grayCode(int n) {
		if (n == 0) return { 0 };
		vector<int> temp = grayCode(n - 1), ans = temp;
		int h = temp.size();
		for (auto i = temp.rbegin(); i < temp.rend(); i++) 
			ans.push_back(*i + h);	
		return ans;
    }
};
int main() {
	Solution solv;
	auto ans = solv.grayCode(4);
	for (auto x : ans) {
		cout << x << ',';
	}
	cout << endl;
	return 0;
}