package com.chentianran;

/**
 * Created by Tianran on 1/16/2017.
 *
 * "A1B2C3D4" -> "ABCD1234"
 */
public class MergeSortString {
	public String mergeSort(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		char[] helper = new char[array.length];
		mergeHelper(array, helper, 0, array.length -1);
		return new String(array);
	}

	private void mergeHelper(char[] array, char[] helper, int left, int right) {
		if(left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeHelper(array, helper, left, mid);
		mergeHelper(array, helper, mid + 1, right);
		for(int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int leftIdx = left;
		int rightIdx = mid + 1;
		while(leftIdx <= mid && rightIdx <= right) {
			if(helper[leftIdx] >= 'A' && helper[rightIdx] >= 'A' ||
							helper[leftIdx] < 'A' && helper[rightIdx] < 'A') {
				if(helper[leftIdx] <= helper[rightIdx]) {
					array[left++] = helper[leftIdx++];
				} else {
					array[left++] = helper[rightIdx++];
				}
			} else if (helper[leftIdx] >= 'A' && helper[rightIdx] < 'A') {
				array[left++] = helper[leftIdx++];
			} else {
				array[left++] = helper[rightIdx++];
			}
		}
		while(leftIdx <= mid) {
			helper[left++] = helper[leftIdx++];
		}
	}
}
