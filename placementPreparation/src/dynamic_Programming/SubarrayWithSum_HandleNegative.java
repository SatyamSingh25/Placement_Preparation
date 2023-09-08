package dynamic_Programming;

import java.util.*;

public class SubarrayWithSum_HandleNegative {
	
	public static ArrayList<Integer> subarrayWithSum_negativeValue(int[] arr, int sum){
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int start = -1;
		int end = 0;
		int currSum = 0;
		
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			currSum += arr[i];
			
			//it means we ahve subarray from 0 index to i
			if(currSum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			
			// if hashMap already has the value, means we
			// have remaining number in hashmap which is needed, with its starting index so
			// the subarray will start from there. so, 
			// we have subarray with the sum - so stop
			if(map.containsKey(currSum - sum)) {
				start = map.get(currSum - sum)+1;
				end = i;
				System.out.println((currSum - sum)+" -> "+start + "-" + end);
				break;
			}
			
			map.put(currSum, i);
			System.out.println(map);
		}
		if(start == -1) {
			res.add(-1);
			return res;
		}
		
		res.add(start);
		res.add(end);
		
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {-2,4,4,7};
		int sum = 11;
		System.out.println(subarrayWithSum_negativeValue(arr, sum));
	}

}
