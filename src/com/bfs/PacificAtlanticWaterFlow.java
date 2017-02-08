package com.bfs;

import java.util.*;

/**
 * Created by Tianran on 2/7/2017.
 */
public class PacificAtlanticWaterFlow {
	private static int[][] DIR = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
	public List<List<Integer>> canFlow(int[][] matrix) {
		List<List<Integer>> result = new ArrayList<>();
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visitedPtoA = new boolean[rows][cols];
		boolean[][] visitedAtoP = new boolean[rows][cols];

		for(int i = 0; i < rows; i++) {
			bfsHelper(i, 0, matrix, visitedPtoA);
			bfsHelper(i, cols-1, matrix, visitedAtoP);
		}
		for(int j = 1; j < cols; j++) {
			bfsHelper(0, j, matrix, visitedPtoA);
			bfsHelper(rows - 1, j, matrix, visitedAtoP);
		}

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(visitedAtoP[i][j] && visitedPtoA[i][j]) {
					result.add(Arrays.asList(i, j));
				}
			}
		}
		return result;
	}

	private void bfsHelper(int x, int y, int[][] matrix, boolean[][] visited) {
		Queue<Cell> queue = new LinkedList<>();
		queue.offer(new Cell(x, y, matrix[x][y]));
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Cell cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int newX = cur.x + DIR[i][0];
				int newY = cur.y + DIR[i][1];
				if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
								&& !visited[newX][newY] && matrix[x][y] >= matrix[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Cell(newX, newY, matrix[newX][newY]));
				}
			}
		}
	}

	static class Cell {
		int x;
		int y;
		int height;
		Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{5,5,4,5,5}, {6,6,7,6,6},{4,4,5,4,4},{3,3,4,3,3}};
		PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();
		List<List<Integer>> res = sol.canFlow(matrix);
		System.out.println(res);
	}
}
