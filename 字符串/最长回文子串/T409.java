package leetcode;
import java.util.*;
public class T409 {
	public int longestPalindrome(String s) {
		int res = 0;
		Map<Character,Integer> dict = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++) {
			dict.put(s.charAt(i), dict.getOrDefault(s.charAt(i), 0)+1);
		}
		for(Character c:dict.keySet()) {
			res+=(dict.get(c)/2)*2;
		}
		if (res<s.length()) res++;
		return res;
    }
}
