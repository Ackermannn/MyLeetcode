
问题链接：

https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/

https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

```java
class Solution {
    public int findMin(int[] numbers) {
        return findMin(numbers, 0, numbers.length-1);
    }

    public int findMin(int[] numbers, int left, int right){
        
        if (right - left <= 1) return Math.min(numbers[left], numbers[right]);
        if (numbers[left] < numbers[right]) return numbers[left];
        
        int mid = (left + right) / 2; // 二分法取中间
        // 去重复
        if (numbers[mid] == numbers[left]) return findMin(numbers, left + 1, right);
        if (numbers[mid] == numbers[right]) return findMin(numbers, left, right-1);
        
        if (numbers[mid] > numbers[left]) return findMin(numbers, mid, right); // 左半段有序，最小值一定在右半段
        else return findMin(numbers, left, mid); // 右半段有序，最小值一定在左半段
   
    }


    
}
```
