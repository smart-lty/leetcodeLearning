package leetcode;
import java.util.Stack;
public class T20 {
/*
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

 */
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
        	if (stack.empty()) {
        		stack.push(s.charAt(i));
        		continue;
        	}
        	if (s.charAt(i)==')' && stack.peek()=='(') {
        		stack.pop();
        	}
        	else if (s.charAt(i)==']' && stack.peek()=='[') {
        		stack.pop();
        	}
        	else if (s.charAt(i)=='}' && stack.peek()=='{') {
        		stack.pop();
        	}
        	else {
        		stack.push(s.charAt(i));
        	}
        }
        return stack.empty();
    }
}
