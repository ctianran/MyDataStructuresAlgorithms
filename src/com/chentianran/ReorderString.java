package com.chentianran;

import java.util.*;

/**
 * Created by Tianran on 1/17/2017.
 */
public class ReorderString {
	public String reorder(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : input.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, count + 1);
			}
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
				if (entry1.getValue() == entry2.getValue()) {
					return entry1.getKey().compareTo(entry2.getKey());
				}
				return entry1.getValue() < entry2.getValue() ? 1 : -1;
			}
		});

		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}
		StringBuilder sb = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> temp = maxHeap.poll();
			char ch = temp.getKey();
			int num = temp.getValue();
			for(int j = 0; j < num; j++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
