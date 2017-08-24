package com.linkedlist;

/**
 * Created by Tianran on 8/15/2017.
 */
public class ReverseList {
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
