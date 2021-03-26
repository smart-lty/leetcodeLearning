package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class T110 {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		//递归法解答
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
	public int cur(TreeNode root) {
		// 若该节点对应的树为⚖树，则返回最大高度，否则返回-1
		if(root==null) return 0;
		int left = cur(root.left);
		if(left==-1) return -1;
		int right = cur(root.right);
		if(right==-1) return -1;
		return (Math.abs(left-right)<2)?(Math.max(left, right)+1):-1;
	}
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
//		//递归法解答
//		return isBalanced(root.left)&&isBalanced(root.right)&&(Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1);
		
		//更为巧妙的解法是：
		return cur(root)!=-1;
	}
}
