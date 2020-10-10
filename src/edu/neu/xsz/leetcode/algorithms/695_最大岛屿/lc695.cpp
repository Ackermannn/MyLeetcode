// https://leetcode-cn.com/problems/max-area-of-island/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ans = 0;
        int row = grid.size(), col = grid[0].size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int* area = new int{ 0 };
                if (grid[i][j] == 1) {
                    calculateArea(grid, i, j, area, row, col);
                    ans = max(*area, ans);
                }
                delete area;
            }
        }
        return ans;
    }
	// 递归法 dfs
    void calculateArea(vector<vector<int>>& grid, int i, int j, int* area, int& row, int& col) {
        grid[i][j] = 0;
        *area = *area + 1;
        if (i + 1 < row && grid[i + 1][j] == 1) calculateArea(grid, i + 1, j, area, row, col);
        if (i - 1 >= 0 && grid[i - 1][j] == 1) calculateArea(grid, i - 1, j, area, row, col);
        if (j + 1 < col && grid[i][j + 1] == 1) calculateArea(grid, i, j + 1, area, row, col);
        if (j - 1 >= 0 && grid[i][j - 1] == 1) calculateArea(grid, i, j - 1, area, row, col);
    }
};

int main() {

    Solution so;
    vector<vector<int>> grid = { {0,1},{1,1} };
/*                            { {0, 0, 1, 0, 0, 0 },
                            {  0, 0, 1, 0, 1, 0 },
                            {  0, 1, 1, 0, 1, 0 },
                            {  0, 0, 0, 0, 0, 0 } };*/

    int ans = so.maxAreaOfIsland(grid);
    cout << ans << endl;






    return 0;
}