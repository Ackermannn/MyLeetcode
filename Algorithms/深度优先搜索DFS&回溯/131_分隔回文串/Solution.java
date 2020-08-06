class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<String>());
        return ans;
    }

    // 判断是否是回文
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }

    void dfs(String s, List<String> temp) {
        String subS;
        String item;
        if (s.length() == 0) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 1; i <= s.length(); i++) {
                item = s.substring(0, i);
                subS = s.substring(i);
                if (isPalindrome(item)) {
                    temp.add(item);
                    dfs(subS, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }



}