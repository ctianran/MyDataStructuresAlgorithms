package com.arrays;

/**
 * Created by Tianran on 2/28/2017.
 */
public class CountTriangles {
	public int count(int[] nums) {
		if(nums == null || nums.length <= 2) {
			return 0;
		}
		int result = 0;
		for(int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = j + 1;
			for(; j < k && j < nums.length - 1; j++) {
				while(k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				result += k - j - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {5, 6, 10, 12, 13};
		CountTriangles sol = new CountTriangles();
		int res = sol.count(nums);
		System.out.println(res);
	}
}
