package array;

public class MajorityElementNby2 {
	
	public static int findMajority(int[] arr) {
		int element = 0;
		int count = 0;
		
		for(int num: arr) {
			if(count == 0) {
				count++;
				element = num;
			}
			else if(num == element) {
				count++;
			}
			else {
				count--;
			}
		}
		if(count == 0) return -1;
		return element;
	}
	
	public static boolean Nby2(int[] arr, int element) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == element) {
				count++;
				if(Math.ceil(arr.length/2) == count)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,1,1,1,2,3,1,1,1,2};
		
		System.out.println(findMajority(arr));
		
		int majorityValue = findMajority(arr);
		System.out.println("MajorityValue : " + majorityValue); 
		System.out.println("Is come N by 2: " + Nby2(arr, majorityValue));
	}

}
