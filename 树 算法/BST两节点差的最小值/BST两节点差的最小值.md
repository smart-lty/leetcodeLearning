# BST两节点差的最小值

初读本题，第一反应是如下解法：[题解](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/er-cha-sou-suo-shu-de-zui-xiao-jue-dui-chai-by-lee/)

+ 获得中序遍历结果。

+ 依次比较相邻数字差的最小值。

+ 返回最小值。

  ```java
  public int getMinimumDifference(TreeNode root) {
  		List<Integer> res = new ArrayList<Integer>();
  		inorder(root,res);
  		int n = res.size();
  		int min = Integer.MAX_VALUE;
  		for(int i = 1;i<n;i++) min = (res.get(i)-res.get(i-1))<min?(res.get(i)-res.get(i-1)):min;
  		return min;
      }
  	public void inorder(TreeNode root, List<Integer> res) {
  		if(root==null) return;
  		inorder(root.left,res);
  		res.add(root.val);
  		inorder(root.right,res);
  	}
  ```

  

仔细阅读之后，就可以发现优化的地方：在中序遍历时便可以比较，由此节省空间。

```java
int min = Integer.MAX_VALUE;
	TreeNode pre = null;
	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return min;
    }
	public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		if(pre!=null&&(root.val-pre.val)<min) min = root.val-pre.val;
        pre = root;
		inorder(root.right);
	}
```

