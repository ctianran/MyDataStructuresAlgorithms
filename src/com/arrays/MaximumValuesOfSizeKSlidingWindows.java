package com.arrays;

import java.util.*;

/**
 * Created by Tianran on 2/9/2017.
 */
public class MaximumValuesOfSizeKSlidingWindows {
	public List<Integer> maxWindowsI(int[] array, int k) {
		List<Integer> result = new ArrayList<>();
		if(array == null || k == 0) {
			return result;
		}
		PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2) {
				if(c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? 1 : -1;
			}
		});

		for(int i = 0; i < array.length; i++) {
			maxHeap.offer(new Cell(array[i], i));
			if(i == k - 1) {
				result.add(maxHeap.peek().val);
			} else if (i >= k) {
				while(!maxHeap.isEmpty() && maxHeap.peek().index <= i - k) {
					maxHeap.poll();
				}
				result.add(maxHeap.peek().val);
			}
		}
		return result;
	}

	static class Cell {
		int val;
		int index;
		public Cell(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public List<Integer> maxWindowsII(int[] array, int k) {
		List<Integer> result = new ArrayList<>();
		if (array == null || k == 0) {
			return result;
		}
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < array.length; i++) {
			while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if(!deque.isEmpty() && deque.peekFirst() < i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if(i >= k - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 3, 2, 4, 2, 1};
		MaximumValuesOfSizeKSlidingWindows sol = new MaximumValuesOfSizeKSlidingWindows();
		List<Integer> res1 = sol.maxWindowsI(input, 3);
		List<Integer> res2 = sol.maxWindowsII(input, 3);
		System.out.println(res1);
		System.out.println(res2);
	}
}
