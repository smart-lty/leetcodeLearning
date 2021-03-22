package leetcode;

public class T206 {
	public ListNode reverseList(ListNode head) {
		// ��תһ��������
		// ������ݹ����ַ���
		
		// ����
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
		
		// �ݹ�
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
