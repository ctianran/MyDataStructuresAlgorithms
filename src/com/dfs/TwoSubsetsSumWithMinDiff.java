package com.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 6/26/2017.
 */
public class TwoSubsetsSumWithMinDiff {
	public List<List<Integer>> minDiff(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
			if(nums == null || nums.length == 0) {
				return res;
			}
			int sum = 0;
			for(int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			List<Integer> cur = new ArrayList<>();
			List<List<Integer>> temp = new ArrayList<>();
			int[] min = new int[] {Integer.MAX_VALUE};
			helper(nums, 0, cur, 0, sum, min, temp);
			return res;
	}

	private void helper(int[] nums, int index, List<Integer> cur, int curSum, int sum, int[] min, List<List<Integer>> temp) {
		if(index == nums.length) {
			if(sum - curSum <= min[0]) {
				min[0] = sum - curSum;
				temp.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		cur.add(nums[index]);
		helper(nums, index + 1, cur, curSum + nums[index], sum, min, temp);
		cur.remove(cur.size() - 1);

		helper(nums, index + 1, cur, curSum, sum, min, temp);
	}


}
