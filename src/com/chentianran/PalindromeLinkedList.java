package com.chentianran;

/**
 * Created by Tianran on 1/18/2017.
 */
public class PalindromeLinkedList {
	//Time: O(n)
	//Space: O(1)
	public boolean isPalRecursive(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode[] left = new ListNode[] {head};
		return helper(left, head);
	}

	private boolean helper(ListNode[] left, ListNode head) {
		if(head == null) {
			return true;
		}
		boolean result = helper(left, head.next) && left[0].value == head.value;
		left[0] = left[0].next;
		return result;
	}


	//Time: O(n)
	//Space: O(1)
	public boolean isPalIterative(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head1 = head;
		ListNode head2 = slow.next;
		slow.next = null;

		head2 = reverse(head2);

		while(head1 != null && head2 != null) {
			if(head1.value != head2.value) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	//Time: O(n)
	//Space: O(n)
	public boolean isPalNewList(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode cur = head;
		ListNode head2 = new ListNode(head.value);
		//create new ListNode and link it in reverse order
		while(cur.next != null) {
			ListNode temp = new ListNode(cur.next.value);
			temp.next = head2;
			head2 = temp;
			cur = cur.next;
		}

		ListNode head1 = head;
		while(head1 != null) {
			if(head1.value != head2.value) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}
}
