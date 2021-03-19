package leetcode;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
public class T739 {
	/*
	public int[] dailyTemperatures(int[] T) {
		int n = T.length; // n ÌìÆøÎÂ
		int []res = new int[n];
		Stack<Tuple> stack = new Stack<Tuple>();
		stack.push(new Tuple(0,T[0]));
		for (int i=1;i<n;i++) {
			if (T[i]<=stack.peek().get2()) {
				stack.push(new Tuple(i,T[i]));
			}
			else {
				while (!stack.empty() && T[i]>stack.peek().get2()) {
					Tuple temp = stack.pop();
					res[temp.get1()] = i-temp.get1();
				}
				stack.push(new Tuple(i,T[i]));
			}
		}
		return res;
    }
	
	class Tuple{
		private int a;
		private int b;
		public Tuple(int x, int y) {
			a = x;
			b = y;
		}
		public int get1() {
			return a;
		}
		public int get2() {
			return b;
		}
	}*/
	public int[] dailyTemperatures(int[] T) {
		int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;

    }
}
