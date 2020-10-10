#include<iostream>
#include <vector>
using namespace std;
class Solution {
public:

	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>>* res = new vector<vector<int>>; // 复习动态内存声明
		get_left({}, nums, res);
		return *res;
	}

	void get_left(vector<int> offered, vector<int> candidate, vector<vector<int>>* res) { 
		for (int i = 0; i < candidate.size(); i++) {

			// 恭喜候选人 i 号被选中了,给你发送 offer
			offered.push_back(candidate[i]); 

			// 剩下的未选中的候选人,去sub_candidate等候吧
			vector<int> sub_candidate = candidate; 
			sub_candidate.erase(sub_candidate.begin() + i);

			if (sub_candidate.empty() != 1) {
				get_left(offered, sub_candidate, res); // 来让我们考虑在未选中的人中选择下一个
			}
			else {
				res->push_back(offered); // 嗯, 没剩下的了
			}
			offered.pop_back(); // emmm, 如果我不考虑你呢? 可爱的i号候选人
		}
	};

};

int main() {
	vector<int> x = { 1,2,3,4 };
	Solution sol;
	auto res = sol.permute(x);
	return 0;
}
