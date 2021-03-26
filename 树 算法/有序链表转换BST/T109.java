package leetcode;

public class T109 {
	ListNode ghead;
	public TreeNode sortedListToBST(ListNode head) {
		ListNode node = head;
		int len=0;
		while(node!=null) {
			len++;
			node=node.next;
		}
		ghead = head;
		return helper(0,len-1);
    }
	public TreeNode helper(int left,int right) {
		if(left>right) return null;
		int idx = (left+right+1)/2;
		TreeNode node = new TreeNode();
		node.left = helper(left,idx-1);
		node.val = ghead.val;
		ghead = ghead.next;
		node.right = helper(idx+1,right);
		return node;
	}
}
