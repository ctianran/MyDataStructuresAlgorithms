package com.sorting;

/**
 * Created by Tianran on 2/14/2017.
 */
public class SortArrayOneToN {
	public int[] sort(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		for(int i = 0; i < array.length; i++) {
			while (array[i] != i + 1) {
				swap(array, i, array[i] - 1);
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
		int[] input = new int[] {4, 3, 2, 1, 5};
		SortArrayOneToN sol = new SortArrayOneToN();
		int[] res = sol.sort(input);

		for(int n : res) {
			System.out.print(n + " ");
		}
	}
}
