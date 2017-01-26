package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 1/19/2017.
 */
public class TopKFrequentElements {
	public List<Integer> topKFrequentI(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if(nums == null || k == 0) {
			return result;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			Integer count = map.get(num);
			if(count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k,
						new Comparator<Map.Entry<Integer, Integer>>(){
							@Override
							public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
								if(entry1.getValue() == entry2.getValue()) {
									return 0;
								}
								return entry1.getValue() < entry2.getValue() ? -1 : 1;
							}
						});

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer(entry);
			} else if(minHeap.peek().getValue() < entry.getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}

		for(int i = 0; i < k; i++) {
			Map.Entry<Integer, Integer> temp = minHeap.poll();
			System.out.println(temp.getKey());
			result.add(temp.getKey());
		}
		return result;

	}

	public List<Integer> topKFrequentII(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		if(nums == null || k == 0) {
			return result;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			Integer count = map.get(num);
			if(count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}

		int max = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}

		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max + 1];
		for(int i = 1; i <= max; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			int number = entry.getKey();
			arr[count].add(number);
		}

		for(int j = max; j >= 1; j--) {
			if(arr[j].size() > 0) {
				for(int a : arr[j]) {
					result.add(a);
				}
			}
			if(result.size() == k) {
				break;
			}
		}
		return result;
	}

}
