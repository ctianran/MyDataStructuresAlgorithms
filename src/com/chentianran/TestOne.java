package com.chentianran;

/**
 * Created by Tianran on 1/23/2017.
 */
public class TestOne {
	public int count(TreeNodeX root, int a, int b) {
			if(root == null) {
				return 0;
			}

			int left = count(root.left, a, b);
			int right = count(root.right, a, b);

			if(root.val < a) {
				return right;
			}
			if(root.val > b) {
				return left;
			}

			return left + right + 1;
	}
}
