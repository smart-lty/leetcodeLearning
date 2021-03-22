package leetcode;

public class T328 {
	public ListNode oddEvenList(ListNode head) {
		//��ż������Щ�����ڽ�������Ԫ��
		if(head==null || head.next==null || head.next.next==null) return head;
		ListNode single = head;
		ListNode ddouble = head.next;
		ListNode s = single;
		ListNode d = ddouble;
		while(s.next!=null && d.next!=null) {
			if(d.next!=null) {
				s.next=d.next;
				s = s.next;
			}
			if(s.next!=null) {
				d.next = s.next;
				d = d.next;
			}
		}
		s.next = ddouble;
		d.next = null;
		return single;
    }
}
