# 二叉搜索树第k小元素

本题我们需要利用一个性质：BST中序遍历是升序的。我们只需要进行中序遍历，取出第`k-1`个元素即可。

值得注意的是，迭代相比于递归可以`提前终止`。[题解](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/)

## 迭代

```java
public int kthSmallest(TreeNode root, int k) {
		int cnt = 0;
        int res = 0;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
        	while(cur!=null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	TreeNode node = stack.pop();
        	cnt++;
        	if(cnt==k) {
        		res = node.val;
        		break;
        	}
        	cur = node.right;
        }
        return res;
    }
```

## 递归

```java
	// 递归写法
	private int res;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);

        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        ++count;
        if (count == k) {
            res = root.val;
            return;
        }

        inorder(root.right, k);
    }
```

