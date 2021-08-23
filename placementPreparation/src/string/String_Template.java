package string;

import java.util.*;

public class String_Template {
	
	public static void main(String[] args){
		
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- != 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) {
            	arr[i] = sc.nextInt();
            }
            int q = sc.nextInt();
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i=0; i<q; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
				if(a==1){
					int left = 0;
					int right = n-1;
					while(left < right) {
						int temp = arr[left];
						arr[left] = arr[right];
						arr[right] = temp;
						left++;
						right--;
					}
				}
                if(a==2){
                    int temp = arr[b-1];
                    arr[b-1] = arr[c-1];
                    arr[c-1] = temp;
                }
                if(a==3){
                	int left = 0 ;
                	int right = n-1;
                	while(left <= right) {
                		if(arr[left] == b) {
                			res.add(left+1);
                			break;
                		}
                		else if(arr[right] == b) {
                			res.add(right+1);
                			break;
                		}
                		left++;
                		right--;
                	}
                }
            }
            for(int x: res) {
            	System.out.print(x+ " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
