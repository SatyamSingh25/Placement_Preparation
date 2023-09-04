package array;

import java.util.Arrays;

/**
 * @Min_BoatToSave_People
 * @unique_subsequence_of_size_2_which_with_sum_K
 * @Sorting
 * @TwoPointer_left_right
 * @Amazon_Uber_Salesforce_intuit
 */
/* -------------------------------881. Boats to Save People--------------------------------------------------
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * 
 * Return the minimum number of boats to carry every given person.
 */
public class BoatToSave_People {
	
	public int minBoatToSave(int[] people, int boatCapacity) {
		int boatCount = 0;
		/* sorting because we need 2 people max in array so,
		 * we are getting min and max at time 
		 */
		Arrays.sort(people);
		
		int left = 0;
		int right = people.length-1;
		
		while(left <= right) {
			int sum = people[left] + people[right];
			if(sum <= boatCapacity) {
				boatCount++;
				left++;
				right--;
			}
			else {
				boatCount++;
				right--;
			}
		}
		return boatCount;
	}

	public static void main(String[] args) {
		BoatToSave_People obj = new BoatToSave_People();
		
		System.out.println(obj.minBoatToSave(new int[] {1,2}, 3)); //1 boat is required
		System.out.println(obj.minBoatToSave(new int[] {3,2,2,1}, 3)); //3 boat is required
		System.out.println(obj.minBoatToSave(new int[] {3,5,3,4}, 5)); //4 boat is required
	}

}
