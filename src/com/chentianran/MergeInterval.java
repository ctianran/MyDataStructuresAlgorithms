package com.chentianran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tianran on 1/25/2017.
 */
public class MergeInterval {
	public List<List<Integer>> merge(List<List<Integer>> input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(input == null) {
			return result;
		}
		Collections.sort(input, new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				return l1.get(0).compareTo(l2.get(0));
			}
		});

		List<Integer> prev = input.get(0);
		for(int i = 1; i < input.size(); i++) {
			List<Integer> cur = input.get(i);
			if(cur.get(0) > prev.get(prev.size() - 1)) {
				result.add(prev);
				prev = cur;
			} else {
				prev.set(prev.size() - 1, Math.max(prev.get(prev.size() - 1), cur.get(cur.size() - 1)));
			}
		}
		result.add(prev);
		return result;
	}
}
