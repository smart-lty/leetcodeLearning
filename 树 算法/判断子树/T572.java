package leetcode;
import java.util.*;
public class T572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        Deque<TreeNode> tree1 = new LinkedList<TreeNode>();
        tree1.offer(s);
        while(!tree1.isEmpty()) {
        	TreeNode node = tree1.poll();
        	if(isSame(node,t)) return true;
        	else {
        		if(node.left!=null)
        		tree1.offer(node.left);
        		if(node.right!=null)
        		tree1.offer(node.right);
        	}
        }
        return false;
    }
	public boolean isSame(TreeNode s,TreeNode t) {
		if (s==null&&t==null) return true;
		if (s!=null&&t!=null&&s.val==t.val) return isSame(s.left,t.left)&&isSame(s.right,t.right);
		else return false;
		
	}
}
