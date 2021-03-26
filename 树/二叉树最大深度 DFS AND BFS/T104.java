package leetcode;
import java.util.Deque;
import java.util.LinkedList;
public class T104 {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
//		//递归法解答
		// DFS
//		if(root.left==null && root.right==null) return 1;
//		if(root.left!=null && root.right==null) return maxDepth(root.left)+1;
//		if(root.left==null && root.right!=null) return maxDepth(root.right)+1;
//		else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
		
		//若使用迭代呢？(BFS)
		//注意BFS的使用技巧，每次要将所有队列内的元素出队列。
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		Deque<TreeNode> temq = new LinkedList<TreeNode>();
		int ans = 0;
		q.push(root);
		while (!q.isEmpty()) {
			// 当队列非空
			while(!q.isEmpty()) {
				temq.add(q.poll());
			}
			ans++;
			while(!temq.isEmpty()) {
				TreeNode node = temq.poll();
				if(node.left!=null) q.add(node.left);
				if(node.right!=null) q.add(node.right);
			}
		}
		return ans;
    }
}
