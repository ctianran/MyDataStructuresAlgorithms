package com.special;

import java.util.*;

/**
 * Created by Tianran on 3/15/2017.
 */
public class SkylineAlgorithm {
	public int getArea(Rectangle[] rectangles) {
		if(rectangles == null || rectangles.length == 0) {
			return 0;
		}
		Point[] points = new Point[2 * rectangles.length];
		//map a rectangle's left point and right point
		Map<Point, Point> map = new HashMap<>();
		for(int i = 0; i < rectangles.length; i++) {
			Rectangle cur = rectangles[i];
			points[2 * i] = new Point(cur.start, cur.height, true);
			points[2 * i + 1] = new Point(cur.end, cur.height, false);
			map.put(points[2 * i], points[2 * i + 1]);
		}
		Arrays.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.x == p2.x) {
					return 0;
				}
				return p1.x < p2.x ? -1 : 1;
			}
		});

		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.height == p2.height) {
					return 0;
				}
				return p1.height < p2.height ? 1 : -1;
			}
		});

		int result = 0;
		for(int i = 0; i < points.length - 1; i++) {
			Point cur = points[i];
			Point next = points[i + 1];
			if(cur.isLeft) {
				maxHeap.offer(cur);
				Point top = maxHeap.peek();
				while(map.get(top).x <= cur.x) {
					maxHeap.poll();
					top = maxHeap.peek();
				}
				result += (next.x - cur.x) * top.height;
			} else {
				Point top = maxHeap.peek();
				if(map.get(top) == cur) {
					maxHeap.poll();
				}
				if(!maxHeap.isEmpty()) {
					result += (next.x - cur.x) * maxHeap.peek().height;
				}

			}
		}
		return result;
	}


	static class Rectangle {
		int start;
		int end;
		int height;
		public Rectangle(int start, int end, int height) {
			this.start = start;
			this.end = end;
			this.height = height;
		}
	}

	static class Point {
		int x;
		int height;
		boolean isLeft;
		public Point(int x, int height, boolean isLeft) {
			this.x = x;
			this.height = height;
			this.isLeft = isLeft;
		}
	}

	public static void main(String[] args) {
		Rectangle[] rec = new Rectangle[] {new Rectangle(0, 1, 4),
		                                   new Rectangle(2, 4, 2),
		                                   new Rectangle(3, 5, 3)};
		SkylineAlgorithm sol = new SkylineAlgorithm();
		int res = sol.getArea(rec);
		System.out.println(res);

	}
}
