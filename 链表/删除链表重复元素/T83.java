package leetcode;

public class T83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node!=null) {
			if (node.next!=null && node.val==node.next.val) {
				node.next = node.next.next;
			}
			else {
				node = node.next;
			}
		}
		return head;
    }
}
