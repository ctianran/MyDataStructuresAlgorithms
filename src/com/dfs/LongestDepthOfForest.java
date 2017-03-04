package com.dfs;

/**
 * Created by Tianran on 3/4/2017.
 */
public class LongestDepthOfForest {
	public int getLongest(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] depths = new int[nums.length];
		int result = 0;
		for(int i = 0; i < nums.length; i++) {
			result = Math.max(result, helper(i, depths, nums));
		}
		return result;
	}

	private int helper(int root, int[] depths, int[] nums) {
		if(depths[root] > 0) {
			return depths[root];
		}
		if(depths[root] == -1) {
			throw new IllegalArgumentException("cycle detected");
		}
		depths[root] = -1;
		int parent = nums[root];
		depths[root] = 1 + helper(parent, depths, nums);
		return depths[root];
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-1, 2, 0, 2, 3, 6, -1};
		LongestDepthOfForest sol = new LongestDepthOfForest();
		int res = sol.getLongest(nums);
		System.out.println(res);
	}
}
