package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			numbers.add(sc.nextInt());
		}
	
		int count = 0;
		//counting frequency
		HashMap<Integer,Integer> arr = new HashMap<>();
		for(int i: numbers) {
			arr.put(i, arr.getOrDefault(i,0)+1);
		}
		//iterating over the map
		for(Map.Entry<Integer, Integer> iter: arr.entrySet()) {
			int val = iter.getValue();
			if(val>1) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}

}
