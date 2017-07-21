package com.arrays;

import java.util.*;

/**
 * Created by Tianran on 7/8/2017.
 */
public class TaskScheduler {
	public int maxTaskCanFinish(List<Task> tasks) {
		Collections.sort(tasks, new Comparator<Task>(){
			@Override
			public int compare(Task t1, Task t2) {
				if(t1.start == t2.start) {
					return Integer.compare(t1.end, t2.end);
				}
				return t1.start < t2.start ? -1 : 1;
			}
		});

		int res = 1;
		Task prev = tasks.get(0);
		for(int i = 1; i < tasks.size(); i++) {
			Task cur = tasks.get(i);
			if(prev.end <= cur.start) {
				res++;
				prev = cur;
			}
		}
		return res;
	}

	static class Task {
		int start;
		int end;

		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int maxAssignmentsCanFinish(int[][] assignments) {
		Arrays.sort(assignments, new Comparator<int[]>(){
			@Override
			public int compare(int[] s1, int[] s2) {
				if(s1[0] == s2[0]) {
					return Integer.compare(s1[1], s2[1]);
				}
				return s1[0] < s2[0] ? -1 : 1;
			}
		});
		return 0;
	}

	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(6, 7));
		tasks.add(new Task(1, 2));
		tasks.add(new Task(3, 4));
		tasks.add(new Task(2, 3));
		tasks.add(new Task(3, 5));

		TaskScheduler sol = new TaskScheduler();
		int res = sol.maxTaskCanFinish(tasks);
		System.out.println(res);
	}
}
