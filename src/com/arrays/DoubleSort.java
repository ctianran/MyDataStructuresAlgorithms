package com.arrays;

/**
 * Created by Tianran on 7/7/2017.
 */
public class DoubleSort {
	public int[] doubleSort(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return nums;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if(nums[left] < 0) {
				left++;
			} else {
				swap(nums, left, right--);
			}
		}
		return nums;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-1, 0, -1, -2, 1};
		DoubleSort sol = new DoubleSort();
		int[] res = sol.doubleSort(nums);

		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
