package leetcode;

public class T647 {
	public int countSubstrings(String s) {
        //ÖÐÐÄÀ©Õ¹
		int res = 0;
		int n = s.length();
		int l,r;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=1;j++) {
				l=i;
				r=i+j;
				while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)) {
					res++;
					l--;
					r++;
				}
			}
		}
		return res;
    }
}
