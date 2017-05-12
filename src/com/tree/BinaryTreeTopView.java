package com.tree;

import java.util.*;

/**
 * Created by Tianran on 5/11/2017.
 */
public class BinaryTreeTopView {
	public List<Integer> topView(TreeNode root) {
		Deque<Integer> res = new LinkedList<>();
		Queue<Cell> queue = new LinkedList<>();
		queue.offer(new Cell(root, 0));
		res.offerLast(root.val);
		int leftMost = 0;
		int rightMost = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Cell cur = queue.poll();
				if(cur.node.left != null) {
					if(cur.col == leftMost) {
						res.offerFirst(cur.node.left.val);
						leftMost = cur.col - 1;
					}
					queue.offer(new Cell(cur.node.left, cur.col - 1));
				}
				if(cur.node.right != null) {
					if(cur.col == rightMost) {
						res.offerLast(cur.node.right.val);
						rightMost = cur.col + 1;
					}
					queue.offer(new Cell(cur.node.right, cur.col + 1));
				}
			}
		}
		return new ArrayList<Integer>(res);
	}

	class Cell {
		TreeNode node;
		int col;

		public Cell(TreeNode node, int col) {
			this.node = node;
			this.col = col;
		}
	}
}
