/**
 * @author Satyam
 * Problem statement: Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * 					  -> WordDictionary() Initializes the object.
 *                    -> void addWord(word) Adds word to the data structure, it can be matched later
 *                    -> boolean search(word) Returns true if there is any string in the data structure that matches word or false otherwise. 
 *                       word may contain dots '.' where dots can be matched with any letter.
 *           
 * Difficulty: Medium [Leetcode 211]
 * Tag: Trie
 */

package string;
public class WordDictionary {
	
	WordDictionary[] childrens;
	boolean isEnd;
	//constructor
	public WordDictionary() {
		childrens = new WordDictionary[26];
		isEnd = false;
	}
	//Adding a word
	public void addWord(String word) {
		WordDictionary curr = this;
		for(char ch: word.toCharArray()) {
			if(curr.childrens[ch-'a'] == null) {
				curr.childrens[ch-'a'] = new WordDictionary();
			}
			curr = curr.childrens[ch-'a'];
		}
		curr.isEnd = true;
	}
	//searching a word in trie ".ab" -> means a letter word where '.' can be any letter
	public boolean search(String word) {
		WordDictionary curr = this;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(ch == '.') {
				for(WordDictionary currWordDictionary: curr.childrens) {
					if(currWordDictionary!= null && currWordDictionary.search(word.substring(i+1))) {
						return true;
					}
					return false;
				}
			}
			else if(curr.childrens[ch-'a'] == null) {
				return false;
			}
			curr = curr.childrens[ch-'a'];
		}
		return curr.isEnd;
	}
}
