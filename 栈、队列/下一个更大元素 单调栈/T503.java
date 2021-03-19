package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class T503 {
	public int[] nextGreaterElements(int[] nums) {
		int length = nums.length;
        int[] ans = new int[length];
        for(int i=0;i<ans.length;i++) ans[i] = -1;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length*2; i++) {
            int num = nums[i%length];
            while (!stack.isEmpty() && num > nums[stack.peek()%length]) {
                int prevIndex = stack.pop();
                ans[prevIndex%length] = nums[i%length];
            }
            stack.push(i);
        }
        return ans;
    }
}
