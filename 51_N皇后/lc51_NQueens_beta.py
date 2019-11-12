'''
用数组X = [x1, x2, ..., xi, ..., xn]保存皇后i的位置坐标(i,xi) 即i行xi列是皇后的坐标

对 X 进行全排列,列出所有全排列的可能,

当 X 有 xi = xj + j - i 或者 xi = xj + i - j 情况排除它

    因为皇后(i,xi),(j,xj)在对角线时,必在 y+x=b 或 y-x=b 的直线上

    x1+y1=b=x2+y2 or x1-y1=b=x2-y2

    (i,xi) 带入 (x1,y1) ,(j, xj) 带入(x2,y2)

    得i + xi = j + xj or i - xi = j - xj
    
最后剩下的情况是本问题的解

'''
import itertools

def insert(p,n):
    return "."*(p-1) + "Q" + "."*(n-p)

def draw(x, n): # 输入数组 每个元素是
    res = [] 
    for i in x:
        res.append(insert(i+1,n))
    return res

def check(i):
    for ii in range(len(i)-1):
       for jj in range(ii+1,len(i)):
           if i[ii] == i[jj] + jj - ii or i[ii] == i[jj] + ii - jj:
               return False
    return True

class Solution:
    def solveNQueens(self, n: int):
        a=itertools.permutations(list(range(n)))
        ans = []
        for i in a:
            if check(i):
                ans.append(draw(i, n))
        return ans
    
