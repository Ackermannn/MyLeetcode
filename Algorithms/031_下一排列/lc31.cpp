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