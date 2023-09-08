package string;

public class Count_Matching_subsequence {

	public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for(String str: words){
            int i=0, j=0;
            while(i < str.length() && j < s.length()){
                if(j < s.length() && str.charAt(i) == s.charAt(j)){
                    i++;
                }
                j++;
            }
            if(i >= str.length())
                count++;
        }
        return count;
    }
	public static void main(String[] args) {
		String[] words = new String[] {"a","bb","acd","ace"};
		
	}

}
