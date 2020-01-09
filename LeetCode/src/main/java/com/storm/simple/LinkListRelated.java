package com.storm.simple;

import org.junit.Test;

import com.storm.common.ListNode;

public class LinkListRelated {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int len = 10;
		int[] num1 = new int[len];
		int[] num2 = new int[len];
		int count = len - 1;
		while (l1 != null && count >= 0) {
			num1[count] = l1.val;
			count--;
			l1 = l1.next;
		}
		count = len - 1;
		while (l2 != null && count >= 0) {
			num2[count] = l2.val;
			count--;
			l2 = l2.next;
		}
		String num1Str = "";
		String num2Str = "";
		for (int i = 0; i < num1.length; i++) {
			num1Str += num1[i];
		}
		for (int j = 0; j < num1.length; j++) {
			num2Str += num2[j];
		}
		System.out.println(num1Str);
		System.out.println(num2Str);

		Long x1 = Long.parseLong(num1Str);
		Long x2 = Long.parseLong(num2Str);
		Long x3 = x1 + x2;
		String str = x3.toString();
		System.out.println(str);
		char[] c = str.toCharArray();
		ListNode l3 = new ListNode(Integer.parseInt(c[c.length - 1] + ""));
		ListNode next = l3;
		for (int v = c.length - 2; v >= 0; v--) {
			ListNode tmp = new ListNode(Integer.parseInt(c[v] + ""));
			next.next = tmp;
			next = tmp;
		}
		return l3;
	}

	/**
	 * 考虑进位
	 */
	public ListNode addTwoNumbers_others(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	// 递归 原地排序
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	@Test
	public void test() {
		ListNode l1 = null;
		ListNode l2 = null;
		mergeTwoLists(l1, l2);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	// 相交单链表
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head.next;
		while (head != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			head = head.next;
			fast = fast.next.next;
		}
		return true;
	}

	public String convertToTitle(int n) {
		String AZ = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] CZ = AZ.toCharArray();

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			if (n % 26 == 0) {
				sb.append('Z');
				n = n / 26 - 1;
			} else {
				sb.append(CZ[n % 26]);
				n = n / 26;
			}
		}

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		char a = 'a';
		char b = (char) (a + 1);
		System.out.println(b);
	}
}
