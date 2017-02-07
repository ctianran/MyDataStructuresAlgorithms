package com.bfs;

import java.util.*;

/**
 * Created by Tianran on 2/5/2017.
 */
public class KthSmallestThreeFiveSeven {
	public long kthSmallestI(int k) {
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		Set<Long> set = new HashSet<>();
		minHeap.offer(3 * 5 * 7L);
		set.add(3 * 5 * 7L);
		while(k > 1) {
			long cur = minHeap.poll();
			if(set.add(3 * cur)) {
				minHeap.offer(3 * cur);
			}
			if(set.add(5 * cur)) {
				minHeap.offer(5 * cur);
			}
			if(set.add(7 * cur)) {
				minHeap.offer(7 * cur);
			}
			k--;
		}
		return minHeap.peek();
	}

	public long kthSmallestII(int k) {
		long seed = 3 * 5 * 7L;
		Deque<Long> three = new LinkedList<>();
		Deque<Long> five = new LinkedList<>();
		Deque<Long> seven = new LinkedList<>();

		three.add(3 * seed);
		five.add(5 * seed);
		seven.add(7 * seed);

		long result = seed;

		while(k > 1) {
			if(three.peekFirst() < five.peekFirst() && three.peekFirst() < seven.peekFirst()) {
				result = three.pollFirst();
				three.offerLast(result * 3);
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else if (five.peekFirst() < three.peekFirst() && five.peekFirst() < seven.peekFirst()) {
				result = five.pollFirst();
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else {
				result = seven.pollFirst();
				seven.offerLast(result * 7);
			}
			k--;
		}
		return result;
	}

	public static void main(String[] args) {
		KthSmallestThreeFiveSeven sol = new KthSmallestThreeFiveSeven();
		long res = sol.kthSmallestII(10);
		System.out.println(res);
	}
}
