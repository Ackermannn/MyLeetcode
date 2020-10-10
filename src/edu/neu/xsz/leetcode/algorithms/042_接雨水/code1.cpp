#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;
class Solution {
public:
	int trap(vector<int>& height) {
		if (height.empty()) return 0;
		stack<int> column;
		int water = 0;
		vector<int>::iterator biggest = max_element(height.begin(), height.end());
		int biggest_index = distance(height.begin(), biggest);
		column.push(0);
		for (int j = 0; j <= biggest_index; j++) {
			int i = height[j];
			if (i <= column.top()) water += column.top() - i;
			else column.push(i);
		}
		column.push(0);
		for (int j = height.size() - 1; j >= biggest_index; j--) {
			int i = height[j];
			if (i <= column.top()) water += column.top() - i;
			else column.push(i);
		}
		return water;
	}
};
// 执行用时4ms 击败97.62% 
int main() {
	vector<int> height = { 0,1,0,2,1,0,1,3,2,1,2,1 };
	Solution s;
	int water = s.trap(height);
	cout << water << endl;
	return 0;
}
