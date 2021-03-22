package leetcode;

public class T725 {
	public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0; // 记录链表长度
        ListNode node = root;
        while(node!=null) {
        	node = node.next;
        	length++;
        }
        
        int size = length/k;
        int mod = length%k;
        ListNode []res = new ListNode[k];
        node = root;
        for(int i = 0;node!=null&&i<k;i++) {
        	res[i]=node;
        	int nodeSize = size+(mod-->0?1:0);
        	for(int j=0;j<nodeSize-1;j++) {
        		node=node.next;//移动nodeSize-1步，来到子链的最后一个节点
        	}
        	ListNode nex = node.next;//下一条子链的起点
        	node.next = null;
        	node = nex;
        }
        return res;
    }
}
