package array;
import java.util.*;
/**
 * Counting/Printing all subsets of an array
 * @Contributor Satyam Singh
 */
public class Subsets {
	public static List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}
	public static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{4,2,3,15};
		System.out.println(subset(arr));
	}
	
}
