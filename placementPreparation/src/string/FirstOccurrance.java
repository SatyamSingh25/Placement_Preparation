package string;

public class FirstOccurrance {
	
	public static int firstOccurranceIndex(String str1, String str2) {
		
		int l1 = str1.length();
		int l2 = str2.length();
		int ind = 0;
		
		for(int i=0; i<l1; i++) {
			if(str1.charAt(i) == str2.charAt(ind)) {
				ind++;
			}
			else {
				i = i - ind; //go back till step, which are matched
				ind = 0; //reseting
			}
			
			if(ind == l2) {
				return i - ind + 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String str1 = "sadbutsad";
		String str2 = "sad";
		
		System.out.println(firstOccurranceIndex(str1, str2));
		System.out.println(firstOccurranceIndex("leetcode", "leeto"));
		System.out.println(firstOccurranceIndex("leetcode", "cod"));
		
	}

}
