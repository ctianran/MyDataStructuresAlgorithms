package com.chentianran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 1/25/2017.
 */
public class SpecialSortByFrequency {
	public int[] sort(int[] input) {
		if(input == null || input.length <= 1) {
			return input;
		}
		Integer[] intArray = new Integer[input.length];
		for(int i = 0; i < input.length; i++) {
			intArray[i] = input[i];
		}
		Arrays.sort(intArray, new MyComparatorI(input));

		for(int i = 0; i < input.length; i++) {
			input[i] = intArray[i];
		}
		return input;
	}

	static class MyComparatorI implements Comparator<Integer> {
		private Map<Integer, Integer> map;
		public MyComparatorI(int[] input) {
			map = new HashMap<Integer, Integer>();
			for(int num : input) {
				Integer count = map.get(num);
				if(count == null) {
					map.put(num, 1);
				} else {
					map.put(num, count + 1);
				}
			}
		}
		@Override
		public int compare(Integer o1, Integer o2) {
			Integer n1 = map.get(o1);
			Integer n2 = map.get(o2);
			if(n1.equals(n2)) {
				return n1.compareTo(n2);
			}
			return n1 < n2 ? 1 : -1;
		}
	}

}
