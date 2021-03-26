package leetcode;

public class T543 {
	int ans=0;
	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null) return 0;
		// µÝ¹é·¨
//		return Math.max(
//				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)),
//				maxDepth(root.left)+maxDepth(root.right)
//				);
		maxDepth(root);
		return ans;
		
    }
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		//µÝ¹é·¨½â´ð
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		int l = left+right;
		ans = Math.max(ans, l);
		return Math.max(right, left)+1;
    }
}
