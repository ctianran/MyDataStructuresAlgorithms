package com.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by Tianran on 2/21/2017.
 */
public class ContainsNearByDifference {
	//Time: O(nlogk)
	//Space:O(k)
	public boolean containsNearbyDiff(int[] array, int k, int d) {
		if(array == null || array.length <= 1 || k <= 0 || d < 0) {
			return false;
		}
		TreeSet<Integer> treeset = new TreeSet<>();
		for(int i = 0; i < array.length; i++) {
			if(i < k) {
				treeset.add(array[i]);
			} else {
				if(i > k) {
					treeset.remove(array[i - k - 1]);
				}
				if(treeset.ceiling(array[i]) != null && (treeset.ceiling(array[i]) - array[i] <= d)) {
						return true;
				} else if(treeset.floor(array[i]) != null && (array[i] - treeset.floor(array[i]) <= d)) {
						return true;
					}
				}
				treeset.add(array[i]);
		}
		return false;
	}

	//Time: O(n)
	//Space:O(k)
	public boolean containsNearbyDiffII(int[] array, int k, int d) {
		if (array == null || array.length <= 1 || k <= 0 || d < 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			int bucketNum = array[i]/(d + 1);
			if(i < k) {
				map.put(bucketNum, array[i]);
			} else {
				if(i > k) {
					map.remove(array[i - k - 1]/(d + 1));
				}
				if(map.containsKey(bucketNum)) {
					return true;
				}
				if(map.containsKey(bucketNum - 1) && (array[i] - map.get(bucketNum - 1)) <= d) {
					return true;
				}
				if(map.containsKey(bucketNum + 1) && (map.get(bucketNum + 1) - array[i] <= d)) {
					return true;
				}
				map.put(bucketNum, array[i]);
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int[] input = new int[] {1, 3, 5, 1};
		ContainsNearByDifference sol = new ContainsNearByDifference();
		System.out.println(sol.containsNearbyDiff(input, 2, 1));
	}
}
