package leetcode;
import java.util.*;
public class T230 {
	public int kthSmallest(TreeNode root, int k) {
		int cnt = 0;
        int res = 0;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
        	while(cur!=null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	TreeNode node = stack.pop();
        	cnt++;
        	if(cnt==k) {
        		res = node.val;
        		break;
        	}
        	cur = node.right;
        }
        return res;
    }
	// µ›πÈ–¥∑®
//	private int res;
//    private int count;
//
//    public int kthSmallest(TreeNode root, int k) {
//        inorder(root, k);
//
//        return res;
//    }
//
//    public void inorder(TreeNode root, int k) {
//        if (root == null) {
//            return;
//        }
//
//        inorder(root.left, k);
//
//        ++count;
//        if (count == k) {
//            res = root.val;
//            return;
//        }
//
//        inorder(root.right, k);
//    }
}
