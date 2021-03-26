package leetcode;
import java.util.*;
public class T145 {
	public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left==null&&node.right==null) {res.add(node.val);continue;}
			stack.push(new TreeNode(node.val));
            if(node.right!=null) stack.push(node.right);
			
			if(node.left!=null) stack.push(node.left);
		}
		return res;
    }
}
