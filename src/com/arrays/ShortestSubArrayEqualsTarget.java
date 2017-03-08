package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/4/2017.
 */
public class ShortestSubArrayEqualsTarget {
	public int shortest(int[] array, int target) {
		if(array == null || array.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			int temp = sum - target;
			if(map.containsKey(temp)) {
					result = Math.min(result, i - map.get(sum));
			}
			map.put(sum, i);
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

}
