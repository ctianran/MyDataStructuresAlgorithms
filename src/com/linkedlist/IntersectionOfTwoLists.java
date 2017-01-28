package com.linkedlist;

/**
 * Created by Tianran on 1/27/2017.
 */
public class IntersectionOfTwoLists {
	public ListNode intersection(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int oneLen = getLength(head1);
		int twoLen = getLength(head2);
		int diff = Math.abs(oneLen - twoLen);
		ListNode fast = null;
		ListNode slow = null;

		if (oneLen > twoLen) {
			fast = head1;
			slow = head2;
		} else {
			fast = head2;
			slow = head1;
		}

		while (diff > 0) {
			fast = fast.next;
			diff--;
		}
		while (fast != slow) {
		 	slow = slow.next;
		 	fast = fast.next;
		}
		return slow;
	}

	private int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
