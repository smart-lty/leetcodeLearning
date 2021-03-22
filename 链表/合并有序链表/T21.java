package leetcode;

public class T21 {
	//��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		// ˼·����һ��������Ϊ����������һ������ѭ������
//		
//		ListNode head = l1;
//		ListNode node = l2;
//		while (node!=null) {
//			// ����ǰnode����l1
//			// ��l1Ϊ��
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

        // �ϲ��� l1 �� l2 ���ֻ��һ����δ���ϲ��꣬����ֱ�ӽ�����ĩβָ��δ�ϲ����������
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
