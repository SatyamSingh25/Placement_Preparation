package string;

public class ShortestPalindrome {
	
	public static String shortestPalindrome(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		String t = s + "#" + reverse;
		int[] lps = new int[t.length()];
		
		solve(t, lps);
		
		String extra = s.substring(lps[lps.length-1]);
		return new StringBuilder(extra).reverse().toString() + s;
	}
	
	public static void solve(String t, int[] lps) {
		int i = 0, j = 1;
		
		while(j < lps.length) {
			if(t.charAt(i) == t.charAt(j)) {
				i++;
				lps[j] = i;
				j++;
			}
			else {
				if(i == 0) {
					j++;
				}
				else {
					i = lps[i-1];
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "aacecaaa";
		System.out.println(shortestPalindrome(s));
	}

}
