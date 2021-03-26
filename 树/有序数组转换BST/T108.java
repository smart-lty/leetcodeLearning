package leetcode;

public class T108 {
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
}
