-- # 题目地址：
-- # https://leetcode-cn.com/problems/second-highest-salary/
-- # Write your MySQL query statement below

SELECT MAX(Salary) SecondHighestSalary
FROM Employee
WHERE Salary <> (
	SELECT MAX(Salary)
	FROM Employee
);
