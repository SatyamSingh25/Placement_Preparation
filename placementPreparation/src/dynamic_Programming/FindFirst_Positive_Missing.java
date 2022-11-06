package dynamic_Programming;
/**
 * @Dynamic_Programming
 * @Leetcode_Hard
 */

public class FindFirst_Positive_Missing {
	
	public static int findFirst_Positieve_Missing(int[] arr) {
		int size = arr.length;
		boolean foundOne = false; //if 1 is not present in array then 1 is the answer
		
		for(int i=0; i<size; i++) {
			if(arr[i] ==  1)
				foundOne = true;
			if(arr[i] <= 0  || arr[i] > size) 
				arr[i] = 1;
		}
		
		if(foundOne == false) return 1;
		if(size == 1) return 2; //arr size 1 and arr[0] == 1 then result has to be 2
		
		//going to index-1 what value found in arr[i] make make it -ve, if its +ve
		for(int i: arr) {
			int updateIndex = Math.abs(i)-1; //abs is because -3 index is available so we use 3
			
			if(arr[updateIndex] > 0)
				arr[updateIndex] *= -1; //making elemenet index value element negative
		}
		
		//which first positive ingteger found then that index+1(position) is smallest possitice missing number 
		for(int i=0; i<size; i++) {
			if(arr[i] > 0)
				return i+1;
		}
		
		//all element are present in array from 1 to n(size) so the answer is size+1
		return size + 1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,0};
		System.out.println(findFirst_Positieve_Missing(arr)); //result -> 3
		
		arr = new int[] {3,4,-1,1};
		System.out.println(findFirst_Positieve_Missing(arr)); //result -> 2
		
		arr = new int[] {7,8,9,11,12};
		System.out.println(findFirst_Positieve_Missing(arr)); //result -> 1
		
		arr = new int[] {2,1};
		System.out.println(findFirst_Positieve_Missing(arr)); //result -> 3
	}

}
