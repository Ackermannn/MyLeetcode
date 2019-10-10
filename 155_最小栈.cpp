#include<iostream>
#include<vector>
using namespace std;

class MinStack {
public:
	
	vector<int> stack;
	vector<int> help_stack;
	MinStack() {}
	void push(int x) {
		if ( !stack.empty() && x > help_stack.back())
			help_stack.push_back(help_stack.back());
		else
			help_stack.push_back(x);
		stack.push_back(x);
	}

	void pop() {
		stack.pop_back();
		help_stack.pop_back();
	}

	int top() {
		return stack.back();
	}

	int getMin() {
		return help_stack.back();
	}
};

int main() {
	MinStack minStack;
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-1);
	cout << minStack.getMin() << endl;

	cout << minStack.top() << endl;
	minStack.pop();
	cout << minStack.getMin() << endl;

	return 0;
}
