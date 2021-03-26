package leetcode;

import java.util.*;

public class T637 {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int n = q.size();
			double sum = 0;
			for(int i = 0;i<n;i++) {
				TreeNode node = q.poll();
				if(node.left!=null) q.offer(node.left);
				if(node.right!=null) q.offer(node.right);
				sum+=node.val;
			}
			res.add(sum/n);
		}
		return res;
    }
}
