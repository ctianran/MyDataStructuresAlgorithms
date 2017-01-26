package com.chentianran;

/**
 * Created by Tianran on 1/16/2017.
 */
public class MergeSort {
	public int[] mergeSort(int[] input) {
		if(input == null || input.length <= 1) {
			return input;
		}
		int[] helper = new int[input.length];
		merge(input, helper, 0, input.length - 1);
		return input;
	}

	private void merge(int[] input, int[] helper, int left, int right) {
		if(left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		merge(input, helper, left, mid);
		merge(input, helper, mid + 1, right);
		for(int i = left; i <= right; i++) {
			helper[i] = input[i];
		}
		int leftIdx = left;
		int rightIdx = mid + 1;
		while(leftIdx <= mid && rightIdx <= right) {
			if(helper[leftIdx] <= helper[rightIdx]) {
				input[left++] = helper[leftIdx++];
			} else {
				input[left++] = helper[rightIdx++];
			}
		}
		while(leftIdx <= mid) {
			input[left++] = helper[leftIdx++];
		}
	}
}
