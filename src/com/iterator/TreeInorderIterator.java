package com.iterator;

import com.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 1/30/2017.
 */
public class TreeInorderIterator {
	private Deque<TreeNode> stack;
	private TreeNode root;
	public TreeInorderIterator(TreeNode root) {
		if(root == null) {
			return;
		}
		stack = new LinkedList<TreeNode>();
		this.root = root;
		while(root != null) {
			stack.offerFirst(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Integer next() {
		TreeNode cur = stack.pollFirst();
		int result = cur.val;
		if(cur.right != null) {
			cur = cur.right;
			while(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}
		}
		return result;
	}

}
