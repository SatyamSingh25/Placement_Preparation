package string;
/**
 * @CountNumber_of_Palindrome_substring_are_possible
 * @DP
 * @2D_DP
 *
 */
public class CountAll_Palindromic_Substring {
	
	public static int countPalindromic_Substring(String str) {
		boolean[][] dp = new boolean[str.length()][str.length()];
		int count = 0;
		
		for(int g=0; g<str.length(); g++) {
			for(int i=0, j=g; j<str.length(); i++, j++) {
				if(g==0) {
					dp[i][j] = true;
				}
				else if(g==1) {
					if(str.charAt(i) == str.charAt(j)) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}
				}
				else {
					if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true;
					}
					else {
						dp[i][j] = false;
					}	
				}
				if(dp[i][j] == true)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "aaa";
		//reuslt -> 6 [a, a, a, aa, aa, aaa]
		System.out.println(countPalindromic_Substring(str));
	}

}
