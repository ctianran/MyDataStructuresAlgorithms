package com.sorting;

/**
 * Created by Tianran on 1/30/2017.
 */
public class HeapSort {
	public int[] heapSort(int[] input) {
		if(input == null || input.length <= 1) {
			return input;
		}
		heapify(input);

		for(int i = input.length - 1; i > 0; i--) {
			swap(input, 0, i);
			percolateDown(input, 0, i - 1);
		}
		return input;
	}

	private void heapify(int[] array) {
		for(int i = array.length/2 - 1; i >= 0; i--) {
			percolateDown(array, i, array.length - 1);
		}
	}

	private void percolateDown(int[] array, int index, int size) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int max = index;
		if(left <= size && array[left] > array[max]) {
			max = left;
		}
		if(right <= size && array[right] > array[max]) {
			max = right;
		}
		if(max != index) {
			swap(array, index, max);
			percolateDown(array, max, size);
		}
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


	public static void main(String[] args) {
		int[] input = new int[] {9, 3, 5, 1, 2, 7, 4, 6, 8};

		HeapSort sol = new HeapSort();
		int[] res = sol.heapSort(input);

		for(int i : res) {
			System.out.print(i + " ");
		}
	}
}
