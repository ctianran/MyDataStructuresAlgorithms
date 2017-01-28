package com.linkedlist;

/**
 * Created by Tianran on 1/27/2017.
 */
public class AddTwoLinkedList {
		public ListNode addLists(ListNode head1, ListNode head2) {
				if(head1 == null) {
					return head2;
				}
				if(head2 == null) {
					return head1;
				}
				ListNode h1 = reverse(head1);
				ListNode h2 = reverse(head2);
				ListNode dummy = new ListNode(0);
				ListNode prev = dummy;

				int carry = 0;
				while(h1 != null || h2 != null) {
					int res = carry;
					if(h1 != null) {
						res += h1.val;
						h1 = h1.next;
					}
					if(h2 != null) {
						res += h2.val;
						h2 = h2.next;
					}
					ListNode node = new ListNode(res % 10);
					carry = res / 10;
					prev.next = node;
					prev = node;
				}

				if(carry >= 1) {
					prev.next = new ListNode(carry);
				}

				return reverse(dummy.next);
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

		public static void main(String[] args) {
			ListNode h1 = new ListNode(9);
			ListNode h2 = new ListNode(9);

			ListNode n1 = new ListNode(2);
			ListNode n2 = new ListNode(3);
			ListNode n3 = new ListNode(4);
			ListNode n4 = new ListNode(5);
			h1.next = n1;
			n1.next = n2;
			h2.next = n3;
			n3.next = n4;

			AddTwoLinkedList sol = new AddTwoLinkedList();
			ListNode out = sol.addLists(h1, h2);

			while(out != null) {
				System.out.print(out.val + " ");
				out = out.next;
			}
 		}
}
