package array;
import java.util.*;
public class MinDifference {
	public static int minDiff(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
	    if(arr1 == null || arr2 == null) {
		    return -1;
		}
		if(arr1.size() == 0 || arr2.size() == 0) {
		    return -1;
	    }
		
	    int minDiff = Integer.MAX_VALUE;
	    int i = 0, j =0;
	    
	    while(i < arr1.size() && j < arr2.size()) {
		    int diff = Math.abs(arr1.get(i) - arr2.get(j)); //absolute difference
		    if(diff == 0) 
		    	return 0;
		    
	        minDiff = (diff < minDiff)?diff : minDiff;
	        if(arr1.get(i) < arr2.get(j)) {
	            i++;
	        } else {
	            j++;
	        }
	    }
	    
	    //means J has been reached to End in array 2 and I not
	    while(i < arr1.size()) {
	    	int end = arr2.size() - 1;
	        int diff = Math.abs(arr1.get(i++) - arr2.get(end));
	        minDiff = (diff < minDiff) ? diff : minDiff;
	    }
	    
	    //means I has been reached to End in array 2 and J not
	    while(j < arr2.size()) {
	    	int end = arr1.size()- 1;
	    	int diff = Math.abs(arr1.get(end) - arr2.get(j++));
	    	minDiff = (diff < minDiff) ? diff : minDiff;
	    }
	    
	    if(minDiff == Integer.MAX_VALUE) {
        	return -1;
        }
	    return minDiff;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n2 = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr2= new ArrayList<>();
		for(int i=0; i<n; i++) {
			int t = sc.nextInt();
			arr.add(t);
		}
		for(int i=0; i<n2; i++) {
			int t = sc.nextInt();
			arr2.add(t);
		}
		
		int min = minDiff(arr, arr2);	
		System.out.println(min);
		sc.close();
	}

}
