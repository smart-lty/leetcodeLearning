package leetcode;
import java.util.*;
public class T513 {
	int height=-1;
	int val=0;
	public void helper(TreeNode root, int h) {
		if(root==null) return;
		if(h>height) {
            height = h;
            val = root.val;
        }
		helper(root.left,h+1);
		helper(root.right,h+1);
	}
	public int findBottomLeftValue(TreeNode root) {
		//�ҵ����һ������ߵ�ֵ
		
//		//ֱ��˼·һ���������
//		Deque<TreeNode> q = new LinkedList<TreeNode>();
//		q.offer(root);
//		int ret = 0;
//		while(!q.isEmpty()) {
//			ret = q.peek().val;
//			int n = q.size();
//			for(int i = 0;i<n;i++) {
//				TreeNode node = q.poll();
//				if(node.left!=null) q.offer(node.left);
//				if(node.right!=null) q.offer(node.right);
//					} 
//		}
//		return ret;
		
		//ֱ��˼·�����ݹ�
		//�ݹ�˼·����¼�߶�
		helper(root,0);
		return val;
    }
}
