package com.arrays;

import java.util.*;

/**
 * Created by Tianran on 2/5/2017.
 */
public class CommonElementsInKArrays {
	public List<Integer> common(List<List<Integer>> input) {
		List<Integer> result = new ArrayList<>();
		if(input == null || input.isEmpty()) {
			return result;
		}
		result = input.get(0);
		for(int i = 1; i < input.size(); i++) {
			Set<Integer> set = new HashSet<>();
			for(int num : result) {
				set.add(num);
			}
			result = new ArrayList<>();
			for(int j = 0; j < input.get(i).size(); j++) {
				if(set.contains(input.get(i).get(j))) {
					result.add(input.get(i).get(j));
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> l2 = Arrays.asList(2, 3, 4, 5);
		List<Integer> l3 = Arrays.asList(3, 4, 5, 6);

		lists.add(l1);
		lists.add(l2);
		lists.add(l3);


		CommonElementsInKArrays sol = new CommonElementsInKArrays();
		List<Integer> res = sol.common(lists);
		System.out.println(res);
	}
}
