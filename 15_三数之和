class Solution {
public:
	vector<vector<int>> threeSum(vector<int>& nums)
	{
		int sum,vec_size = nums.size();
		int i, j, k; // 指针初始化 
		vector<vector<int>> result = {};

		sort(nums.begin(), nums.end());

		if (vec_size <= 2) return result;
		if (nums[vec_size -1] + nums[vec_size - 2] + nums[vec_size - 3] < 0) return result;
		
		
		for (i = 0;i < vec_size - 1; i++)
		{
			// 对左点的循环
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i-1]) continue; 
			k = vec_size - 1;

			for (j = i + 1; j < k;)
			{
				// 两个动点的循环
				//if (k <= vec_size - 1 && nums[k] == nums[k - 1]) k--;//去重复
				sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
				{
					result.push_back({nums[i], nums[j], nums[k] });
					k--;
					j++;
				}
				else if (sum > 0)
					k--;
				else
					j++;
				while (j < vec_size - 1 && j > i + 1 && nums[j] == nums[j - 1]) j++;
                //去重复
				
					
			}
		}
		

		
		return result;
	}

};
