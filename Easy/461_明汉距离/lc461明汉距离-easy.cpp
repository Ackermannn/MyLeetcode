#include<iostream>
/*
*leetcode 461
*
*��������֮��ĺ�������ָ�������������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
*
*������������ x �� y����������֮��ĺ������롣
*
*
*����:
*����: x = 1, y = 4
*���: 2
*����:
*1   (0 0 0 1)
*4   (0 1 0 0)
*       ��   ��
*����ļ�ͷָ���˶�Ӧ������λ��ͬ��λ�á�
*
*���ӣ�https://leetcode-cn.com/problems/hamming-distance
*
*/



using namespace std;

class Solution {
public:
	int hammingDistance(int x, int y) {
		int temp = x ^ y, ans = 0;
		// ��temp �� 1 �ĸ�������
		while (temp != 0) {
			ans += temp % 2;
			temp = temp / 2;
		}
		return ans;
	}
};

int main() {
	Solution solv;
	int ans, x, y;
	cout << "�ֱ�������������: " << endl;
	cin >> x >> y;
	ans = solv.hammingDistance(x, y);
	cout << x << " �� "<< y <<" �ĺ�������Ϊ: " << ans << endl;
	//cout << "������ 1 ^ 2 = " << (1 ^ 2) << endl;
	//cout << "ȡ����� 3 % 2 = " << (3 % 2) << endl;
	return 0;
}