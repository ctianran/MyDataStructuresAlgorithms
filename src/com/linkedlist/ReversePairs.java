package com.linkedlist;

/**
 * Created by Tianran on 1/26/2017.
 */
public class ReversePairs {
	public ListNode reverseRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		ListNode newNode = reverseRecursive(newHead.next);
		newHead.next = head;
		head.next = newNode;
		return newHead;
	}

	public ListNode reverseIterative(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		while(cur!= null && cur.next != null) {
			ListNode next = cur.next;
			ListNode nnext = next.next;
			prev.next = next;
			next.next = cur;
			cur.next = nnext;
			prev = cur;
			cur = nnext;
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode cur = n1;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

		ReversePairs sol = new ReversePairs();
		ListNode out1 = sol.reverseIterative(n1);

		cur = out1;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println();

		ListNode out2 = sol.reverseRecursive(out1);

		cur = out2;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
 }
