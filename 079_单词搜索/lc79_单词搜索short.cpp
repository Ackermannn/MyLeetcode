#include<iostream>
#include<vector>
#include<algorithm>
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

链接：https://leetcode-cn.com/problems/word-search


解法:

深度优先算法
link: https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/

*/
using namespace std;
class Solution{
public:
bool cross_exist(vector<vector<char>>& board, string word, pair<int, int> start, int& row, int& col) 
{
	/*
	* 从给出的起始点 start 上下左右 寻找符合条件的单词
	*/
	int p1 = start.first, p2 = start.second;
	char c = word[0];
	if (word.empty() != true) word.erase(word.begin(), word.begin() + 1);
	else return true;
	
	vector<vector<int>> bias = { {1,0},{-1,0},{0,1},{0,-1} }; // 上下左右 四个方向查找
	for (auto x : bias) {
		pair<int, int> v = { start.first, start.second };
		v.first += x[0];
		v.second += x[1];
		if (v.first >= 0 and v.first <row and v.second >= 0 and v.second < col // 超出边界检查
			and board[v.first][v.second] == c)
		{
			board[v.first][v.second] = '.';
			if (cross_exist(board, word, v, row, col)) return true; // 递归
			board[v.first][v.second] = c;
		}
	}
	return false;
}
bool exist(vector<vector<char>>& board, string word) 
{
	int row = board.size();//行数
	int col = board[0].size(); // 列数
	vector<vector<int>> pos1 = {};
	if (word.size() > (row * col)) return false; //如果 string太长,一定是找不到单词的

	// 遍历找第一个字母, 所有结果保存起来
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			if (board[i][j] == word[0])
				pos1.push_back({ i,j });
		}
	}

	if (pos1.empty()) return false; // 找不到第一个字母,自然是找不到单词的
	else {
		char c = word[0];
		word.erase(word.begin(), word.begin() + 1);
		// 对所有满足第一单词的位置进行遍历 调用cross_exist()
		for (auto x : pos1) {
			pair<int, int> start;
			start.first = x[0];
			start.second = x[1];
			// 修改 board, 防止单词被使用多次
			board[start.first][start.second] = '.';
			bool ans = cross_exist(board, word, start, row, col);
			// 改回来
			board[start.first][start.second] = c;
			if (ans == true) return true;
		}
		return false;
	}
}

};


int main() {
	Solution solv;
	// 测试1
	//vector<vector<char>> board = { {'A','B','C','E'},
	//							     {'S','F','E','S'},
	//							     {'A','D','E','E'} };

	//string word = "CESEEE";

	// 测试2
	vector<vector<char>> board = { {'A','A','A','A'},
							       {'A','A','A','A'},
								   {'A','A','A','A'},
								   {'A','A','A','A'},
							       {'A','A','A','B'} };

	string word = "AAAAAAAAAAAAAAAAAAAA";

	auto ans = solv.exist(board, word);
	cout << ans << endl;
	return 0;

}