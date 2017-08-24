package com.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tianran on 1/28/2017.
 */
public class FlattenMultiLevelLinkedList {
	public ListNode flattenI(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null) {
			fast = fast.next;
		}

		while(slow != null) {
			if(slow.child != null) {
				ListNode temp = slow.child;
				while(temp != null) {
					fast.next = temp;
					fast = fast.next;
					temp = temp.next;
				}
			}
			slow = slow.next;
		}
		return head;
	}

	public ListNode flattenII(ListNode head) {
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

	public ListNode flattenIII(ListNode head) {
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

	public ListNode flattenIV(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = head.next;
		if(head.child != null) {
			head.next = flattenIV(head.child);
		}
		if(next != null) {
			cur.next = flattenIV(next);
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);

		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(10);
		ListNode n11 = new ListNode(11);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n1.child = n6;
		n6.next = n7;
		n3.child = n8;
		n8.child = n9;
		n9.next = n10;
		n10.child = n11;

		FlattenMultiLevelLinkedList sol = new FlattenMultiLevelLinkedList();
		ListNode res = sol.flattenIV(n1);

		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}
}
