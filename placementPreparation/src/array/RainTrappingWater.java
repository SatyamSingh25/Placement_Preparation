package array;
import java.util.*;
public class RainTrappingWater {
	
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

	public static void main(String[] args) {
		int[] buildings = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(maxTrapWater(buildings)); //result = 6
		
		buildings = new int[] {4,2,0,3,2,5};
		System.out.println(maxTrapWater(buildings)); //result = 9
	}

}
