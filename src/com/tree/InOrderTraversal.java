package com.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 1/28/2017.
 */
public class InOrderTraversal {
	public void inorderRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderRecursive(root.left);
		System.out.print(root.val + " ");
		inorderRecursive(root.right);
	}

	public List<Integer> inorderIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				result.add(cur.val);
				cur = cur.right;
			}
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

		InOrderTraversal sol = new InOrderTraversal();
		sol.inorderRecursive(n1);
		System.out.println();

		List<Integer> res = sol.inorderIterative(n1);
		System.out.println(res);
	}
}