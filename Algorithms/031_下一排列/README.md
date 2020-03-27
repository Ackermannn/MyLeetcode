# 题目地址

https://leetcode-cn.com/problems/next-permutation/

# 解答
link:

https://leetcode-cn.com/problems/next-permutation/comments/6790

这道题没做出来，看了答案，解题思路应该是

判断按照字典序有木有下一个，如果完全降序就没有下一个

如何判断有木有下一个呢？只要存在a[i-1] < a[i]的升序结构，就有，而且我们应该从右往左找，一旦找到，
因为这样才是真正下一个

当发现a[i-1] < a[i]的结构时，从在[i, ∞]中找到最接近a[i-1]并且又大于a[i-1]的数字，由于降序，
从右往左遍历即可得到k

然后交换a[i-1]与a[k]，然后对[i, ∞]排序即可，排序只需要首尾不停交换即可，因为已经是降序
上面说的很抽象，还是需要拿一些例子思考才行，比如[0,5,4,3,2,1]，下一个是[1,0,2,3,4,5]

# 代码

```cpp
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        
        int size = nums.size();
        int i = size - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) { // 找到结构
                int k = 0, distance = INT_MAX;
                for (int j = size - 1; j >= i; j--) { // 找到最接近且大于
                    int temp = nums[j] - nums[i - 1];
                    if (temp > 0 && temp < distance) {
                        distance = temp;
                        k = j;
                    }
                }
                swap(nums[i - 1], nums[k]); 
                break;
            }
        }
        sort(nums.begin() + i, nums.end());

    }
};
int main() {
    Solution solv;
    vector<int> vec = { 4,2,0,2,3,2,0 };// { 1,4,3,2 };
    solv.nextPermutation(vec);
    
    for (int x : vec) {
        cout << x << ",";
    }
    cout << endl;

    return 0;
}
/*
执行结果：通过
显示详情
执行用时 :4 ms, 在所有 C++ 提交中击败了87.93%的用户
内存消耗 :6.9 MB, 在所有 C++ 提交中击败了100.00%的用户
*/
```