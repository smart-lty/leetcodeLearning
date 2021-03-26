# 有序链表转换BST

当把给定的`有序数组`换为`有序链表`时，难度就发生了一些变化。[题解](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/)

首先我们当然能想到，只要把有序链表转换为有序数组，就可以利用有序数组的方法来完成。这是相当简单的，且时间复杂度也能控制在$$O(n)$$时间内。但美中不足的是，我们需要额外的$$O(n)$$的空间来存储转换的有序数组。

那是否有方法不转换数组，直接在链表上操作呢？

答案当然是有的，那就是——**递归**（*分治*）

## 分治

仿照之前的思想，我们每次找到链表的中位节点并作为根，分别对链表左边的部分与右边的部分建立子树，便完成了本题。

```java
public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
```

时间复杂度$$O(n~log~n)$$，解决了需求。当然，还可以优化：

## 优化

寻找中位数节点带来了大量时间复杂度。如果我们将分治与中序遍历结合，就可以减少时间复杂度。

***具体地说：***

+ 链表是有序的。我们不能从一个节点返回之前的节点，但是，我们可以利用递归，暂时不给之前的节点**赋值**，而是使用一个***占位***节点，在它的子节点完成赋值之后，再给它赋值。

+ 这种方法是巧妙的，巧妙的利用了递归栈与全局指针。

```java
ListNode ghead;
	public TreeNode sortedListToBST(ListNode head) {
		ListNode node = head;
		int len=0;
		while(node!=null) {
			len++;
			node=node.next;
		}
		ghead = head;
		return helper(0,len-1);
    }
	public TreeNode helper(int left,int right) {
		if(left>right) return null;
		int idx = (left+right+1)/2;
		TreeNode node = new TreeNode();
		node.left = helper(left,idx-1);
		node.val = ghead.val;
		ghead = ghead.next;
		node.right = helper(idx+1,right);
		return node;
	}
```

