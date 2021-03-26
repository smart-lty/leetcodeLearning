# BST两数之和

两数之和是基础问题了，但在BST中，两数之和却是一个无法用递归解决的问题（欢迎补充）。

[题解](https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-by-leetcode/)中给出了详细的四种方法的解答。

我考虑的方法是，首先对BST进行中序遍历，获得结果后使用双指针法筛查两数之和。

```java
public boolean findTarget(TreeNode root, int k) {
        // 在BST中查找两数之和
		// 对BST中序遍历后进行查找
		List<Integer> res = new ArrayList<Integer>();
		inorder(root,res);
		int l = res.size();
		int q1=0,q2=l-1;
		while(q1<q2) {
			int sum = res.get(q1)+res.get(q2);
			if(sum==k) return true;
			else if(sum>k) q2--;
			else q1++;
		}
		return false;
    }
	public void inorder(TreeNode root, List<Integer> res) {
		if(root==null) return;
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
```

