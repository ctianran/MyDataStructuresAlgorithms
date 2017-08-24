package com.companies.ixl;

import java.util.*;

/**
 * Created by Tianran on 8/14/2017.
 */
public class DuplicateStrings {
	//sort: O(nlogn * m)   m : average length of strings
	public List<String> duplicateStrings(String[] strs) {
		//sanity check
		List<String> res = new ArrayList<>();
		if(strs == null) {
			return res;
		}
		Arrays.sort(strs);  //O(nlogn * m)
		int index = 0;
		while(index < strs.length - 1) {
			if(strs[index].equals(strs[index + 1])) {
				res.add(strs[index]);
				while(index < strs.length - 1 && strs[index] == strs[index + 1]) {
					index++;
				}
			}
			index++;
		}
		return res;
	}
	//use extra space
	//Time: o(n)
	//Space: O(n)
	public List<String> duplicateStringsII(String[] strs) {
		List<String> res = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			if(map.containsKey(strs[i])) {
				map.put(strs[i], map.get(strs[i]) + 1);
			} else {
				map.put(strs[i], 1);
			}
		}

		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				res.add(entry.getKey());
			}
		}
		return res;
	}


	public static void main(String[] args) {
		String[] strs = new String[] {"a", "b", "c", "a", "b", "c", "d", "c"};
		DuplicateStrings sol = new DuplicateStrings();
		List<String> res = sol.duplicateStrings(strs);
		System.out.println(res);
		List<String> res2 = sol.duplicateStrings(strs);
		System.out.println(res2);
	}
}
