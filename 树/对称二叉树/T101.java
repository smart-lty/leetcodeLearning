package leetcode;
import java.util.Deque;
import java.util.LinkedList;
public class T101 {
	public boolean isSy(TreeNode node1, TreeNode node2) {
		if(node1==null&&node2==null) return true;
		if(node1!=null&&node2!=null&&node1.val==node2.val) return isSy(node1.left,node2.right)&&isSy(node1.right,node2.left);
		else return false;
	}
	public boolean isSymmetric(TreeNode root) {
	   if(root==null) return true;
	   
//	   // ���Ե����ⷨ
//	   Deque<TreeNode> q = new LinkedList<TreeNode>();
//	   Deque<TreeNode> temp1 = new LinkedList<TreeNode>();
//	   Deque<TreeNode> temp2 = new LinkedList<TreeNode>();
//	   q.offer(root);
//	   while(!q.isEmpty()) {
//		   while(!q.isEmpty()) {
//			   TreeNode node = q.poll();
//			   if(node!=null) {
//				   temp1.offer(node.left);
//				   temp1.offer(node.right);
//			   }
//			   temp2.offer(node);
//		   }
//		   
//		   // temp2�洢��ǰ��Ľڵ㣬temp1�洢��һ��Ľڵ�
//		   // �ж�temp2�Ƿ�Գ�
//		   if(temp2.size()>1) {
//			   if(temp2.size()%2==0) {
//				   while(!temp2.isEmpty()) {
//					   TreeNode node1 = temp2.pollFirst();
//					   TreeNode node2 = temp2.pollLast();
//					   if(node1==null&&node2==null) continue;
//					   else if(node1!=null&&node2!=null&&node1.val==node2.val) continue;
//					   else return false;
//			   			}
//			   	}
//		   
//			   else return false;
//		   }
//		   else {
//			   temp2.poll();
//		   }
//		   
//		   while(!temp1.isEmpty()) {
//			   q.offer(temp1.poll());
//		   }
//		   
//	   }
//	   return true;
	   
	   //���Եݹ�ⷨ   
	  return isSy(root.left,root.right);
	}
	   
}
