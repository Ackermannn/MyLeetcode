class Solution {
public:
    int minDistance(string word1, string word2) {
        int n = word1.size() + 1, m = word2.size() + 1;
		vector<int> line(m, 0);
		vector<vector<int>> dp(n, line);
		int a, b, c;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 and j == 0) dp[i][j] = 0;
				else if (i == 0 or j == 0) dp[i][j] = max(i, j);
				else {
					a = dp[i - 1][j] + 1;
					b = dp[i][j - 1] + 1;
					if (word1[i - 1] == word2[j - 1])
						c = dp[i - 1][j - 1];
					else
						c = dp[i - 1][j - 1] + 1;
					dp[i][j] = min(min(a, b), c);
				}   
			}
		}
		return dp[n - 1][m - 1];
    }
};
