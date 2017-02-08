package com.arrays;

/**
 * Created by Tianran on 2/7/2017.
 */
public class MaxWaterTrapped {
	public int maxWater(int[] array) {
		if(array == null || array.length <= 2) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int lmax = array[left];
		int rmax = array[right];
		int result = 0;
		while(left < right) {
			if(array[left] <= array[right]) {
				result += Math.max(0, lmax - array[left]);
				lmax = Math.max(lmax, array[left]);
				left++;
			} else {
				result += Math.max(0, rmax - array[right]);
				rmax = Math.max(rmax, array[right]);
				right--;
			}
		}
		return result;
	}
}
