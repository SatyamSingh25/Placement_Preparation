package greedy;
/**
 * @StriverSheet
 * @Greedy
 * @Sort_cookie_and_greeders
 * Problem : Assume you are an awesome parent and want to give your children some cookies. 
 *           But, you should give each child at most one cookie.
 *           
 *           Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; 
 *           and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i,
 *           and the child i will be content. 
 *           
 *           Your goal is to maximize the number of your content children and output the maximum number.
 * Input :
 * greeders = {1,5,3,3,4}
 * Cookies = {4,2,1,2,1,3}
 * 
 * Output = 3
 */
import java.util.*;
public class _7_Assign_Cookies {
	
	//Approach
	// TC : O(nlog(n) + mlog(m) + n)
	// TC : O(1)
	public static int maxCokiesAssignment(int[] greeders, int[] cookies) {
		Arrays.sort(greeders);
		Arrays.sort(cookies);
		
		int cookey = 0, greed = 0;
		
		while(greed < greeders.length && cookey < cookies.length) {
			if(cookies[cookey] >= greeders[greed]) {
				greed++;
			}
			cookey++;
		}
		
		return greed;
	}

	//Driver code
	public static void main(String[] args) {
		System.out.println(maxCokiesAssignment(new int[] {1,5,3,3,4}, new int[] {4,2,1,2,1,3})); //3 
	}

}
