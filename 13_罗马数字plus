#include<iostream>
#include<string>
#include<map>
#include<vector>
using namespace std;
class Solution{
public:
	int romanToInt(string s){
		int sum = 0, lens = s.size();
		string key2 = "",key1;
		map<string, int> Roman = { 
			                     {"I",1},{"V",5},{"X",10},{"L",50},{"C",100},{"D",500},{"M",1000},
								 {"IV",4},{"IX",9},{"XL",40},{"XC",90},{"CD",400},{"CM",900}
								 };
		for (int i = 0; i < lens; i++){
			key1 = s[i];
			if (i == lens - 1){
				sum += Roman[key1];
				return sum;}
			key2 = s.substr(i, 2);
			if (Roman[key2] != NULL){
				sum += Roman[key2]; 
				i++;}
			else
				sum += Roman[key1];}
		return sum;
	}
	string intToRoman(int num) 
	{
		map<int, string> Roman2 = {
				                  {1,"I"},{5,"V"},{10,"X"},{50,"L"},{100,"C"},{500,"D"},{1000,"M"},
					              {4,"IV"},{9,"IX"},{40,"XL"},{90,"XC"},{400,"CD"},{900,"CM"}
		                          };
		//int Roman_size = Roman2.size();
		string res="";
		vector<int> vec = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		int x = 0;
		while (num > 0)
		{
			for (int i = x;i <= 12; i++)
			{
				if (num >= vec[i])
				{
					num -= vec[i];
					x = i;
					res += Roman2[vec[i]];
					break;
				}
			}
			/*
			for (auto x : vec)
			{
				if (num >= x)
				{
					num -= x;
					res += Roman2[x];
					break;
				}
			}
			*/
		}
		return res;
	}
};


int main()
{
	// 输入在 1~3999
	Solution s;
	cout << s.intToRoman(2645) << endl;
	cout << s.romanToInt("MMDCXLV") << endl;
	return 0;
}
