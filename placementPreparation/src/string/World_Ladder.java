package string;
import java.util.*;
public class World_Ladder {

	private static int countSteps_BeginWord_To_TargetWord(String beginWord, String endWord, String[] wordList) {
		int count = 0;
		HashSet<String> set = new HashSet<>();
		for(String str: wordList)
			set.add(str);
		
		if(set.contains(endWord) == false)
			return 0;
		
		set.remove(beginWord);
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		
		while(queue.isEmpty()==false) {
			int size = queue.size();
			while(size-- != 0) {
				String curr = queue.poll();
				if(curr.equals(endWord))
					return count+1; //beacuse this level count is not added that my +1 is used
				
				//changing word
				System.out.println("current word: " + curr);
				for(int i=0; i<curr.length(); i++) {
//					System.out.println("current word: " + curr);
					char[] ch = curr.toCharArray();
					for(int j=0; j<26; j++) {
						ch[i] = (char)('a'+j);
						String newString = String.valueOf(ch);
						
						if(set.contains(newString)) {
//							System.out.println("changed valid word: " + newString);
							queue.offer(newString);
							set.remove(newString);
						}
					}
				}
			}
			System.out.println(queue);
			count++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = new String[] {"hot","dot","dog","lot","log","cog"};
		
		System.out.println(countSteps_BeginWord_To_TargetWord(beginWord, endWord, wordList));
	}
	/*
	 * 	current word: hit
		[hot]
		current word: hot
		[dot, lot]
		current word: dot
		current word: lot
		[dog, log]
		current word: dog
		current word: log
		[cog]
		5
	 */
	
}
