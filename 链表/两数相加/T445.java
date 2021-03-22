package leetcode;
import java.util.Deque;
import java.util.LinkedList;
public class T445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new LinkedList<Integer>();
		Deque<Integer> stack2 = new LinkedList<Integer>();
		Deque<Integer> stack = new LinkedList<Integer>();
		while (l1!=null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2!=null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int add = 0;
		while(!stack1.isEmpty()&&!stack2.isEmpty()) {
			int item = stack1.pop()+stack2.pop()+add;
			if (item>=10) {
				add = 1;
				item -= 10;
			}
			else {
				add = 0;
			}
			stack.push(item);
		}
		while(!stack1.isEmpty()) {
			int item = stack1.pop()+add;
			if (item>=10) {
				add = 1;
				item -= 10;
			}
			else {
				add = 0;
			}
			stack.push(item);
		}
		if (add==1) {
			stack.push(add);
		}
		while(!stack2.isEmpty()) {
			int item = stack2.pop()+add;
			if (item>=10) {
				add = 1;
				item -= 10;
			}
			else {
				add = 0;
			}
			stack.push(item);
		}
		
		ListNode head = new ListNode(stack.pop());
		if (stack.isEmpty()) {
			return head;
		}
		ListNode node = head;
		while(!stack.isEmpty()) {
			node.next = new ListNode(stack.pop());
			node = node.next;
		}
		return head;
    }
}
