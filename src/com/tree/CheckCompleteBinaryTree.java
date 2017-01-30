package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 1/29/2017.
 */
public class CheckCompleteBinaryTree {
	public boolean isComplete(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean flag = false;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.left == null) {
				flag = true;
			} else if(flag) {
				return false;
			} else {
				queue.offer(cur.left);
			}

			if(cur.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offer(cur.right);
			}
		}
		return true;
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

		CheckCompleteBinaryTree sol = new CheckCompleteBinaryTree();
		System.out.println(sol.isComplete(n1));
	}
}
