package com.companies.ixl;

import java.util.*;
import java.util.List;
/**
 * Created by Tianran on 8/13/2017.
 */
public class SecondLargestNumber {
	//method1: sort the array
	//Time: O(nlogn)
	public int secondLarge(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return Integer.MAX_VALUE;
		}
		Arrays.sort(nums);
		return nums[nums.length - 2];
	}

	//method2:
	//O(2n) -> O(n)
	//Two pass
	public int secondLargeII(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return Integer.MAX_VALUE;
		}
		int max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == max) {
				continue;
			}
			res = Math.max(res, nums[i]);
		}
		return res == Integer.MIN_VALUE ? Integer.MAX_VALUE : res;
	}

	//Method3: MaxHeap
	//Time: O(nlogn) + O(logn)
	public int secondLargeIII(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int n : nums) {
			maxHeap.offer(n);
		}
		maxHeap.poll();
		return maxHeap.peek();
	}

	//Method4: one pass
	//Time: O(n)
	public int secondLargeIV(int[] nums) {
		int largest = Math.max(nums[0], nums[1]);
		int second = Math.min(nums[0], nums[1]);

		for(int i = 2; i < nums.length; i++) {
			if(nums[i] >= largest) {
				second = largest;
				largest = nums[i];
			} else if (nums[i] > second) {
				second = nums[i];
			}
		}
		return second;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {5, 5, 4};
		SecondLargestNumber sol = new SecondLargestNumber();
		int res = sol.secondLarge(nums);
		int res2 = sol.secondLargeII(nums);
		int res3 = sol.secondLargeIII(nums);
		int res4 = sol.secondLargeIV(nums);
		System.out.println(res);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
	}
}
