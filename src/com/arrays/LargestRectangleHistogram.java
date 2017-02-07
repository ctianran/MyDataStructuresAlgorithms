package com.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 2/6/2017.
 */
public class LargestRectangleHistogram {
	public int largest(int[] array) {
		Deque<Integer> stack = new LinkedList<>();
		int result = 0;
		for(int i = 0; i <= array.length; i++) {
			int cur = i == array.length ? 0 : array[i];
			while(!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] {2, 1, 3, 4, 5, 2, 6};
		LargestRectangleHistogram sol = new LargestRectangleHistogram();
		int res = sol.largest(input);
		System.out.println(res);
	}
}
