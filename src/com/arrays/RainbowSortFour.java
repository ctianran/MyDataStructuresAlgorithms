package com.arrays;

/**
 * Created by Tianran on 7/7/2017.
 */
public class RainbowSortFour {
	public int[] rainboewSortFour(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return nums;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		int l = nums.length - 1;
		while(k <= l) {
			if(nums[k] == 1) {
				swap(nums, i++, k);
			} else if(nums[k] == 2) {
				swap(nums, j++, k);
			} else if(nums[k] == 3) {
				k++;
			} else {
				swap(nums, k, l--);
			}
			if(i > j) {
				j++;
			}
			if(j > k) {
				k++;
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
		int[] nums = new int[]{2, 3, 1, 2, 3, 4, 4, 3, 2, 1, 1, 2, 3, 4};
		RainbowSortFour sol = new RainbowSortFour();
		int[] res = sol.rainboewSortFour(nums);

		for(int i : res) {
			System.out.print(i + " ");
		}
	}
}
