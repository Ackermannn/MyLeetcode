# -*- coding: utf-8 -*-
"""
Created on Thu Oct 24 16:13:47 2019

@author: Ackerman
"""

class Solution:
    def isValidSudoku(self, board):
        def checkTemp(temp):
            for i in range(9):
                if temp[i] != ".":
                    ans = temp.count(temp[i])
                    if ans != 1:
                        return False
            return True
        
        # 行检查
        for j in range(9):
            temp = board[j]
            if not checkTemp(temp): return False
                
        # 列检查
        for j in range(9):
            temp = [line[j] for line in board]
            if not checkTemp(temp): return False
                        
        
        # 小方格检查
        for i,j in zip([0,0,0,1,1,1,2,2,2],[0,1,2,0,1,2,0,1,2]):
            temp = []   
            temp += board[i*3][j*3:j*3+3] + board[i*3+1][j*3:j*3+3] + board[i*3+2][j*3:j*3+3]
            if not checkTemp(temp): return False
        
        return True
    
board = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
 ]
solu = Solution()
#    print(temp)
print(solu.isValidSudoku(board))
    
    
    
    
    
    
    
    
    
    
    
    
    
    