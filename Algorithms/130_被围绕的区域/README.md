
https://leetcode-cn.com/problems/surrounded-regions/

dfs 递归

首先对边界上每一个'O'做深度优先搜索，将与其相连的所有'O'改为'-'。然后遍历矩阵，将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O'  [来源](https://leetcode-cn.com/problems/surrounded-regions/comments/8717)

```java
class Solution {
    int row;
    int col;
    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        
        // 在边界上开始dfs
        for(int i = 0; i < col; i++){
            dfs(board, 0, i);
            dfs(board, row-1, i);
        }
        for(int i = 0; i < row; i++){
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        // 把 #改O O改X
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        if (board[i][j] != 'O') return;
        else {
            board[i][j] = '#';
            // 上下左右动起来
            if(i !=  0)    dfs(board, i-1, j);
            if(i != row-1) dfs(board, i+1, j);
            if(j != 0)     dfs(board, i, j-1);
            if(j != col-1) dfs(board, i, j+1);

        }
    }
}
```
