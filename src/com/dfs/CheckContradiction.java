package com.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 2/28/2017.
 */
public class CheckContradiction {
	public boolean hasContradiction(String[][] params) {
		if(params == null || params.length == 0 || params[0].length == 0) {
			return false;
		}
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> visited = new HashMap<>();

		for(int i = 0; i < params.length; i++) {
			List<String> list = map.get(params[i][0]);
			if(list == null) {
				list = new ArrayList<>();
				list.add(params[i][1]);
				map.put(params[i][0], list);
			} else {
				list.add(params[i][1]);
			}
		}

		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			if(dfs(entry.getKey(), map, visited)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(String s, Map<String, List<String>> map, Map<String, Integer> visited) {
		if(visited.containsKey(s)) {
			if(visited.get(s) == 0) {
				return false;
			}
			if(visited.get(s) == 1) {
				return true;
			}
		}
		visited.put(s, 1);
		if(map.containsKey(s)) {
			for(String n : map.get(s)) {
				if(dfs(n, map, visited)) {
					return true;
				}
			}
		}

		visited.put(s, 0);
		return false;
	}

	public static void main(String[] args) {
		String[][] input = new String[][] {{"a", "b"}, {"b", "c"}, {"a", "c"}, {"c", "d"}};
		CheckContradiction sol = new CheckContradiction();
		System.out.println(sol.hasContradiction(input));
	}
}
