# 有序数组转换BST

对于BST来说，它的中序遍历一定是升序的。那给定一个有序数组（升序），则该数组一定是BST的中序遍历结果。[题解](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/)

通过中序遍历并不能唯一的构造二叉搜索树，那如果加上高度平衡的要求呢？

结果也不是确定的，因此本题的答案有多种。我们每次取一个区间的中间点作为根节点，左右两边节点作为左右子树，即可得到一棵高度平衡的BST。

```java
public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		return helper(nums,0,n-1);
    }
	public TreeNode helper(int[] nums, int left, int right) {
		if(left>right) return null;
		int idx = (left+right)/2;
		TreeNode root = new TreeNode(nums[idx]);
		root.left = helper(nums,left,idx-1);
		root.right = helper(nums,idx+1,right);
		return root;
	}
```

