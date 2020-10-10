#include <iostream>
#include<string>

using namespace std;
class Solution {
public:
	bool isPalindrome(int x) 
	{
		int front, back;
		string str= {};
		if (x < 0) return false;
		else if (x <= 9) return true;
		else 
		{
			str = to_string(x);	
			for (front = 0, back = str.size() - 1; front < back; front++, back--)
			{
				if (str[front] != str[back]) return false;
				
			}
            return true;
		}
        
	}
};
