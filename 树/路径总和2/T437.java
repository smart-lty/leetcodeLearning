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
		//此种解法虽然简单易懂，但效率低下
		//尝试双递归
//	        if (root == null) {
//	            return 0;
//	        }
//
//	        int res = 0;
//	        // 遍历每个节点，并且将每一个节点都过一遍 countPath()，将所有节点的有效路径加起来
//	        res += path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//
//	        return res;
		
		//此种解法较为高明，使用数组完成类DFS搜索。
		return helper(root,sum,new int[1000],0);
	    }
	 
	 

}
