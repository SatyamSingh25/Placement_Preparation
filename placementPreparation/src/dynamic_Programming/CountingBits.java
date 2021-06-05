package dynamic_Programming;
import java.util.Scanner;
/**
 * @contributed_by Satyam Singh
 * -----------------------LEETCODE 338-----------------------------------
 * Problem link : https://leetcode.com/problems/counting-bits/
 * Discription : Given an integer n, return an array ans of length n + 1
 *               such that for each i (0 <= i <= n), ans[i] is the number
 *               of 1's in the binary representation of i.
 * 
 * Difficulty : Easy
 */
public class CountingBits {
	//counting bits
	//LEETCODE method 
	public static int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<=n ;i++){
            arr[i] = Integer.bitCount(i);  //counting number if 1s bits in current number ot index value;
        }
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = countBits(sc.nextInt());
		for(int i:arr) {
			System.out.print(i+ " ");
		}
		
	}

}
