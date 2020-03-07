#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {


	// 读 取 文 件 中 的 内 容

	fstream f2("data2.txt");
	int str;

	while(f2 >> str)
		cout << str << endl;
	f2.close();

	//
	int water = 0;
	vector<int> nums = { 1,8,6,2,5,4,8,3,7 };
	auto left = nums.begin(), right = nums.end() - 1;
	while (left != right)
	{
		auto temp = min(*left, *right) * (right - left);
		if (temp > water) water = temp;
		if (*left <= *right) left++;
		else right--;

	}
	cout << water << endl;
	return 0;
}