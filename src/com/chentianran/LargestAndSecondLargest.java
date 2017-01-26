package com.chentianran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 1/21/2017.
 */
public class LargestAndSecondLargest {

	public int[] largestAndSecondLargest(int[] input) {
		int[] result = new int[2];
		Cell[] array = new Cell[input.length];
		for(int i = 0; i < array.length; i++) {
			array[i] = new Cell(input[i]);
		}

		int length = array.length;
		while(length > 1) {
			helper(array, length);
			length = (length + 1) / 2;
		}

		result[0] = array[0].num;
		List<Integer> temp = array[0].list;
		result[1] = temp.get(0);
		for(int num : temp) {
			result[1] = Math.max(result[1], num);
		}
		return result;
	}

	private void helper(Cell[] array, int length) {
			for(int i = 0; i < length / 2; i++) {
				if(array[i].num < array[length - 1 - i].num) {
						swap(array, i, length - 1 - i);
				}
				array[i].list.add(array[length - 1 - i].num);
			}
	}



	private void swap(Cell[] array, int a, int b) {
		Cell temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	static class Cell {
		private int num;
		private List<Integer> list;

		public Cell(int num) {
			this.num = num;
			list = new ArrayList<Integer>();
		}
	}
}
