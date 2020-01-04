#include<iostream>
using namespace std;
class Solution {
public:
	int strStr(string haystack, string needle) {
		int ans = -1;
		if (needle.empty()) return 0;
		int start = 0, end = start + needle.size() - 1;

		for (; end < haystack.size(); end++,start++) 
			if (haystack.substr(start, needle.size()) == needle) return start;
		
		return ans;
	}

};

int main() {
	Solution solv;
	string hay = "hello", needle = "lo";
	int ans = solv.strStr(hay, needle);
	cout << ans << endl;

	//cout << (hay == "hello");
	return 0;
}