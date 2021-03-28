package leetcode;

public class T61 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null||k==0) return head;
		ListNode node = head;
		int l = 0;
		while(node!=null) {
			l++;
			node=node.next;
		}
		k = k%l;
        if(k==0) return head;
		ListNode slow=head,fast=head;
		for(int i=0;i<k;i++) fast=fast.next;
		while(fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		ListNode nhead = slow.next;
		slow.next=null;
		fast.next=head;
		return nhead;
    }
}
