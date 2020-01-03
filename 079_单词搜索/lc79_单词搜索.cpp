#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution{
public:
bool cross_exist(vector<vector<char>>& board, string word, pair<int, int> start, int& row, int& col) 
{
	int p1 = start.first, p2 = start.second;
	char c = word[0];
	if (word.empty() != true) word.erase(word.begin(), word.begin() + 1);
	else return true;
	// 下
	if (p1 != row - 1) {
		pair<int, int> v = { p1 + 1, p2 };
		if (board[v.first][v.second] == c) {
			board[v.first][v.second] = '.';
			bool ans = cross_exist(board, word, v, row, col);
			board[v.first][v.second] = c;
			if (ans) return true;
		}
	}
	// 上
	if (p1 != 0) {
		pair<int, int> v = { p1 - 1, p2 };
		if (board[v.first][v.second] == c) {
			board[v.first][v.second] = '.';
			bool ans = cross_exist(board, word, v, row, col);
			board[v.first][v.second] = c;
			if (ans) return true;
		}
	}
	// 左
	if (p2 != 0) {
		pair<int, int> v = { p1 , p2 - 1 };
		if (board[v.first][v.second] == c) {
			board[v.first][v.second] = '.';
			bool ans = cross_exist(board, word, v, row, col);
			board[v.first][v.second] = c;
			if (ans) return true;
		}
	}
	// 右
	if (p2 != col - 1) {
		pair<int, int> v = { p1 , p2 + 1 };
		if (board[v.first][v.second] == c) {
			board[v.first][v.second] = '.';
			bool ans = cross_exist(board, word, v, row, col);
			board[v.first][v.second] = c;
			if (ans) return true;
		}
	}
	return false;
}
bool exist(vector<vector<char>>& board, string word) 
{
	int row = board.size();//行数
	int col = board[0].size(); // 列数
	vector<vector<int>> pos1 = {};
	if (word.size() > (row * col)) return false;

	// 找第一个字母
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			if (board[i][j] == word[0])
				pos1.push_back({ i,j });
		}
	}

	if (pos1.empty()) return false;
	else {
		char c = word[0];
		word.erase(word.begin(), word.begin() + 1);
		for (auto x : pos1) {
			pair<int, int> start;
			start.first = x[0];
			start.second = x[1];
			// 修改 board
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