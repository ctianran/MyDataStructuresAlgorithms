package com.chentianran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 1/8/2017.
 */
public class SpecialSort {

	public int[] sortSpecialI(int[] array) {
		Integer[] A1 = new Integer[array.length];
		for(int i = 0; i < array.length; i++) {
			A1[i] = array[i];
		}
		Arrays.sort(A1, new MyComparator(array));
		for(int i = 0; i < array.length; i++) {
			array[i] = A1[i];
		}
		return array;
	}

	static class MyComparator implements Comparator<Integer> {
		private Map<Integer, Integer> map;
		public MyComparator(int[] array) {
			map = new HashMap<Integer, Integer>();
			for(int i = 0; i < array.length; i++) {
				if(!map.containsKey(array[i])) {
					map.put(array[i], i);
				}
			}
		}

		@Override
		public int compare(Integer c1, Integer c2) {
			Integer num1 = map.get(c1);
			Integer num2 = map.get(c2);
			return num1.compareTo(num2);
		}
	}

	public int[] sortSpecialII(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		while(left < array.length) {
			int num = array[left];
			while(left + 1 < array.length && array[left + 1] == num) {
				left++;
			}
			int slow = array.length - 1;
			int fast = array.length - 1;
			int count = 0;
			while(fast > left) {
				if(array[fast] != array[left]) {
					array[slow--] = array[fast--];
				} else {
					count++;
					fast--;
				}
			}
			for(int i = 0; i < count; i++) {
				array[++left] = num;
			}
			left++;
		}
		return array;
	}

}
