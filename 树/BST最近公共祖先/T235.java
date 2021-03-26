package leetcode;

public class T235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
        	if(root.val<p.val&&root.val<q.val) root=root.right;
        	if(root.val>p.val&&root.val>q.val) root=root.left;
            else break;
        }
        return root;
    }
}
