package stack;
/*
 * @StriverSheet
 * @NextGreaterElement_1
 * @MonotonicStack
 */
import java.util.*;
public class NextGreaterElement {
	//Approach
	public static int[] findNextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[arr.length];
		
		int i = arr.length-1;
		while(i >= 0) {
			while(!stack.empty() && stack.peek() <= arr[i])
				stack.pop();
			
			result[i] = stack.isEmpty() ? -1 : stack.peek();
			
			stack.push(arr[i]);
			i--;
		}
		return result;
	}

	//Driver Code
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findNextGreaterElement(new int[] {5,7,1,7,6,0})));
		//[7, -1, 7, -1, -1, -1]
	}

}
