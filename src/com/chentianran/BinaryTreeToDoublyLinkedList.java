package com.chentianran;

/**
 * Created by Tianran on 1/14/2017.
 */
public class BinaryTreeToDoublyLinkedList {

	public TreeNodeX convert(TreeNodeX root) {
		if(root == null) {
			return null;
		}
		TreeNodeX[] head = new TreeNodeX[] {null};
		TreeNodeX[] prev = new TreeNodeX[] {null};
		helper(root, prev, head);
		return head[0];
	}

	private void helper(TreeNodeX root, TreeNodeX[] prev, TreeNodeX[] head) {
		if(root == null) {
			return;
		}
		helper(root.left, prev, head);
		if(prev[0] == null) {
			head[0] = root;
		} else {
			root.left = prev[0];
			prev[0].right = root;
		}
		prev[0] = root;
		helper(root.right, prev, head);
	}

}
