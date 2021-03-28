package leetcode;
import java.util.*;
public class T648 {
	public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<String>();
        for(String root:dictionary) {
        	dict.add(root);
        }
        String res="";
        for(String word:sentence.split(" ")) {
        	String s = "";
        	for(int i = 0;i<word.length();i++) {
        		s+=word.charAt(i);
        		if (dict.contains(s)) break;
        	}
        	res+=s;
        	res+=" ";
        }
        return res.trim();
    }
}
