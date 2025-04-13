package stack;
/**
 * @StriverSheet
 * @NextGreaterElement2
 * @Circular_array
 */
import java.util.*;
public class NextGreaterElement2 {
	
	//Approach
	public static int[] nextGreaterElement2(int[] arr) {
		int n = arr.length;
		int[] result = new int[arr.length]; //new array coz no need to change in current input
		Stack<Integer> stack = new Stack<>(); //monotonic stack approach
		
		int idx = 2 * n - 1; //assuming double array
		while(idx >= 0) {
			
			while(!stack.isEmpty() && stack.peek() <= arr[idx % n])
				stack.pop();
			
			if(idx < n)
				result[idx] = stack.isEmpty() ? -1 : stack.peek();
			
			stack.push(arr[idx % n]);
			idx--;
		}
		
		return result;
	}
	
	//Driver Code
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElement2(new int[] {5,7,1,7,6,0})));
		//[7,-1,7,-1,7,5]
	}

}
