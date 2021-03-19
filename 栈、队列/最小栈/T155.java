package leetcode;
import java.util.Stack;
public class T155 {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	/** initialize your data structure here. */
    public T155() {

    }
    
    public void push(int x) {
    	if (stack.isEmpty()) {
    		stack.push(x);
    		minStack.push(x);
    	}
    	else {
    		stack.push(x);
    		int min = x > minStack.peek() ? minStack.peek():x;
    		minStack.push(min);
    	}
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();

    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}
