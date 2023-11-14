package fileReader;
import java.util.*;
import java.util.stream.Collectors;
public class FlatternList {
	
	public static List<Integer> flaterListOfList(List<List<Integer>> arr) {
		return arr.stream()
				.flatMap(List::stream)
				.sorted()
				.collect(Collectors.toList());
	}

	public static List<Integer> nestedListFlattern(List<Object> nestedList){
		List<Integer> res = new ArrayList<>();
		
		for(Object list: nestedList) {
			if(list instanceof List) {
				res.addAll(nestedListFlattern((List<Object>)list));
			}
			else if(list instanceof Integer) {
				res.add((Integer) list);
			}
		}
		
		res.sort(null);
		return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(List.of(2,4,3,4,7,3));
		arr.add(List.of(1,5,7));
		arr.add(List.of(8,4,2));
		
		System.out.println(arr);
		System.out.println(flaterListOfList(arr));
		
		List<Object> nestedList = new ArrayList<>();
		nestedList.add(List.of(4, 5, List.of(6, List.of(7, 8))));
		nestedList.add(List.of(1, List.of(2, 9, 10)));
		nestedList.add(3);
		
		System.out.println("Nested List flatterning");
		System.out.println(nestedList);
		System.out.println(nestedListFlattern(nestedList));

	}

}
