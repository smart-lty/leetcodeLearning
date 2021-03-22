package leetcode;

public class T206 {
	public ListNode reverseList(ListNode head) {
		// 反转一个单链表。
		// 迭代或递归两种方法
		
		// 迭代
		ListNode pre = null;
		ListNode node = head;
        ListNode nex;
		while (node!=null){
			nex = node.next;
			node.next = pre;
			pre = node;
			node = nex;
		}

		return pre;
		
		// 递归
//		if (head==null || head.next==null) {
//			return head;
//		}
//		ListNode nex = head.next;
//		nex = reverseList(nex);
//		head.next.next = head;
//		head.next = null;
//		return nex;
    }
}
