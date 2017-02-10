package com.arrays;

/**
 * Created by Tianran on 2/9/2017.
 */
public class QuickSelect {
	public int quickSelect(int[] array, int k) {
		if(array == null || array.length == 0 || k == 0) {
			return -1;
		}
		return helper(array, 0, array.length - 1, k);
	}

	private int helper(int[] array, int left, int right, int k) {
		if(left >= right) {
			return array[left];
		}
		int pivot = partition(array, left, right);
		if(pivot == k - 1){
			return array[pivot];
		} else if (pivot > k - 1) {
			return helper(array, left, pivot - 1, k);
		} else {
			return helper(array, pivot + 1, right, k - (pivot - left + 1));
		}
	}

	private int partition(int[] array, int left, int right) {
		int pivot = left + (int)(Math.random() * (right - left + 1));
		int pVal = array[pivot];
		swap(array, pivot, right);
		int lIdx = left;
		int rIdx = right - 1;
		while(lIdx <= rIdx) {
			if(array[lIdx] < pVal) {
				lIdx++;
			} else {
				swap(array, lIdx, rIdx--);
			}
		}
		swap(array, lIdx, right);
		return lIdx;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {3, 1, 2, 5, 4};
		QuickSelect sol = new QuickSelect();
		int res = sol.quickSelect(input, 3);
		System.out.println(res);
	}
}
