package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tianran on 1/28/2017.
 */
public class LevelOrderTraversal {
	public List<Integer> level(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			result.add(cur.val);
			if(cur.left != null) {
				queue.offer(cur.left);
			}
			if(cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return result;
	}

	public void levelRecursive(TreeNode root) {
		if(root == null) {
			return;
		}
		int height = getHeight(root);
		for(int i = 1; i <= height; i++) {
			helper(root, i);
			System.out.println();
		}
	}

	private void helper(TreeNode root, int height) {
		if(root == null) {
			return;
		}
		if(height == 1) {
			System.out.print(root.val + " ");
		} else {
			helper(root.left, height - 1);
			helper(root.right, height - 1);
		}
	}

	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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

		LevelOrderTraversal sol = new LevelOrderTraversal();
		List<Integer> res = sol.level(n1);
		System.out.println(res);

		sol.levelRecursive(n1);
	}
}
