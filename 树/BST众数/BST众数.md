# BST众数

在一颗BST中求众数的方法：

首先我们肯定可以想到，用一个数组来存储BST中序遍历的结果，然后用这个数组计算众数；

之后我们考虑不保存中序遍历序列，优化空间复杂度；

最后考虑Morris遍历，使空间复杂度降为$$O(1)$$。[题解](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-zhong-shu-by-leetcode-/)

```java
List<Integer> res = new ArrayList<Integer>();
	int base,cnt,maxCnt;
	public int[] findMode(TreeNode root) {
		dfs(root);
		int []ans = new int[res.size()];
		for(int i=0;i<res.size();i++) ans[i]=res.get(i);
		return ans;
		
    }
	public void dfs(TreeNode root) {
		dfs(root.left);
		update(root.val);
		dfs(root.right);
		
	}
	public void update(int x) {
		if(x==base) {
			cnt++;
		}
		else {
			cnt=1;
			base=x;
		}
		if(cnt==maxCnt) res.add(x);
		if(cnt>maxCnt) {
			res.clear();
			maxCnt=cnt;
			res.add(x);
		}
	}
```

## Morris遍历

```java
int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
```

