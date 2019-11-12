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
    
