package array;
public class InsertAtPosition {
	
	public static int insertAtPosition(int[] arr, int k) {
		int start = 0, end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] < k) 
				start = mid + 1;
			else
				end = mid - 1;
		}
		return start;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2,3,5,6,78};
		int k = 4;
		
		System.out.println("Insert 4 at index : " + insertAtPosition(arr, k));
	}

}
