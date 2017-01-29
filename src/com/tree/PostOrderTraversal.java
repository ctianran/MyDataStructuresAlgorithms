package com.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 1/28/2017.
 */
public class PostOrderTraversal {
	public void postorderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		postorderRecursive(root.left);
		postorderRecursive(root.right);
		System.out.print(root.val + " ");
	}

	public List<Integer> postorderIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode prev = null;
		stack.offerFirst(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if(prev == null || prev.left == cur || prev.right == cur) {
				if(cur.left != null) {
					stack.offerFirst(cur.left);
				} else if( cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					result.add(cur.val);
					stack.pollFirst();
				}
			} else if (cur.right == prev || (cur.left == prev && cur.right == null)) {
				result.add(cur.val);
				stack.pollFirst();
			} else {
				stack.offerFirst(cur.right);
			}
			prev = cur;
		}
		return result;
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

		PostOrderTraversal sol = new PostOrderTraversal();
		sol.postorderRecursive(n1);
		System.out.println();

		List<Integer> res = sol.postorderIterative(n1);
		System.out.println(res);
	}
}
