package leetcode;
import java.util.*;
public class T94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur!=null||!q.isEmpty()){
            while(cur!=null){
                q.push(cur);
                cur = cur.left;
            }
            TreeNode node = q.pop();
            res.add(node.val);
            cur = node.right;

        }
        return res;
            }
}
