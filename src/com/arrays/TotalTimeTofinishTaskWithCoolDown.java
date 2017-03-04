package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 3/3/2017.
 */
public class TotalTimeTofinishTaskWithCoolDown {
	public int totalTime(String s, int k) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int time = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			time++;
			if(map.containsKey(ch) && time - map.get(ch) <= k) {
				map.put(ch, map.get(ch) + k + 1);
				time = map.get(ch);
			} else {
				map.put(ch, time);
			}
		}
		return map.get(s.charAt(s.length() - 1));
	}

	public static void main(String[] args) {
		String s = "AABCB";
		TotalTimeTofinishTaskWithCoolDown sol = new TotalTimeTofinishTaskWithCoolDown();
		int res = sol.totalTime(s, 3);
		System.out.println(res);
	}
}
