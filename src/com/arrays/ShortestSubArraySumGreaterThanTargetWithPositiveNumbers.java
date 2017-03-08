package com.arrays;

/**
 * Created by Tianran on 3/5/2017.
 */
public class ShortestSubArraySumGreaterThanTargetWithPositiveNumbers {
	//Time O(n)
	//space O(n)
	public int shortestI(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] prefixSum = new int[nums.length + 1];
		for(int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i-1] + nums[i-1];
		}
		int slow = 0;
		int fast = 1;
		int result = Integer.MAX_VALUE;
		while(fast < prefixSum.length) {
			if(prefixSum[fast] - prefixSum[slow] > target) {
				result = Math.min(result, fast - slow);
				slow++;
			} else {
				fast++;
			}
		}
		return result;
	}
	//Time: O(n);
	//Space: O(1); calculate the prefix sum on the fly
	public int shorteestII(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int slow = -1;
		int sumSlow = 0;
		int fast = 0;
		int sumFast = nums[0];
		int result = Integer.MAX_VALUE;
		while(fast < nums.length) {
			if(sumFast - sumSlow > target) {
					result = Math.min(result, fast - slow);
					sumSlow += nums[++slow];
			} else {
				fast++;
				if(fast < nums.length) {
					sumFast += nums[fast];
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 2, 2, 4, 1};
		ShortestSubArraySumGreaterThanTargetWithPositiveNumbers sol = new ShortestSubArraySumGreaterThanTargetWithPositiveNumbers();
		int res = sol.shortestI(nums, 5);
		int res2 = sol.shorteestII(nums, 5);
		System.out.println(res);
		System.out.println(res2);
	}

}
