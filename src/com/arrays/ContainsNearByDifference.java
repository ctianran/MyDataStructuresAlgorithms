package com.arrays;

import java.util.TreeSet;

/**
 * Created by Tianran on 2/21/2017.
 */
public class ContainsNearByDifference {
	public boolean containsNearbyDiff(int[] array, int k, int d) {
		if(array == null || array.length <= 1 || k <= 0 || d < 0) {
			return false;
		}
		TreeSet<Integer> treeset = new TreeSet<>();
		for(int i = 0; i < array.length; i++) {
			if(i >= k) {
				if(i > k) {
					treeset.remove(array[i - k - 1]);
				}
				if(treeset.ceiling(array[i]) != null) {
					if(treeset.ceiling(array[i]) - array[i] <= d) {
						return true;
					}
				}
				if(treeset.floor(array[i]) != null) {
					if (array[i] - treeset.floor(array[i]) <= d) {
						return true;
					}
				}
			}
			treeset.add(array[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 3, 4, 1};
		ContainsNearByDifference sol = new ContainsNearByDifference();
		System.out.println(sol.containsNearbyDiff(input, 2, 2));
	}
}
