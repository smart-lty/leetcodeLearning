package leetcode;
import java.util.Deque;
import java.util.LinkedList;
public class T104 {
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
//		//�ݹ鷨���
		// DFS
//		if(root.left==null && root.right==null) return 1;
//		if(root.left!=null && root.right==null) return maxDepth(root.left)+1;
//		if(root.left==null && root.right!=null) return maxDepth(root.right)+1;
//		else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
		
		//��ʹ�õ����أ�(BFS)
		//ע��BFS��ʹ�ü��ɣ�ÿ��Ҫ�����ж����ڵ�Ԫ�س����С�
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		Deque<TreeNode> temq = new LinkedList<TreeNode>();
		int ans = 0;
		q.push(root);
		while (!q.isEmpty()) {
			// �����зǿ�
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
