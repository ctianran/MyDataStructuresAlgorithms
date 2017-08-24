package com.companies.ixl;


import com.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Tianran on 8/18/2017.
 */
public class TopThreeLargestInBST {
	public int[] topThree(TreeNode root) {
		if(root == null) {
			return new int[0];
		}
		int[] res = new int[3];
		int index = 0;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.right;
			} else {
				cur = stack.pollFirst();
				if(index >= 3) {
					break;
				}
				res[index++] = cur.val;
				cur = cur.left;
			}
		}
		if(index < 3) {
			throw new IllegalArgumentException("There are less than three elements in the tree.");
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n2.left = n1;
		//n2.right = n3;
		TopThreeLargestInBST sol = new TopThreeLargestInBST();

		int[] res = sol.topThree(n2);
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
