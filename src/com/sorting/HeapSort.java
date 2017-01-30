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
			percolateDown(input, 0, i);
		}
		return input;
	}

	private void heapify(int[] array) {
		for(int i = (array.length - 2) / 2; i >= 0; i--) {
			percolateDown(array, i, array.length);
		}
	}

	private void percolateDown(int[] array, int index, int size) {
		while(index <= (size - 2) / 2) {
			int leftChild = index * 2 + 1;
			int rightChild = index * 2 + 2;
			int swapCandidate = leftChild;
			if(rightChild <= size - 1 && array[rightChild] > array[leftChild]) {
				swapCandidate = rightChild;
			}
			if(array[index] < array[swapCandidate]) {
				swap(array, index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;
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
