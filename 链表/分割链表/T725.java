package leetcode;

public class T725 {
	public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0; // ��¼������
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
        		node=node.next;//�ƶ�nodeSize-1�����������������һ���ڵ�
        	}
        	ListNode nex = node.next;//��һ�����������
        	node.next = null;
        	node = nex;
        }
        return res;
    }
}
