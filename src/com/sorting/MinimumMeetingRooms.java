package com.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Tianran on 2/18/2017.
 */
public class MinimumMeetingRooms {
	public int minRooms(float[][] schedules) {
		if(schedules == null || schedules.length == 0 || schedules[0].length == 0) {
			return 0;
		}
		Arrays.sort(schedules, new Comparator<float[]>(){
			@Override
			public int compare(float[] s1, float[] s2) {
				if(s1[0] == s2[0]) {
					return 0;
				}
				return s1[0] < s2[0] ? -1 : 1;
			}
		});

		PriorityQueue<Float> minHeap = new PriorityQueue<>();
		for(int i = 0; i < schedules.length; i++) {
			if(!minHeap.isEmpty() && schedules[i][0] >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.offer(schedules[i][1]);
		}
		return minHeap.size();
	}

	public static void main(String[] args) {
		float[][] schedules = new float[][] {{8, 10.5F}, {9, 12}, {11, 13}, {12, 15}};
		MinimumMeetingRooms sol = new MinimumMeetingRooms();
		int res = sol.minRooms(schedules);
		System.out.println(res);
	}
}
