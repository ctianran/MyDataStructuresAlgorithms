package com.sorting;

/**
 * Created by Tianran on 2/23/2017.
 */
public class DoubleSort {
	public int[] doubleSort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			if(array[left] < 0) {
				left++;
			} else {
				swap(array, left, right--);
			}
		}
		return array;
	}

	public int[] doubleSortII(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		int i = 0;
		int right = array.length - 1;
		while(i <= right) {
			if(array[i] < 0) {
				swap(array, left++, i++);
			} else if(array[i] == 0) {
				i++;
			} else {
				swap(array, i, right--);
			}
		}
		return array;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) {
		int[] input = new int[] {5, 7,0, -1, -2, 0, 1, -3};
		DoubleSort sol = new DoubleSort();
		int[] res = sol.doubleSortII(input);
		for(int num : res) {
			System.out.print(num + " ");
		}
	}
}
