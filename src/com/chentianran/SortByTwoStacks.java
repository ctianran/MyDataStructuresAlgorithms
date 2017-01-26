package com.chentianran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 1/26/2017.
 */
public class SortByTwoStacks {
	public static Deque<Integer> sort(Deque<Integer> inStack) {
		Deque<Integer> outStack = new LinkedList<Integer>();
		if(inStack.isEmpty()) {
			return outStack;
		}
		int countSorted = 0;
		int size = inStack.size();
		while(countSorted < size) {
			int curMin = inStack.peekFirst();
			while(!inStack.isEmpty()) {
				int temp = inStack.pollFirst();
				if(temp < curMin) {
					curMin = temp;
				}
				outStack.offerFirst(temp);
			}
			//count duplicate
			int count = 0;
			while(outStack.size() > countSorted) {
				if(outStack.peekFirst() == curMin) {
					count++;
					outStack.pollFirst();
				} else {
					inStack.offerFirst(outStack.pollFirst());
				}
			}
			for(int i = 0; i < count; i++) {
				outStack.offerFirst(curMin);
				countSorted++;
			}
		}
		return outStack;
	}

	public static void main(String[] args) {
		Deque<Integer> inStack = new LinkedList<>();
		inStack.offerFirst(2);
		inStack.offerFirst(5);
		inStack.offerFirst(6);
		inStack.offerFirst(4);

		Deque<Integer> outStack = sort(inStack);

		while(!outStack.isEmpty()) {
			System.out.println(outStack.pollFirst());
		}

	}
}
