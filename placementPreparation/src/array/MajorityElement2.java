package array;
/**
 * @Majority_Element_Which_comes_n/3 time
 * @Moore_Voting_Algorithm Modification
 * @Leetcode_229
 */
import java.util.*;
public class MajorityElement2 {

	public static List<Integer> majorityElement(int[] arr) {
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(count1 == 0 && arr[i] != element2){
                count1++;
                element1 = arr[i];
            }
            else if(count2 == 0 && arr[i] != element1){
                count2++;
                element2 = arr[i];
            }
            else if(arr[i] == element1){
                count1++;
            }
            else if(arr[i] == element2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        //now check possible two number are > n/3 time or not
        int c1 = 0, c2 = 0;
        for(int num: arr){
            if(num == element1) c1++;
            if(num == element2) c2++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int threshold = (int)(arr.length/3)+1;
        if(c1 >= threshold) ans.add(element1);
        if(c2 >= threshold) ans.add(element2);

        return ans;
    }
	
	//Driver Code
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1,2,2,3,2})); //{2}
		System.out.println(majorityElement(new int[] {3,2,3})); //{3}
		System.out.println(majorityElement(new int[] {1})); //{1}
		System.out.println(majorityElement(new int[] {1,2})); // {1,2}
	}

}
