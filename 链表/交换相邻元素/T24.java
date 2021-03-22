package leetcode;

public class T24 {
	public ListNode swapPairs(ListNode head) {
		if (head==null || head.next==null) return head;
		ListNode pre = null;
		ListNode fast = head.next.next;
		ListNode slow = head;
		ListNode newHead = slow.next;
		while (slow != null && slow.next!=null) {
			ListNode medium = slow.next;
			if (pre!=null) {
				pre.next=medium;
			}
			medium.next = slow;
			slow.next = fast;
			pre = slow;
			slow = fast;
			if (fast!= null && fast.next!=null) {
				fast = fast.next.next;
				
			}
			else {
				break;
			}
			
		}
		return newHead;
    }
}
