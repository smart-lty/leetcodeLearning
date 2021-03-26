package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T337 {
	//每个节点对应一个f函数值与g函数值
	Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
	Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();
	public int rob(TreeNode root) {
//		//初级做法
//		if(root==null) return 0;
//		int ret = root.val;
//		if(root.left!=null) ret+=rob(root.left.left)+rob(root.left.right);
//		if(root.right!=null) ret+=rob(root.right.left)+rob(root.right.right);
//		return Math.max(ret, rob(root.left)+rob(root.right));
		
		//动态规划
		dfs(root);
		return Math.max(f.getOrDefault(root,0), g.getOrDefault(root,0));
    }
	public void dfs(TreeNode node) {
		if(node==null) return;
		dfs(node.left);
		dfs(node.right);
		f.put(node, node.val+g.getOrDefault(node.left, 0)+g.getOrDefault(node.right, 0));
		g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))+Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
	}
}
