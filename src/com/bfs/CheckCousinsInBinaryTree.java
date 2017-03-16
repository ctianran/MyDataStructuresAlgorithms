package com.bfs;

import com.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tianran on 3/14/2017.
 */
public class CheckCousinsInBinaryTree {
	public boolean isCousin(TreeNode root, TreeNode one, TreeNode two) {
		if(root == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int count = 0;
			for(int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if(cur == one || cur == two) {
					count++;
				}
				if(cur.left != null && cur.right != null) {
					if(cur.left == one && cur.right == two || cur.left == two && cur.right == one) {
						return false;
					}
				}
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
			}
			if(count == 2) {
				return true;
			} else if (count == 1) {
				return false;
			}
		}
		return false;
	}
}
