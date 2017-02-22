package com.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Tianran on 2/21/2017.
 */
public class ContainsNearbyDuplicate {
	public boolean checkDupI(int[] array, int k) {
		if(array == null || array.length <=1 || k <= 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				if(i - map.get(array[i]) <= k) {
					return true;
				}
			}
			map.put(array[i], i);
		}
		return false;
	}

	public boolean checkDupII(int[] array, int k) {
		if(array == null || array.length <= 1 || k <= 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < array.length; i++) {
				if(!set.add(array[i])) {
					return true;
				}
				if(i >= k) {
					set.remove(array[i - k]);
				}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 1, 3, 4};
		ContainsNearbyDuplicate sol = new ContainsNearbyDuplicate();
		System.out.println(sol.checkDupII(input, 3));
	}
}
