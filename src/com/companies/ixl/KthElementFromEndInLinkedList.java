package com.companies.ixl;

import com.chentianran.ListNode;

/**
 * Created by Tianran on 8/14/2017.
 */
public class KthElementFromEndInLinkedList {
	public ListNode kthFromEnd(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}


}

