package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 6/17/2017.
 */
public class ValidTriangles {
	public List<List<Integer>> validTriangles(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			int j = i + 1;
			int k = j + 1;
			for(; j < nums.length - 1; j++) {
				while(k < nums.length && nums[i] + nums[j] > nums[k]) {
					List<Integer> cur = Arrays.asList(nums[i], nums[j], nums[k]);
					res.add(new ArrayList<Integer>(cur));
					k++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2, 2, 3, 4};
		ValidTriangles sol = new ValidTriangles();
		List<List<Integer>> res = sol.validTriangles(nums);
		System.out.println(res);
	}
}
