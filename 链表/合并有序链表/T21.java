package leetcode;

public class T21 {
	//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		// 思路：将一个链表作为基本链表，另一个链表循环插入
//		
//		ListNode head = l1;
//		ListNode node = l2;
//		while (node!=null) {
//			// 将当前node插入l1
//			// 若l1为空
//            if (head==null){
//                head=node;
//                node=node.next;
//                head.next=null;
//                continue;
//            }
//			ListNode v = head;
//			if (node.val<v.val) {
//				ListNode nex = node.next;
//				node.next = v;
//				head = node;
//				node = nex;
//			}
//			else {
//			while(node.val>=v.val && v.next!=null && node.val>=v.next.val) {
//				v=v.next;
//			}
//			if (v.next==null) {
//				v.next=node;
//				node = node.next;
//				v.next.next=null;
//			}
//			else {
//				ListNode nex = node.next;
//				node.next=v.next;
//				v.next=node;
//				node = nex;
//			}
//			}
//		}
//		return head;
		
		ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
