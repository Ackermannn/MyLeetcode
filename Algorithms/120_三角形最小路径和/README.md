# 题目

给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

[题目地址](https://leetcode-cn.com/problems/triangle/)

# 解答

自己的自上而下的动态规划
```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>(triangle);

        for (int i = 1; i < dp.size(); i++) {
            List<Integer> line = dp.get(i);
            for (int j = 0; j < line.size(); j++) {
                if (j == 0) line.set(j, dp.get(i - 1).get(j) + line.get(j));
                else if (j == line.size() - 1) line.set(j, dp.get(i - 1).get(j - 1) + line.get(j));
                else {
                    line.set(j,
                            Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1)) + line.get(j)
                    );
                }
            }
        }

        return Collections.min(dp.get(dp.size()-1));
    }
}
```

评论区大佬的自下而上的方法，[传送门](https://leetcode-cn.com/problems/triangle/comments/2532)
```cpp
int minimumTotal(vector<vector<int>> &triangle)
{
    for (int i = triangle.size() - 2; i >= 0; i--)
        for (int j = 0; j < triangle[i].size(); j++)
            triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1]);
    return triangle[0][0];
}
```
