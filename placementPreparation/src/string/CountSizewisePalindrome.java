package string;
import java.util.*;
public class CountSizewisePalindrome {
	public static boolean isPalindrome(String str, int start, int end){
        String substr = str.substring(start, end);
        int i=0, j=substr.length()-1;
        while(i<j){
            if(substr.charAt(i)==substr.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> partition(String s) {
        int len = s.length();
        ArrayList<List<String>> res = new ArrayList<>(((len*(len+1))/2)+1);
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(isPalindrome(s,i,j)){
                    int size = j-i;
                    res.get(size-1).add(s.substring(i,j));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	String s = "aab";
    	System.out.println(partition(s));
    }
}
