# -*- coding: utf-8 -*-
"""
方法二：双指针法
算法

这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，
两线段距离越远，得到的面积就越大。

我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会
使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 在每一步中，我们会
找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向
较长线段那端移动一步。

作者：LeetCode
链接：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/

"""
water = 0

with open('data.txt') as f:
    fr = f.read()
fr = [int(x) for x in fr[1:-2].split(',')]
nums = fr
left = 0
right = len(nums)-1
while (left != right):
    temp = min(nums[left], nums[right]) * (right - left)
    water = temp if temp > water else water
    
    if nums[left] <= nums[right]:
        left += 1
    else:
        right -= 1
print(water)