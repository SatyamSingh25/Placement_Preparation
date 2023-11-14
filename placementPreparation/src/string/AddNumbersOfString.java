package string;

public class AddNumbersOfString {
	
	public static int addNumbersOfString(String s) {
		int sum = 0;
		int i = 0;
		
		while(i < s.length()) {
			if(!Character.isDigit(s.charAt(i)))
				i++;
			else {
				int currNum = 0;
				while(i<s.length() && Character.isDigit(s.charAt(i))) {
					currNum  = currNum * 10;
					currNum += (s.charAt(i) - '0');
					i++;
				}
				sum += currNum;
			}
		}
			
		return sum;
	}

	public static void main(String[] args) {
		String s = "aa234fsdfw1asfaf12qdasd";
		System.out.println(addNumbersOfString(s)); //234 + 1 + 12 = 247
	}

}
