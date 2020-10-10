# Question

https://leetcode-cn.com/problems/group-anagrams/

# Code
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (var str:strs){
            
            // 把顺序排好的字符串当key
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String str_sort = new String(charArr);
            
            if (!map.containsKey(str_sort)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(str_sort, temp);
            }else 
                map.get(str_sort).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
```
