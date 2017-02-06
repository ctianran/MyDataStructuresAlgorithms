package com.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			result.clear();
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
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();

		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(5);
		l3.add(3);
		l3.add(4);
		l3.add(5);
		l3.add(6);
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		CommonElementsInKArrays sol = new CommonElementsInKArrays();
		List<Integer> res = sol.common(lists);
		System.out.println(res);
	}
}
