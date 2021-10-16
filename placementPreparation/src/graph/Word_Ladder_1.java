package graph;
/**
 * @Word_Ladder_1
 * @BFS @queue @visited_Map @Graph
 * @Hard
 * @GFG
 */
/*
 * Conditions: 
 * 		1. A word can only consist of lowercase characters.
		2. Only one letter can be changed in each transformation.
		3. Each transformed word must exist in the wordList including the targetWord.
		4. startWord may or may not be part of the wordList.
 */
//https://practice.geeksforgeeks.org/problems/word-ladder/0/?track=amazon-graphs&batchId=192
import java.util.*;
public class Word_Ladder_1 {
	
	public static int wordLeddarLength(String startWord, String targetWord, String[] wordList) {
		//targetWord is not present in wordList then there is no way to go targetWord
		boolean flag = false;
		for(int i=0; i<wordList.length; i++) {
			if(targetWord.equals(wordList[i])) {
				flag = true;
			}
		}
		if(flag == false)
			return 0;

		//visited Map
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		for(String i: wordList) {
			visitedMap.put(i, false);
		}
		
		//queue
		Queue<String> queue = new LinkedList<>();
		queue.offer(startWord);
		visitedMap.put(startWord, true);
		//getting the level of node
		int length = 1;
		
		while(queue.isEmpty()==false) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				String curr = queue.poll();
				
				if(curr.equals(targetWord)) {
					return length;
				}
				//wordChange
				wordChange(curr, queue, visitedMap);
			}
			length++;//increasing length level-wise
		}
		//if not possible to make startWord to targetWord
		return 0;
	}
	
	public static void wordChange(String curr, Queue<String> queue, HashMap<String, Boolean> visitedMap) {
		for(int i=0; i<curr.length(); i++) {
			char[] currCh = curr.toCharArray();
			for(int j=0; j<26; j++) {
				currCh[i] = (char)('a'+j);
				String updatedString = String.valueOf(currCh);
				if(visitedMap.containsKey(updatedString) && visitedMap.get(updatedString)==false) {
					visitedMap.put(updatedString, true);
					queue.offer(updatedString);
				}
			}
		}
	}
	public static void main(String[] args) {
		String startWord = "der";
		String targetWord = "dfs";
		String[] wordList = {"des","der","dfr","dgt","dfs"};
		
		//find shortest path from startWord to targetWord
		System.out.println(wordLeddarLength(startWord, targetWord, wordList));
		//output = 3
	}

}
