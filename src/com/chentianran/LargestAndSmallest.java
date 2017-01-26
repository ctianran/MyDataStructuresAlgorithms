package com.chentianran;

/**
 * Created by Tianran on 1/20/2017.
 */
public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array) {
		int[] result = new int[2];
		int n = array.length;
		for(int i = 0; i < n / 2; i++) {
			if(array[i] < array[n - 1 - i]) {
				swap(array, i, n - 1 - i);
			}
		}
		result[0] = findLargest(array, 0, (n - 1) / 2);
		result[1] = findSmallest(array, n / 2, n - 1);
		return result;
	}

	private int findLargest(int[] array, int left, int right) {
		int result = array[left];
		for(int i = left + 1; i <= right; i++) {
			result = Math.max(result, array[i]);
		}
		return result;
	}

	private int findSmallest(int[] array, int left, int right) {
		int result = array[left];
		for(int i = left + 1; i <= right; i++) {
			result = Math.min(result, array[i]);
		}
		return result;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
