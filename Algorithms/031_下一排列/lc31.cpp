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
            if (nums[i - 1] < nums[i]) { // �ҵ��ṹ
                int k = 0, distance = INT_MAX;
                for (int j = size - 1; j >= i; j--) { // �ҵ���ӽ��Ҵ���
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
ִ�н����ͨ��
��ʾ����
ִ����ʱ :4 ms, ������ C++ �ύ�л�����87.93%���û�
�ڴ����� :6.9 MB, ������ C++ �ύ�л�����100.00%���û�
*/