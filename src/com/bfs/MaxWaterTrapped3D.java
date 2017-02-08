package com.bfs;

import java.util.PriorityQueue;

/**
 * Created by Tianran on 2/7/2017.
 */
public class MaxWaterTrapped3D {
	private static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public int maxWater(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(rows < 3 || cols < 3) {
			return 0;
		}
		int result = 0;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>();
		boolean[][] visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			minHeap.offer(new Cell(i, 0, matrix[i][0]));
			minHeap.offer(new Cell(i, cols - 1, matrix[i][cols-1]));
			visited[i][0] = true;
			visited[i][cols - 1] = true;
		}
		for(int j = 1; j < cols - 1; j++) {
			minHeap.offer(new Cell(0, j, matrix[0][j]));
			minHeap.offer(new Cell(rows - 1, j, matrix[rows - 1][j]));
			visited[0][j] = true;
			visited[rows - 1][j] = true;
		}
		while(!minHeap.isEmpty()) {
			Cell cur = minHeap.poll();

			for(int i = 0; i < 4; i++) {
				int newX = cur.x + DIR[i][0];
				int newY = cur.y + DIR[i][1];
				if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
					Cell nei = new Cell(newX, newY, matrix[newX][newY]);
					visited[newX][newY] = true;
					result += Math.max(cur.height - nei.height, 0);
					nei.height = Math.max(cur.height, nei.height);
					minHeap.offer(nei);
				}
			}
		}
		return result;
	}

	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int height;
		Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
		@Override
		public int compareTo(Cell another) {
			if(this.height == another.height) {
				return 0;
			}
			return this.height < another.height? -1 : 1;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{8,8,6,8},{8,7,6,8},{8,4,3,8},{8,8,8,8}};

		MaxWaterTrapped3D sol = new MaxWaterTrapped3D();
		int res = sol.maxWater(matrix);
		System.out.println(res);
	}

}
