package leetcode;
import java.util.Deque;
import java.util.LinkedList;


public class T437 {
	public int path(TreeNode root, int sum) {
        if(root==null) return 0;
        int res=0;
        if(root.val==sum) res++;
        return res+path(root.left,sum-root.val)
        		+path(root.right,sum-root.val);
    }
	
	public int helper(TreeNode root,int sum,int []array, int p) {
		if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = helper(root.left, sum, array, p + 1);
        int n2 = helper(root.right, sum, array, p + 1);
        return n + n1 + n2;
	}
	
	public int pathSum(TreeNode root, int sum) {
		//���ֽⷨ��Ȼ���׶�����Ч�ʵ���
		//����˫�ݹ�
//	        if (root == null) {
//	            return 0;
//	        }
//
//	        int res = 0;
//	        // ����ÿ���ڵ㣬���ҽ�ÿһ���ڵ㶼��һ�� countPath()�������нڵ����Ч·��������
//	        res += path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//
//	        return res;
		
		//���ֽⷨ��Ϊ������ʹ�����������DFS������
		return helper(root,sum,new int[1000],0);
	    }
	 
	 

}
