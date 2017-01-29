package com.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 1/28/2017.
 */
public class PreOrderTraversal {
	public void preorderRecursive(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	}

	public List<Integer> preorderIterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offer(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			result.add(cur.val);
			if(cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if(cur.left != null) {
				stack.offerFirst(cur.left);
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

		PreOrderTraversal sol = new PreOrderTraversal();
		sol.preorderRecursive(n1);
		List<Integer> res = sol.preorderIterative(n1);
		System.out.println(res);
	}
}
