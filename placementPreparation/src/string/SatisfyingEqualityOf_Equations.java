package string;
import java.util.*;
public class SatisfyingEqualityOf_Equations {

	static class Pair{
        HashSet<Character> equalTo;
        HashSet<Character> notEqualTo;
        Pair(){
            this.equalTo = new HashSet<>();
            this.notEqualTo = new HashSet<>();
        }
    }
	
	public static boolean equationsPossible(String[] equations) {
		 HashMap<Character, Pair> map = new HashMap<>();
	        
	        for(String eq: equations){
	            if(map.containsKey(eq.charAt(0))) { //Key found
	            	Pair currPair = map.get(eq.charAt(0));
	            	if(eq.substring(1, 3).equals("!=")) {
	            		currPair.notEqualTo.add(eq.charAt(3));
	            	}
	            	else if(eq.substring(1,3).equals("==")) {
	            		currPair.equalTo.add(eq.charAt(3));
	            	}
	            	map.put(eq.charAt(0), currPair);
	            }
	            else { //key not found
	            	Pair currPair = new Pair();
	            	if(eq.substring(1, 3).equals("!=")) {
	            		currPair.notEqualTo.add(eq.charAt(3));
	            	}
	            	else if(eq.substring(1,3).equals("==")) {
	            		currPair.equalTo.add(eq.charAt(3));
	            	}
	            	map.put(eq.charAt(0), currPair);
	            }
	        }
	        for(Map.Entry<Character, Pair> itr: map.entrySet()){
                System.out.print(itr.getKey() + "-> ");
                System.out.print("equal to: " + itr.getValue().equalTo + " ");
                System.out.println("Not equal to: " + itr.getValue().notEqualTo + " ");
            }
        
	        
	        for(Pair pair: map.values()){
	            for(char ch: pair.equalTo){
	                if(pair.notEqualTo.contains(ch)){
	                    return false;
	                }
	            }
	        }
	        return true;
	}
	
	public static void main(String[] args) {
		String[] equations = new String[] {"a==b","b!=a"};
		System.out.println(equationsPossible(equations));
	}

}
