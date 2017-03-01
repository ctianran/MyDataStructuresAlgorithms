package com.sorting;

/**
 * Created by Tianran on 2/28/2017.
 */
public class FlipSort {
	public int[] flipSort(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return nums;
		}
		int index = nums.length - 1;
		while(index > 0) {
			int max = 0;
			for(int i = 0; i <= index; i++) {
				if(nums[i] > nums[max]) {
					max = i;
				}
			}
			flip(nums, max);
			flip(nums, index--);
		}
		return nums;
	}

	private void flip(int[] nums, int index) {
		int left = 0;
		while(left < index) {
			int temp = nums[left];
			nums[left] = nums[index];
			nums[index] = temp;
			left++;
			index--;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {3, 4, 0, 1, 2, 5, 7, 8, 6};
		FlipSort sol = new FlipSort();
		int[] res = sol.flipSort(nums);
		for(int num : res) {
			System.out.print(num + " ");
		}
	}
}
