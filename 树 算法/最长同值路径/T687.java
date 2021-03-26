package leetcode;

public class T687 {
	int ans=0;
	public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;
    }
	
	public int arrowLength(TreeNode node) {
		if(node==null) return 0;
		int left = arrowLength(node.left);
		int right = arrowLength(node.right);
		if(node.left!=null&&node.left.val==node.val) left+=1;
		else left=0;
		if(node.right!=null&&node.right.val==node.val) right+=1;
		else right=0;
		ans = Math.max(ans, left+right);
		return Math.max(left, right);
}
}