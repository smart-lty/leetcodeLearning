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
//	编写一个程序，找到两个单链表相交的起始节点。
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        设 A 链表长度为a，B链表长度为b，它们公共部分的长度为c
//        则 A 链表独有的长度为a-c，B链表独有长度为b-c
//        从A开始遍历，首先遍历完A链表，再遍历b-c次，共遍历a+b-c次
//        从B开始遍历，首先遍历完B链表，再遍历a-c次，共遍历b+a-c次
//        此时则同时到达了第一个公共节点
	ListNode node1 = headA;
	ListNode node2 = headB;
	while (node1!=node2) {
		node1 = node1.next!=null?node1.next:headB;
		node2 = node2.next!=null?node2.next:headA;
	}
	return node1;
    }
}
