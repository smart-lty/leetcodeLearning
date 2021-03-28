# BST中序迭代器

该题要求以迭代器的形式输出BST的中序遍历。我们首先想到的方法肯定是在初始化时将BST中序遍历结果保存，但这样就不是真正符合需求的解法了——如果我们只调用一次，也要保存所有的结果吗？[题解](https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/fu-xue-ming-zhu-dan-diao-zhan-die-dai-la-dkrm/)(参考fuxuemingzhu大佬)

所以我们考虑通过迭代的形式，在调用`next`方法时，才去寻找所需要的结果。具体方法是：

- 首先我们将`root`及所有左节点入栈；

- 调用`next`方法时，出栈元素的值作为返回值；同时，我们要将出战元素的***右子树***的所有左节点入栈（为什么？）利用BST性质，实际上是维护了一个***单调栈***，这正与`BST中序遍历是有序的`这一事实相合！妙啊

  ```java
  import java.util.*;
  public class T173 {
  	Deque<TreeNode> stack = new LinkedList<TreeNode>();
  	public T173(TreeNode root) {
          TreeNode node = root;
          while(node!=null) {
          	stack.push(node);
          	node=node.left;
          }
      }
      
      public int next() {
      	TreeNode node = stack.pop();
      	if(node.right!=null) {
      		TreeNode p = node.right;
      		while(p!=null) {
      			stack.push(p);
      			p=p.left;
      		}
      	}
      	return node.val;
      }
      
      public boolean hasNext() {
      	return !stack.isEmpty();
      }
  }
  ```

  