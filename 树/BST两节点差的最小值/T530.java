package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T530 {
	int min = Integer.MAX_VALUE;
	TreeNode pre = null;
	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return min;
    }
	public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		if(pre!=null&&(root.val-pre.val)<min) min = root.val-pre.val;
        pre = root;
		inorder(root.right);
	}
}
