package com.arrays;

import java.util.TreeSet;

/**
 * Created by Tianran on 7/21/2017.
 */
public class NearByDifferenceWithinKSlidingWindow {
	//Method1: Use TreeSet
	//Time: O(nlogk)
	//Space: O(k)
	public boolean existNearByDiffI(int[] nums, int k, int d) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		TreeSet<Integer> treeset = new TreeSet<>();
		for(int i = 0; i < nums.length - 1; i++) {
			if(i < k - 1) {
				treeset.add(nums[i]);
			} else {
				if(treeset.ceiling(nums[i]) != null && treeset.ceiling(nums[i]) - nums[i] <= d ||
								treeset.floor(nums[i]) != null && nums[i] - treeset.floor(nums[i]) <= d) {
					return true;
				}
				treeset.add(nums[i]);
				treeset.remove(nums[i - k + 1]);
			}
		}
		return false;
	}

	//Method2:
	//Time: O(n)
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 1};
		int[] nums2 = {1, 2, 3, 4, 1};

		NearByDifferenceWithinKSlidingWindow sol = new NearByDifferenceWithinKSlidingWindow();
		System.out.println(sol.existNearByDiffI(nums, 2, 1));
		System.out.println(sol.existNearByDiffI(nums2, 2, 2));

	}
}
