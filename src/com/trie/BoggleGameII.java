package com.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 2/7/2017.
 */
public class BoggleGameII {
	static final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public List<String> findWords(char[][] board, String[] words){
		List<String> result = new ArrayList<>();
		if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			throw new IllegalArgumentException("invalid input");
		}
		TrieNode root = buildTrie(words);
		int rows = board.length;
		int cols = board[0].length;
		StringBuilder sb = new StringBuilder();
		boolean[][] visited = new boolean[rows][cols];

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dfsHelper(i, j, visited, board, root, sb, result);
			}
		}
		return result;
	}

	private void dfsHelper(int x, int y, boolean[][] visited, char[][] board, TrieNode root, StringBuilder sb, List<String> result) {
		char ch = board[x][y];
		if(root.children.get(ch) == null) {
			return;
		}
		root = root.children.get(ch);
		sb.append(ch);
		if(root.isEnd) {
			result.add(sb.toString());
			root.isEnd = false;
		}
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int newX = x + DIR[i][0];
			int newY = y + DIR[i][1];
			if(newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
				continue;
			}
			dfsHelper(newX, newY, visited, board, root, sb, result);
		}
		visited[x][y] = false;
		sb.deleteCharAt(sb.length() - 1);
	}


	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		if(words == null || words.length == 0) {
			return root;
		}
		for(String word : words) {
			TrieNode cur = root;
			for(int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				TrieNode next = cur.children.get(ch);
				if(next == null) {
					next = new TrieNode();
					cur.children.put(ch, next);
				}
				cur = next;
			}
			cur.isEnd = true;
		}
		return root;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] {{'A', 'P','P','D'},{'P', 'P','L','G'},{'O', 'G','E','I'},{'D', 'K','L','M'}};
		String[] words = new String[] {"AT", "APP", "APPLE", "CAP", "CAT", "CATHY", "DOG"};

		BoggleGameII sol = new BoggleGameII();
		List<String> res = sol.findWords(board, words);
		System.out.println(res);
	}

}
