package com.companies.ixl;

import java.util.*;

/**
 * Created by Tianran on 8/14/2017.
 */
public class RepeatElements {
	public List<Integer> getRepeat(int[] array) {
		List<Integer> res = new ArrayList<>();
		if(array == null || array.length == 0) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			Integer count = map.get(array[i]);
			if(count == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], count + 1);
			}
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				res.add(entry.getKey());
			}
		}
		return res;
	}

	public List<Integer> getRepeatII(int[] array) {
		List<Integer> res = new ArrayList<>();
		if(array == null || array.length == 0) {
			return res;
		}
		Arrays.sort(array);
		for(int i = 1; i < array.length; i++) {
			if(array[i] == array[i - 1]) {
				res.add(array[i]);
				while (i < array.length && array[i] == array[i - 1]) {
					i++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 1, 2, 3, 4, 3};
		RepeatElements sol = new RepeatElements();
		List<Integer> res = sol.getRepeat(array);
		System.out.println(res);
		List<Integer> res2 = sol.getRepeatII(array);
		System.out.println(res2);
	}
}
