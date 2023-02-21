package binary_Tree;
/**
 * Leetcode 331
 * Verify Preorder Serialization of a Binary Tree
 * 
 * Hint:  varify vacacncie/opportunites
 */
import java.util.*;
public class Validate_Preorder_Serialization {
	
	//Time: O(n) Spcae: O(n)
	public static boolean validatePreorder_Traversal_String(String preorder) {
		String[] str = preorder.split(",");
		
		int vacancies = 1; //initially there always a 1 vacancy due to root node
		for(int i=0; i<str.length; i++) {

			//if current node is "#" which is stated as NULL so we have to decrese the vacancy by 1 because we are filling position node
			if(str[i].equals("#")) { //here we are just filling 1 opportunity
				vacancies--;
				if(vacancies < 0) return false; 
			}
			else { 
				vacancies--; // not null node is also filling 1 opportunity
				if(vacancies < 0) return false;
				
				vacancies += 2; //current node is NOT NULL so we are creating 2 more opportunities
			}
		}
		
		return vacancies == 0 ? true : false;
	}

	//main method
	public static void main(String[] args) {
		String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(validatePreorder_Traversal_String(str)); //True
		
		str = "1,#";
		System.out.println(validatePreorder_Traversal_String(str)); //False
		
		str = "9,#,#,1";
		System.out.println(validatePreorder_Traversal_String(str)); //False
	}

}
