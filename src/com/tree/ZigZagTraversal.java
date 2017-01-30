package com.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 1/29/2017.
 */
public class ZigZagTraversal {
	public void zigzag(TreeNode root) {
		if(root == null) {
			return;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		int level = 1;
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				//odd level
				if(level == 1) {
					TreeNode cur = deque.pollFirst();
					System.out.print(cur.val + " ");
					if(cur.left != null) {
						deque.offerLast(cur.left);
					}
					if(cur.right != null) {
						deque.offerLast(cur.right);
					}
				//even level
				} else if(level == 0) {
					TreeNode cur = deque.pollLast();
					System.out.print(cur.val + " ");
					if(cur.right != null) {
						deque.offerFirst(cur.right);
					}
					if(cur.left != null) {
						deque.offerFirst(cur.left);
					}
				}
			}
			System.out.println();
			level = 1 - level;
		}
	}


	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		ZigZagTraversal sol = new ZigZagTraversal();
		sol.zigzag(n1);
	}
}
