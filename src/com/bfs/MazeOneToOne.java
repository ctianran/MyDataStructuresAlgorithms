package com.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Tianran on 6/12/2017.
 */
public class MazeOneToOne {
	class Cell {
		private int x;
		private int y;
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int shortestPath(int[][] matrix, int startX, int startY, int endX, int endY) {
		Cell start = new Cell(startX, startY);
		Cell end = new Cell(endX, endY);
		int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Queue<Cell> queue = new LinkedList<>();
		Set<Cell> visited = new HashSet<>();
		queue.offer(start);
		visited.add(start);
		int res = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Cell cur = queue.poll();
				if(cur == end) {

				}
			}
		}
		return 0;
	}
}
