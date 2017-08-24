package com.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Tianran on 3/3/2017.
 */
public class TotalTimeTofinishTaskWithCoolDown {
	//Time: O(n)
	//Space: O(n)
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
				time = map.get(ch) + k + 1;
			}
			map.put(ch, time);
		}
		return time;
	}

	//Time: O(n)
	//Space: O(k)
	public int totalTimeI(String s, int k) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		Queue<Cell> queue = new LinkedList<>();
		int curTime = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			curTime++;

			if(map.containsKey(ch) && curTime - map.get(ch) <= k) {
				curTime = map.get(ch) + k + 1;
			}
			//remove task already passed the cool down time
			while(!queue.isEmpty() && queue.peek().time < curTime - k) {
				Cell cur = queue.poll();
				map.remove(cur.ch);
			}
			map.put(ch, curTime);
			queue.offer(new Cell(ch, curTime));
		}
		return curTime;
	}

	class Cell {
		char ch;
		int time;
		public Cell(char ch, int time) {
			this.ch = ch;
			this.time = time;
		}
	}
	public static void main(String[] args) {
		String s = "AABCB";
		TotalTimeTofinishTaskWithCoolDown sol = new TotalTimeTofinishTaskWithCoolDown();
		int res = sol.totalTimeI(s, 2);
		System.out.println(res);
	}
}
