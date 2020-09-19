# Question

题目描述

    写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

输入描述:

    输入一个十六进制的数值字符串。

输出描述:

    输出该数值的十进制字符串。

示例1

    输入
        0xA
    输出
        10
        
# Solution

## C++

### 1

读入字符串后自己解析

```c++
#include<iostream>
using namespace std;

int main() {
	string str;
	
	while (cin >> str) {
		int ans = 0;
		int bit = 0;
		for (int i = str.size() - 1; i >= 2; --i) {
			char single = str[i];
			if ('0' <= single and single <= '9')
				ans += int(single - '0') * pow(16, bit++);
			else if ('A' <= single and single <= 'F')
				ans += int(single - 'A' + 10) * pow(16, bit++);
		}
		cout << ans << endl;
	}
	
	return 0;
}



```

### 2

使用std 中 的 hex
```c++
#include <iostream>
using namespace std;
int main(){
    int a;
    while(cin >> hex >> a){
        cout << a << endl;
    }
}
```

## python

人生苦短，我用Python

```python
while True:
    try:
        a = int(input(), 16)
        print(a)
    except:
        break

```

## Java
牛客网 @李韬 直接调用Java的decode方法.该方法的作用是将 String 解码为 Integer。接受十进制、十六进制和八进制数字。根据要解码的 String（mn)的形式转成不同进制的数字。 mn由三部分组成：符号、基数说明符和字符序列。 -0X123中-是符号位，0X是基数说明符（0表示八进制，0x,0X，#表示十六进制，什么都不写则表示十进制），123是数字字符序列。
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){

            String a = scan.next();
            System.out.println(Integer.decode(a));
        }
    }
}
```