package com.linkedlist;

/**
 * Created by Tianran on 1/31/2017.
 */
public class ConstructMaxPathSumList {
	/*public ListNode maxPathSum(ListNode one, ListNode two) {
		if(one == null) {
			return two;
		}
		if(two == null) {
			return one;
		}
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode startOne = one;
		ListNode startTwo = two;
		ListNode curOne = one;
		ListNode curTwo = two;
		while(curOne != null || curTwo != null) {
			int sumOne = 0;
			int sumTwo = 0;
			while(curOne != null && curTwo != null && curOne.val != curTwo.val) {
				if(curOne.val < curTwo.val) {
					sumOne += curOne.val;
					curOne = curOne.next;
				} else if (curOne.val > curTwo.val) {
					sumTwo += curTwo.val;
					curTwo = curTwo.next;
				}
			}
			if(curOne == null) {

			}
			if(curTwo == null) {

			}

			if(sumOne >= sumTwo) {
				prev.next = startOne;
				prev = curOne;
			} else {
				prev.next = startTwo;
				prev = curTwo;
			}
			startOne = curOne.next;
			startTwo = curTwo.next;
		}
	}*/
}
