package com.chentianran;

import java.io.IOException;

/**
 * Created by Tianran on 1/9/2017.
 */
public class Test {
	public static void main(String args[]) throws IOException {
			TreeNodeX root = new TreeNodeX(0);
		TreeNodeX n1 = new TreeNodeX(0);
		TreeNodeX n2 = new TreeNodeX(0);

		root.left = n1;
		root.right = null;
		Solution sol = new Solution();
		int i = sol.countNodes(root);
		System.out.println(i);
	}
}

class Solution {
	public int countNodes(TreeNodeX root) {
		if(root == null) {
			return 0;
		}
		int left = countNodes(root.left);
		int right = countNodes(root.right);

		return left + right + 1;
	}
}
