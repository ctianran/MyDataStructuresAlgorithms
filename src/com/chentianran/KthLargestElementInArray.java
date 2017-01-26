package com.chentianran;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 1/17/2017.
 */
public class KthLargestElementInArray {
	public int kthMaxHeap(int[] input, int k) {
		if(input == null || k == 0) {
			return -1;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1 < o2 ? 1 : -1;
			}
		});
		for(int i = 0; i < input.length; i++) {
			maxHeap.offer(input[i]);
		}
		for(int i = 0; i < k-1; i++) {
			maxHeap.poll();
		}
		return maxHeap.peek();
	}

	public int kthMinHeap(int[] input, int k) {
		if(input == null || k == 0) {
			return -1;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
		for(int i = 0; i < input.length; i++) {
			if(i < k) {
				minHeap.offer(input[i]);
			} else if(minHeap.peek() < input[i]) {
				minHeap.poll();
				minHeap.offer(input[i]);
			}
		}
		return minHeap.peek();
	}
}
