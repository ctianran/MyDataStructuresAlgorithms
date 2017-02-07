package com.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 2/6/2017.
 */
public class MinMoveInFloorPlan {

	private static int[][] DIR = {{1, 0},{0, 1}, {-1, 0}, {0, -1}};

	public int minMove(char[][] board, int m, int n) {
		Queue<Cell> queue = new LinkedList<>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		queue.offer(new Cell(0, 0, 0));
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			Cell cur = queue.poll();
			if(cur.x == m && cur.y == n) {
				return cur.dist;
			}
			for(int i = 0; i < 4; i++) {
				int newX = cur.x + DIR[i][0];
				int newY = cur.y + DIR[i][1];
				if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
								&& !visited[newX][newY] && board[newX][newY] == '.') {
					visited[newX][newY] = true;
					queue.offer(new Cell(newX, newY, cur.dist + 1));
				}
			}
		}
		return -1;
	}

	public int numCellsEqualtoTargetDistance(char[][] board, int distance) {
		Queue<Cell> queue = new LinkedList<>();
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		queue.offer(new Cell(0, 0, 0));
		visited[0][0] = true;
		int result = 0;
		while(!queue.isEmpty()) {
			Cell cur = queue.poll();
			if(cur.dist == distance) {
				result++;
			} else if(cur.dist > distance) {
				break;
			}
			for(int i = 0; i < 4; i++) {
				int newX = cur.x + DIR[i][0];
				int newY = cur.y + DIR[i][1];

				if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]
								&& board[newX][newY] == '.') {
					visited[newX][newY] = true;
					queue.offer(new Cell(newX, newY, cur.dist + 1));
				}
			}
		}
		return result;
	}

	private static class Cell {
		int x;
		int y;
		int dist;
		public Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		char[][] board = {{'.', '#', '.', '.', '#'},
											{'.', '#', '.', '.', '.'},
											{'.', '.', '.', '#', '.'},
											{'.', '.', '.', '.', '.'},
											{'.', '#', '#', '#', '.'}};

		MinMoveInFloorPlan sol = new MinMoveInFloorPlan();

		int res = sol.minMove(board, 2,2);
		int res2 = sol.numCellsEqualtoTargetDistance(board, 7);
		System.out.println(res);
		System.out.println(res2);
	}
}
