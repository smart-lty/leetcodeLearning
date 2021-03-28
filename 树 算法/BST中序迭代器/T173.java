package leetcode;
import java.util.*;
public class T173 {
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	public T173(TreeNode root) {
        TreeNode node = root;
        while(node!=null) {
        	stack.push(node);
        	node=node.left;
        }
    }
    
    public int next() {
    	TreeNode node = stack.pop();
    	if(node.right!=null) {
    		TreeNode p = node.right;
    		while(p!=null) {
    			stack.push(p);
    			p=p.left;
    		}
    	}
    	return node.val;
    }
    
    public boolean hasNext() {
    	return !stack.isEmpty();
    }
}
