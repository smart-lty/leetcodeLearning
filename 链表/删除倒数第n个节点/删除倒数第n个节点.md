# 删除倒数第n个节点

本题实际上使用的是链表经常使用的一种手段，快慢指针。

使`fast`指针比`slow`指针早移动***n***步，在`fast`指针到达尾部时，`slow`指针则会指向倒数第***n+1***个节点，此时删除节点便很方便。

```java
slow.next = slow.next.next
```



类似的问题有：*判断链表是否有环*，同样是设置快慢指针，控制它们的移动速度，判断它们相遇时同为`null`还是非空，即可判断链表是否有环。

[题解](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/)