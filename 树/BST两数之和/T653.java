package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T653 {
	public boolean findTarget(TreeNode root, int k) {
        // 在BST中查找两数之和
		// 对BST中序遍历后进行查找
		List<Integer> res = new ArrayList<Integer>();
		inorder(root,res);
		int l = res.size();
		int q1=0,q2=l-1;
		while(q1<q2) {
			int sum = res.get(q1)+res.get(q2);
			if(sum==k) return true;
			else if(sum>k) q2--;
			else q1++;
		}
		return false;
    }
	public void inorder(TreeNode root, List<Integer> res) {
		if(root==null) return;
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
}
