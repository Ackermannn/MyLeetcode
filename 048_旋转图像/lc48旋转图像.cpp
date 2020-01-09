#include<iostream>
#include<vector>
/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

链接：https://leetcode-cn.com/problems/rotate-image
*/
using namespace std;
class Solution {
public:
	// 使用一个cache 按照旋转后的顺序读取
	// 再把原来的 matrix 赋值
	// 空间复杂度 O(n^2)
	void rotate(vector<vector<int>>& matrix) {
		vector<int> cache;
		int row = matrix.size(), col = matrix[0].size();
		for (int i = 0; i < col; i++) {
			for (int j = row - 1; j >= 0; j--) {
				cache.push_back(matrix[j][i]);
			}
		}

		reverse(cache.begin(), cache.end());

		for (auto &x : matrix) {
			for (auto& y : x) {
				y = cache.back();
				cache.pop_back();
			}
		
		}


	}
};

class Solution1 {
public:
	// 先转置 再对称 , 测试给出的图想都是方形的
	void rotate(vector<vector<int>>& matrix) {
		int n = matrix.size();

		//转置
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				swap(matrix[i][j], matrix[j][i]);
			}
		}

		//对称
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				swap(matrix[i][j], matrix[i][n-1-j]);
			}
		
		}

	}


};
int main() {

	vector<vector<int>> matrix = { {1,2,3},
								   {4,5,6},
								   {7,8,9} };
	//Solution s;
	//s.rotate(matrix);

	Solution1 s1;
	s1.rotate(matrix);
	return 0;
}