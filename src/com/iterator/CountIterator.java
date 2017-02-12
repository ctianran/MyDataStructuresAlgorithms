package com.iterator;

/**
 * Created by Tianran on 2/11/2017.
 */
public class CountIterator {
	private int[] array;
	private int countIndex;
	private int count;
	public CountIterator(int[] array) {
		if(array == null || array.length % 2 != 0)  {
			return;
		}
		this.array = array;
		countIndex = 0;
		count = array[countIndex];
		while(countIndex < array.length - 1 && count <= 0) {
			countIndex += 2;
			if(countIndex < array.length - 1) {
				count = array[countIndex];
			}
		}
		if(countIndex >= array.length) {
			return;
		}
	}

	public Integer next() {
		if(!hasNext()) {
			return null;
		}
		int num = array[countIndex + 1];
		count--;
		while(countIndex < array.length - 1 && count <= 0) {
			countIndex += 2;
			if(countIndex < array.length - 1) {
				count = array[countIndex];
			}
		}
		return num;
	}

	public boolean hasNext() {
		return countIndex < array.length - 1;
	}


	public static void main(String[] args) {
		int[] input = new int[] {5,0,-3,4,5,5};
		CountIterator sol = new CountIterator(input);
		System.out.println(sol.hasNext());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());
		System.out.println(sol.next());

	}
}


