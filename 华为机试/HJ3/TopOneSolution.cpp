/*
由大牛写的题解
https://www.nowcoder.com/profile/825762
*/
#include <iostream>
using namespace std;
int main() {
	int N, n;
	while (cin >> N) {
        int a[1001] = { 0 };
		while (N--) {
			cin >> n;
			a[n] = 1;
		}
		for (int i = 0; i < 1001; i++)
			if (a[i])
				cout << i << endl;
	}
	return 0;
}
