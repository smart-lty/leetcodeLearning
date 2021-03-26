package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T501 {
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
}
