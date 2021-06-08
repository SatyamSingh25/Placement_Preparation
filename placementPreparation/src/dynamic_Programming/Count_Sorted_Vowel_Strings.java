package dynamic_Programming;
/**
 * @contributed_by Satyam Singh
 * -----------------------------------LEETCODE 1641---------------------------------------
 * Priblem link : https://leetcode.com/problems/count-sorted-vowel-strings/
 * Discription  : Given an integer n, return the number of strings of length n that 
 *                consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

                  A string s is lexicographically sorted if for all valid i,
                  s[i] is the same as or comes before s[i+1] in the alphabet.
         
      |N=1|             |N=2|                |N=3|           
       a=1               a=5                 a=15
       e=1               e=4                 e=10
       i=1               i=3                 i=6 
       o=1               o=2                 o=3
       u=1               u=1                 u=1
     ----------------------------------------------
total= |5|               |15|                |35|      
       
   Difficulty : Medium
 */
public class Count_Sorted_Vowel_Strings {
	
	public int countVowelStrings(int n) {
		//row = 5 = total number of vowel
		//n = size of string create only by the vowels and are lexicographically sorted.
        int[][] arr = new int[5][n];
        
        for(int i=0; i<5; i++){
            for(int j=0; j<n; j++){
            	//first row marking as 1
                if(i==0){
                    arr[i][j] = 1;
                }
                else if(j==0){ //first column mark as row number (i+1).
                    arr[i][j] = i+1;
                }
                else{ //previous row column sum in i,j.
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[4][n-1]; //result in the last column
	}
}
