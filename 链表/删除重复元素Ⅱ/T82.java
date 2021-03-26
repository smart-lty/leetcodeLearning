package leetcode;

public class T82 {
	 public ListNode deleteDuplicates(ListNode head) {
//		 ListNode dummy = new ListNode(-1);
//		 dummy.next = head;
//		 ListNode slow=dummy,fast=head;
//		 boolean flag=false;
//		 while(fast!=null) {
//			 flag = false;
//			 while(fast.next!=null&&fast.val==fast.next.val) {
//				 flag = true;
//				 fast=fast.next;
//			 }
//			 if(flag) {
//				 fast = fast.next;
//			 }
//			 else {
//				 slow.next = fast;
//				 slow = slow.next;
//				 fast = fast.next;
//			 }
//		 }
//		 if(flag) {
//			 slow.next = fast;
//		 }
//		 return dummy.next;
		 if (head == null) {
	            return head;
	        }
	        
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode cur = dummy;
	        while (cur.next != null && cur.next.next != null) {
	            if (cur.next.val == cur.next.next.val) {
	                int x = cur.next.val;
	                while (cur.next != null && cur.next.val == x) {
	                    cur.next = cur.next.next;
	                }
	            } else {
	                cur = cur.next;
	            }
	        }

	        return dummy.next;
	    }
}
