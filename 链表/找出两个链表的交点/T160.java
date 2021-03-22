package leetcode;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
 
public class T160 {
//	��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        �� A ������Ϊa��B������Ϊb�����ǹ������ֵĳ���Ϊc
//        �� A ������еĳ���Ϊa-c��B������г���Ϊb-c
//        ��A��ʼ���������ȱ�����A�����ٱ���b-c�Σ�������a+b-c��
//        ��B��ʼ���������ȱ�����B�����ٱ���a-c�Σ�������b+a-c��
//        ��ʱ��ͬʱ�����˵�һ�������ڵ�
	ListNode node1 = headA;
	ListNode node2 = headB;
	while (node1!=node2) {
		node1 = node1.next!=null?node1.next:headB;
		node2 = node2.next!=null?node2.next:headA;
	}
	return node1;
    }
}
