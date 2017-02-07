package com.bfs;

import java.util.*;

/**
 * Created by Tianran on 2/5/2017.
 */
public class KthClosestPoint {
	public List<Integer> closest(int[] arr1, int[] arr2, int[] arr3, int k) {
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				long dist1 = getDistance(o1, arr1, arr2, arr3);
				long dist2 = getDistance(o2, arr1, arr2, arr3);
				if(dist1 == dist2) {
					return 0;
				}
				return dist1 < dist2 ? -1 : 1;
			}
		});
		Set<List<Integer>> visited = new HashSet<>();
		List<Integer> cur = Arrays.asList(0, 0, 0);
		visited.add(cur);
		minHeap.offer(cur);
		while(k > 0) {
			cur = minHeap.poll();
			List<Integer> temp = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if(temp.get(0) < arr1.length && visited.add(temp)) {
				minHeap.offer(temp);
			}
			temp = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if(temp.get(1) < arr2.length && visited.add(temp)) {
				minHeap.offer(temp);
			}
			temp = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if(temp.get(2) < arr3.length && visited.add(temp)) {
				minHeap.offer(temp);
			}
			k--;
		}
		cur.set(0, arr1[cur.get(0)]);
		cur.set(1, arr2[cur.get(1)]);
		cur.set(2, arr3[cur.get(2)]);
		return cur;
	}

	private long getDistance(List<Integer> point, int[] arr1, int[] arr2, int[] arr3) {
		long distance = 0;
		distance += arr1[point.get(0)] * arr1[point.get(0)];
		distance += arr2[point.get(1)] * arr2[point.get(1)];
		distance += arr3[point.get(2)] * arr2[point.get(2)];
		return distance;
	}
}
