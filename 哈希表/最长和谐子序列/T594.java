package leetcode;
import java.util.*;
public class T594 {
	public int findLHS(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		//ͳ��ÿ���ַ�����Ŀ
		for(int num:nums) {
			map.put(num,map.getOrDefault(num, 0)+1 );
		}
		int l = 0;
		for(int key:map.keySet()) {
			if(map.containsKey(key+1)) {
				l = Math.max(l,map.get(key)+map.get(key+1));
			}
		}
		return l;
    }
}
