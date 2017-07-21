package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tianran on 7/16/2017.
 */
public class MostPointsWithPositiveSlope {
	public int mostPoints(List<Point> input) {
		if(input == null || input.size() == 0) {
			return 0;
		}
		Collections.sort(input, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.x == p2.x) {
					return p2.y - p1.y;
				}
				return p1.x < p2.x ? -1 : 1;
			}
		});

		//find the longest ascending subsequence accroding to y coordinate
		int[] dp = new int[input.size()];
		int res = 1;
		for(int i = 0; i < input.size(); i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(input.get(i).y > input.get(j).y) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	public static void main(String[] args) {
		List<Point> input = new ArrayList<>();
		input.add(new Point(1, 2));
		input.add(new Point(2, 3));
		input.add(new Point(3, 4));
		input.add(new Point(4, 1));
		input.add(new Point(5, 2));
		input.add(new Point(6, 3));
		input.add(new Point(7, 4));

		MostPointsWithPositiveSlope sol = new MostPointsWithPositiveSlope();
		int res = sol.mostPoints(input);
		System.out.println(res);
	}
}
