package array;
import java.util.*;
public class RainTrappingWater {
	
	//TC : O(3N)
	//Sc : O(2N)
	public static int maxTrapWater(int[] buildings) {
		int size = buildings.length;
		int[] leftMax = new int[size];
		int[] rightMax = new int[size];
		
		leftMax[0] = buildings[0];
		for(int i=1; i<size; i++) {
			leftMax[i] = Math.max(leftMax[i-1], buildings[i]);
		}
		
		rightMax[size-1] = buildings[size-1];
		for(int i=size-2; i>=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], buildings[i]);
		}
		
		int unitOfWaterStored = 0;
		for(int i=0; i<size; i++) {
			unitOfWaterStored += Math.min(rightMax[i], leftMax[i])-buildings[i];
		}
		
		return unitOfWaterStored;
	}
	
	//TC : O(n)
	//SC : O(1)
	public static int maxWaterTrap(int[] arr) {
		int n = arr.length;
		
		int left = 1, right = n-1;
		int leftMax = arr[0];
		int rightMax = arr[n-1];
		int res = 0;
		
		while(left<=right) {
			if(leftMax >= rightMax) {
				res = res + Math.max(0, rightMax - arr[right]);
				rightMax = Math.max(rightMax, arr[right]);
				right--;
			}
			else {
				res = res +  Math.max(0, leftMax - arr[left]);
				leftMax = Math.max(leftMax, arr[left]);
				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] buildings = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(maxTrapWater(buildings)); //result = 6
		
		buildings = new int[] {4,2,0,3,2,5};
		System.out.println(maxTrapWater(buildings)); //result = 9
		
		//O(1) space
		System.out.println(maxWaterTrap(new int[] {2,1,5,3,1,0,4})); //result = 9
	}

}
