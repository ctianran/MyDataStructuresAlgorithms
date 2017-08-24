package com.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 8/12/2017.
 */
public class FlattenLinkedList {
	static class ListNode {
		public int val;
		public ListNode next;
		public  ListNode child;
		public ListNode(int val) {
			this.val = val;
		}
	}
	public ListNode flattenIterative(ListNode head) {
		if(head == null) {
			return head;
		}
		Deque<ListNode> stack = new LinkedList<>();
		ListNode cur = head;
		while(cur != null) {
			if(cur.child != null) {
				if(cur.next != null) {
					stack.offerFirst(cur.next);
				}
				cur.next = cur.child;
			} else if(cur.next == null){
				cur.next = stack.isEmpty() ? null : stack.pollFirst();
			}
			cur = cur.next;
		}
		return head;
	}

	public ListNode flattenRecursive(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode[] last = new ListNode[1];
		return helper(head, last);
	}

	private ListNode helper(ListNode head, ListNode[] last) {
		if(head == null) {
			return head;
		}
		last[0] = head;
		ListNode next  = head.next;
		if(head.child != null) {
			head.next = helper(head.child, last);
		}
		if(next != null) {
			last[0].next = helper(next, last);
		}
		return head;
	}


	public static void main(String[] args) {
			FlattenLinkedList sol = new FlattenLinkedList();
			/* tests case1:
			1 - 2 - 3 - 4 - 5
		  |       |
		  6 - 7   8
		          |
		          9 - 10
		               |
		              11
		*/
		ListNode t1n1 = new ListNode(1);
		ListNode t1n2 = new ListNode(2);
		ListNode t1n3 = new ListNode(3);
		ListNode t1n4 = new ListNode(4);
		ListNode t1n5 = new ListNode(5);
		ListNode t1n6 = new ListNode(6);
		ListNode t1n7 = new ListNode(7);
		ListNode t1n8 = new ListNode(8);
		ListNode t1n9 = new ListNode(9);
		ListNode t1n10 = new ListNode(10);
		ListNode t1n11 = new ListNode(11);
		t1n1.next = t1n2;
		t1n2.next = t1n3;
		t1n3.next = t1n4;
		t1n4.next = t1n5;
		t1n1.child = t1n6;
		t1n6.next = t1n7;
		t1n3.child = t1n8;
		t1n8.child = t1n9;
		t1n9.next = t1n10;
		t1n10.child = t1n11;

		ListNode res1 = sol.flattenIterative(t1n1);
// 	ListNode res1 = sol.flattenRecursive(t1n1);
		System.out.print("test1: ");
		while(res1 != null) {
			System.out.print(res1.val + " ");
			res1 = res1.next;
		}
		System.out.println();

		/* tests case2:
			1 - 2 - 3
		*/

		ListNode t2n1 = new ListNode(1);
		ListNode t2n2 = new ListNode(2);
		ListNode t2n3 = new ListNode(3);
		t2n1.next = t2n2;
		t2n2.next = t2n3;
		ListNode res2 = sol.flattenIterative(t2n1);
//		ListNode res2 = sol.flattenRecursive(t2n1);
		System.out.print("test2: ");
		while(res2 != null) {
			System.out.print(res2.val + " ");
			res2 = res2.next;
		}
		System.out.println();

		/* tests case3:
			1
			|
			2
			|
			3
		*/

		ListNode t3n1 = new ListNode(1);
		ListNode t3n2 = new ListNode(2);
		ListNode t3n3 = new ListNode(3);
		t3n1.child = t3n2;
		t3n2.child = t3n3;

		ListNode res3 = sol.flattenIterative(t3n1);
//  ListNode res3 = sol.flattenRecursive(t3n1);
		System.out.print("test3: ");
		while(res3 != null) {
			System.out.print(res3.val + " ");
			res3 = res3.next;
		}
		System.out.println();
	}
}
